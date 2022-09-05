package com.test.pet;

import com.steps.pet.PetSteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PostTest extends PetSteps {

    @Test
    @DisplayName("Создание животного по всем заданным полям")
    public void TestFullPetCreate() {
        assertStatusFullPetCreate();
    }

    @Test
    @DisplayName("Создание животного со всеми рандомными полями")
    public void TestRandomFullPetCreate() {
        assertStatusRandomFullPetCreate();
    }

    @Test
    @DisplayName("Создание животного только с обязательными полями")
    public void TestRequiredPetCreate() {
        assertStatusRequiredPetCreate();
    }

    @Test
    @DisplayName("Создание животного без обязательных полей")
    public void TestWithoutRequiredPetCreate() {
        assertStatusWithoutRequiredPetCreate();
    }

    @Test
    @DisplayName("Создание животного c null во всех полях")
    public void TestNullPetCreate() {
        assertStatusNullPetCreate();
    }

    @Test
    @DisplayName("Создание одного и того же животного 2 раза")
    public void TestRepeatPetCreate() {

    }

    @Test
    @DisplayName("Создание животного с пустым body")
    public void TestEmptyPetCreate() {

    }

}
