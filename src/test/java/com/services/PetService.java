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
        return given()
                .spec(REQ_SPEC)
                .body(rq)
                .post()
                .then()
                .spec(RES_SPEC);
    }

    //Post исключение для "" в body
    public ValidatableResponse createPetWithNullBody(String rq) {
        return given()
                .spec(REQ_SPEC)
                .body(rq)
                .post()
                .then()
                .spec(RES_SPEC);
    }

    //Get о ID
    public ValidatableResponse GetPetResponse(String id) {
        return given()
                .spec(REQ_SPEC)
                .spec(withParameter("id", id))
                .spec(withHeader())
                .spec(withCookie())
                .get()
                .then()
                .spec(RES_SPEC);
    }

    //Get о статусу
    public ValidatableResponse GetPetStatusResponse(Status status) {
        return given()
                .spec(REQ_SPEC)
                .basePath(getBasePath() + "/findByStatus")
                .queryParam("status", status)
                .get()
                .then()
                .spec(RES_SPEC);
    }

    //Обычный Delete
    public ValidatableResponse DeletePetResponse(String id) {
        return given()
                .spec(REQ_SPEC)
                .spec(withParameter("id", id))
                .delete(getPathParam())
                .then()
                .spec(RES_SPEC);
    }

    //Обычный Put
    public ValidatableResponse PutPetResponse(Pet rq) {
        return given()
                .spec(REQ_SPEC)
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
        return mapPet;
    }
}
