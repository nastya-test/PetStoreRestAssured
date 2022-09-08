package com.services;

import com.models.Pet;
import com.models.Status;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.ValidatableResponse;
import java.util.List;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class PetService extends RestService {

    @Override
    protected String getBasePath() {
        return "/pet";
    }

    @Override
    protected String getPathParam() {
        return "/{id}";
    }


    //Обычный Post
    public ValidatableResponse createPet(Pet rq) {
        return baseSpec()
                .body(rq)
                .post()
                .then()
                .spec(RES_SPEC);
    }

    //Post исключение для "" в body. Перегрузка
    public ValidatableResponse createPet(String rq) {
        return baseSpec()
                .body(rq)
                .post()
                .then()
                .spec(RES_SPEC);
    }

    //Get with ID (With header, with cookie)
    public ValidatableResponse GetPetResponse(String id) {
        return given()
                .spec(addHeader(addCookie(baseSpec())))
                .pathParam("id",id)
                .get(getPathParam())
                .then()
                .spec(RES_SPEC);
    }

    //Get with Status
    public ValidatableResponse GetPetStatusResponse(Status status) {
        return baseSpec()
                .basePath(getBasePath() + "/findByStatus")
                .queryParam("status", status)
                .get()
                .then()
                .spec(RES_SPEC);
    }

    //Обычный Delete
    public ValidatableResponse DeletePetResponse(String id) {
        return baseSpec()
                .pathParam("id",id)
                .delete(getPathParam())
                .then()
                .spec(RES_SPEC);
    }

    //Обычный Put
    public ValidatableResponse PutPetResponse(Pet rq) {
        return baseSpec()
                .body(rq)
                .put()
                .then()
                .spec(RES_SPEC);
    }

    //Можно преобразовать в Map. (Для примера)
    public List<Map<String, Object>> MapPetResponse(Status status) {
        List<Map<String, Object>> mapPet = given()
                .spec(REQ_SPEC)
                .basePath(getBasePath() + "/findByStatus")
                .queryParam("status", status)
                .get()
                .as(new TypeRef<List<Map<String, Object>>>() {
                });
        Map<String, Object> firstMapPet=mapPet.get(0);
        firstMapPet.entrySet().stream().forEach(x -> System.out.println(x));;
       // System.out.println(firstMapPet);
        return mapPet;
    }
}
