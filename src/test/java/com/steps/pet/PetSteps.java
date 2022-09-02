package com.steps.pet;

import com.test.RestTest;
import io.restassured.response.ValidatableResponse;

import static org.hamcrest.Matchers.equalTo;

public class PetSteps extends RestTest {

    public ValidatableResponse getPetWithBadId() {
        Integer badId = 116178;
        ValidatableResponse petResponse = api.getPetService()
                .GetPetResponse(badId);
        return petResponse;
    }

    public PetSteps assertMessagePetNotFound() {
        getPetWithBadId().assertThat().body("message", equalTo("Pet not found"));
        return this;
    }

    public PetSteps assertStatusPetNotFound() {
        getPetWithBadId().statusCode(400);
        return this;
    }
}
