package com.services;

import com.models.Pet;
import io.restassured.response.ValidatableResponse;

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


    public ValidatableResponse createPet(Pet rq) {
        return given()
                .spec(REQ_SPEC)
                .body(rq)
                .post()
                .then()
                .spec(RES_SPEC);
    }

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

    public ValidatableResponse DeletePetResponse(String id) {
        return given()
                .spec(REQ_SPEC)
                .spec(withParameter("id", id))
                .delete(getPathParam())
                .then()
                .spec(RES_SPEC);
    }

    public ValidatableResponse PutPetResponse(Pet rq) {
        return given()
                .spec(REQ_SPEC)
                .body(rq)
                .put()
                .then()
                .spec(RES_SPEC);
    }
}
