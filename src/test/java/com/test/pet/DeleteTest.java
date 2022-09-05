package com.test.pet;

import com.steps.pet.PetSteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DeleteTest extends PetSteps {
    @Test
    @DisplayName("Удаление существующего животного")
    public void TestDeletePetWithFoundId() {
        assertDeletePetFound();
    }

    @Test
    @DisplayName("Удаление несуществующего животного")
    public void TestDeletePetWithNotFoundId() {
        assertDeleteNotFound();
    }

    @Test
    @DisplayName("Удаление животного по невалидному id")
    public void TestDeletePetWithInvalidFoundId() {
        assertDeleteFoundWithInvalidId();
    }

    @Test
    @DisplayName("Повторное удаление животного")
    public void TestDeletePetRepeat() {
        assertDeletePetFoundRepeat();
    }
}
