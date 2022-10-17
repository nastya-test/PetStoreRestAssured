package com.test.pet;

import com.steps.pet.PetSteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PetGetTest extends PetSteps {

    @Test
    @DisplayName("Проверка header, Content-type")
    public void TestResponsePet() {
        assertForResponse();
    }


    @Test
    @DisplayName("Поиск несуществующего животного")
    public void TestPetNotFound() {
        assertPetNotFound();
    }

    @Test
    @DisplayName("Поиск существующего животного")
    public void TestPetFound() {
        assertStatusPetFound().assertSchemaPetFound();
    }

    @Test
    @DisplayName("Поиск животного по невалидному Id")
    public void TestPetFoundWithInvalidId() {
        assertPetFoundWithInvalidId();
    }
}
