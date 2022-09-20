package com.steps.pet;

import com.models.Pet;
import com.models.Status;
import com.test.RestTest;
import com.utils.PetGenerator;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import java.util.List;
import java.util.Map;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;


public class PetSteps extends RestTest {

    private static final String notFoundId = "1499198";

    private String validId() {
       return String.valueOf(getNewPetValidId());
    }

    private static final String invalidId = "StringInvalidId";
    private static final String petName = "doggie";

    private final Pet fullRandomPet = PetGenerator.getRandomFullPet();
    private final Pet fullPet = PetGenerator.getFullFieldPet();
    private final Pet nullPet = PetGenerator.getNullPetPet();
    private final Pet requiredRandomPet = PetGenerator.getRandomRequiredPet();
    private final Pet withOutRequiredRandomPet = PetGenerator.getRandomWithoutRequiredPet();

    //GetStep
    public ValidatableResponse getPetWithId(String id) {
        ValidatableResponse petResponse = api.getPetService()
                .GetPetResponse(id);
        return petResponse;
    }

    public ValidatableResponse getByPetStatus(Status status) {
        ValidatableResponse petResponse = api.getPetService()
                .GetPetStatusResponse(status);
        return petResponse;
    }

    public List<Map<String, Object>> getMapPet(Status status) {
        List<Map<String, Object>> petResponse = api.getPetService()
                .MapPetResponse(status);
        return petResponse;
    }

    public static Integer getNewPetValidId() {
        ValidatableResponse petResponse = api.getPetService()
                .createPet(PetGenerator.getRandomFullPet());
        return petResponse.extract().path("id");
    }

    //PostStep
    public ValidatableResponse postPet(Pet generatePet) {
        ValidatableResponse petResponse = api.getPetService()
                .createPet(generatePet);
        return petResponse;
    }

    public ValidatableResponse postPetWithEmptyBody() {
        ValidatableResponse petResponse = api.getPetService()
                .createPet("");
        return petResponse;
    }

    //DeleteStep
    public ValidatableResponse deletePetWithId(String id) {
        ValidatableResponse petResponse = api.getPetService()
                .DeletePetResponse(id);
        return petResponse;
    }

    //Assertions for response
    public PetSteps assertForResponse() {
        getPetWithId(validId()).assertThat()
                .contentType(ContentType.JSON)
                .header("Connection", "keep-alive");
        return this;
    }

    //Assertions for Get
    public PetSteps assertPetNotFound() {
        getPetWithId(notFoundId).assertThat()
                .statusCode(404)
                .and()
                .body("code", notNullValue())
                .and()
                .body("message", equalTo("Pet not found"));
        return this;
    }

    public PetSteps assertPetFoundWithInvalidId() {
        getPetWithId(invalidId)
                .statusCode(404)
                .and()
                .body("type", equalTo("unknown"));;
        return this;
    }

    public PetSteps assertStatusPetFound() {
        getPetWithId(validId()).statusCode(200);
        return this;
    }

    public PetSteps assertStatusPetFoundMap() {
        System.out.println(getMapPet(Status.available));
        return this;
    }

    public PetSteps assertSchemaPetFound() {
        getPetWithId(validId()).assertThat().body(matchesJsonSchemaInClasspath("schema.json"));
        return this;
    }

    public PetSteps assertPetFindByStatus(Status status) {
        getByPetStatus(status).statusCode(200);
        return this;
    }

    public PetSteps assertPetNameFindByStatus(Status status) {
        getByPetStatus(status).body("name", hasItems(petName));
        return this;
    }

    //Assertions for Post
    public PetSteps assertStatusRandomFullPetCreate() {
        postPet(fullRandomPet).statusCode(200);
        return this;
    }

    public PetSteps assertStatusFullPetCreate() {
        postPet(fullPet).statusCode(200);
        return this;
    }

    public PetSteps assertStatusNullPetCreate() {
        postPet(nullPet).statusCode(200);
        return this;
    }

    public PetSteps assertStatusRequiredPetCreate() {
        postPet(requiredRandomPet).statusCode(200);
        return this;
    }

    public PetSteps assertStatusWithoutRequiredPetCreate() {
        postPet(withOutRequiredRandomPet).statusCode(200);
        return this;
    }

    public PetSteps assertStatusEmptyPetCreate() {
        postPetWithEmptyBody()
                .statusCode(405)
                .and()
                .body("message", equalTo("no data"));
        return this;
    }

    //Assertions for Delete
    public PetSteps assertDeleteNotFound() {
        deletePetWithId(notFoundId).assertThat()
                .statusCode(404)
                .body(Matchers.anything());
        return this;
    }

    public PetSteps assertDeleteFoundWithInvalidId() {
        deletePetWithId(invalidId)
                .statusCode(404)
                .and()
                .body("type", equalTo("unknown"));
        return this;
    }

    public PetSteps assertDeletePetFound() {
        final String id = validId();
        deletePetWithId(id)
                .statusCode(200)
                .and()
                .body("message", equalTo(id));
        return this;
    }

    public PetSteps assertDeletePetFoundRepeat() {
        final String id = validId();
        deletePetWithId(id)
                .statusCode(200);
        deletePetWithId(id)
                .statusCode(404);
        return this;
    }


}
