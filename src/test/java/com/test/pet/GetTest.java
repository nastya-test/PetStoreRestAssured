package com.test.pet;

import com.steps.pet.PetSteps;
import org.junit.jupiter.api.Test;

public class GetTest extends PetSteps {

    @Test
    public void TestMessagePetNotFound() {
        assertMessagePetNotFound().assertStatusPetNotFound();
    }

}
