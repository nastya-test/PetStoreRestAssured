package com.test.pet;

import com.models.Pet;
import com.test.RestTest;
import com.utils.PetGenerator;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

public class PostTest extends RestTest {

    @Test()
    public void createRequiredPetField() {
        Pet petRequest = PetGenerator.getRandomFullPet();
        ValidatableResponse petResponse = api.getPetService()
                .createPet(petRequest);
    }

}
