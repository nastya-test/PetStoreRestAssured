package com.steps.pet;

import com.models.Pet;
import com.test.RestTest;
import com.utils.PetGenerator;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class PetSteps extends RestTest {

    private static final String notFoundId = "1499198";
    private static final String validId = "1226";
    private static final String invalidId = "StringInvalidId";

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

    //PostStep
    public ValidatableResponse postPet(Pet generatePet) {
        ValidatableResponse petResponse = api.getPetService()
                .createPet(generatePet);
        return petResponse;
    }

    //DeleteStep
    public ValidatableResponse deletePetWithId(String id) {
        ValidatableResponse petResponse = api.getPetService()
                .DeletePetResponse(id);
        return petResponse;
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
        getPetWithId(validId).statusCode(200);
        return this;
    }

    public PetSteps assertSchemaPetFound() {
        getPetWithId(validId).assertThat().body(matchesJsonSchemaInClasspath("schema.json"));
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
        deletePetWithId(validId)
                .statusCode(200)
                .and()
                .body("message", equalTo(validId));
        return this;
    }

    public PetSteps assertDeletePetFoundRepeat() {
        deletePetWithId(validId)
                .statusCode(200);
        deletePetWithId(validId)
                .statusCode(404)
                .and()
                .body("type", equalTo("unknown"));
        return this;
    }


}
