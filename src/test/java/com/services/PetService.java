package com.services;

import com.models.Pet;
import com.models.response.AddPetResponse;
import io.restassured.response.Response;
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


    public AddPetResponse createPet(Pet rq){
        return given().spec(REQ_SPEC).body(rq).post().as(AddPetResponse.class);
    }

    public ValidatableResponse GetPetResponse (Integer id) {return given().spec(REQ_SPEC).pathParam("id", id).get(getPathParam()).then().log().all();}

}
