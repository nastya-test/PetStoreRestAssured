package com.utils;

import com.models.Category;
import com.models.Pet;
import com.models.Status;
import com.models.Tag;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PetGenerator {

    private static List<Tag> getPetTags() {
        return
                Arrays.asList(
                new Tag(1821, "newTag1"),
                new Tag(1822, "newTag2"));
    }

    public static String getPetName() {
        return "Maxim";
    }

    public static List<String> getPhotoUrls() {
        return Arrays.asList(
                "photoUrl1",
                "photoUrl2");
    }

    public static Integer getPetId() {
        return 13;
    }

    public static int getRandomPetId() {
        return RandomGenerator.generateRandomInt();
    }

    public static Category getRandomPetCategory() {
        return
                Category.builder()
                        .withId(RandomGenerator.generateRandomInt())
                        .withName(RandomGenerator.generateRandomString())
                        .build();
    }

    public static String getRandomPetName() {
        return RandomGenerator.generateRandomString();
    }

    public static List<String> getRandomPetPhotoUrls() {
        return Arrays.asList(
                RandomGenerator.generateRandomString(),
                RandomGenerator.generateRandomString());
    }

    public static Tag getRandomPetTag() {
        return new Tag(RandomGenerator.generateRandomInt(), RandomGenerator.generateRandomString());
    }

    public static List<Tag> getRandomPetTags() {
        return Arrays.asList(
                getRandomPetTag(),
                getRandomPetTag());
    }

    public static Status getRandomPetStatus() {
        return Status.values()[new Random().nextInt(Status.values().length)];
    }

    public static Pet getFullFieldPet() {
        return Pet.builder()
                .withName(getPetName())
                .withId(getPetId())
                .withPhotoUrls(
                        getPhotoUrls()
                )
                .withTags(
                        getPetTags()
                )
                .build();
    }

    public static Pet getRandomFullPet() {
        return Pet.builder()
                .withName(getRandomPetName())
                .withId(getRandomPetId())
                .withCategory(
                        getRandomPetCategory()
                ).withPhotoUrls(getRandomPetPhotoUrls())
                .withStatus(getRandomPetStatus())
                .withTags(getRandomPetTags())
                .build();
    }

    public static Pet getEmptyPet() {
        return Pet.builder().build();
    }
}
