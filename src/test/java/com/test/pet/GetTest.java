package com.test.pet;


import com.test.RestTest;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

public class GetTest extends RestTest {

    @Test()
    public void createRequiredPetField() {
        ValidatableResponse petResponse = api.getPetService()
                .GetPetResponse(11461);
    }
}
