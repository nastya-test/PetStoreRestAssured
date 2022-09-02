package com.test.pet;

import com.test.RestTest;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.equalTo;

public class GetTest extends RestTest {

    public ValidatableResponse getPetWithBadId() {
        Integer badId = 116178;
        ValidatableResponse petResponse = api.getPetService()
                .GetPetResponse(badId);
        return petResponse;
    }

    @Test
    public void assertMessagePetNotFound() {
        getPetWithBadId().assertThat().body("message", equalTo("Pet not found"));
    }


}
