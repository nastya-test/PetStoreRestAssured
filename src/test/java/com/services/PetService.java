package com.services;

import com.models.Pet;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class PetService extends RestService{

    @Override
    protected String getBasePath() {
        return "/pet";
    }

    @Override
    protected String getPathParam() {
        return "/{id}";
    }


    public
    ValidatableResponse createPet(Pet rq){
        return given().spec(REQ_SPEC).body(rq).post().then().spec(RES_SPEC);
    }

    public
    ValidatableResponse GetPetResponse (Integer id) {return given().spec(REQ_SPEC).pathParam("id", id).get(getPathParam()).then().spec(RES_SPEC);}

}
