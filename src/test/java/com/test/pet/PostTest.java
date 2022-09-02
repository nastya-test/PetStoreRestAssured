package com.test.pet;

import com.models.Pet;
import com.models.response.AddPetResponse;
import com.test.RestTest;
import com.utils.PetGenerator;
import org.junit.jupiter.api.Test;

public class PostTest extends RestTest {

    @Test()
    public void createRequiredPetField() {
        Pet petRequest = PetGenerator.getRandomFullPet();
        AddPetResponse petResponse = api.getPetService()
                .createPet(petRequest);
        System.out.println(petResponse);
    }

}
