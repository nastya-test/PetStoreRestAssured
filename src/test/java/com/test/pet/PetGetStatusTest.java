package com.test.pet;

import com.models.Status;
import com.steps.pet.PetSteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class PetGetStatusTest extends PetSteps {

    @ParameterizedTest
    @EnumSource(Status.class)
    @DisplayName("Запрос по всем статусам")
    public void TestResponsePetAvailable(Status s) {
        assertPetFindByStatus(s).assertPetNameFindByStatus(s);
    }

    @Test
    @DisplayName("Вывод Pet в виде Map. Статус available")
    public void TestConsoleMapPet() {
        assertStatusPetFoundMap();
    }

}
