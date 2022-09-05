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
                        Tag.builder()
                                .withId(12345)
                                .withName("newTag")
                                .build(),
                        Tag.builder()
                                .withId(12346)
                                .withName("newTag2")
                                .build());
    }

    public static String getPetName() {
        return "Maxim";
    }

    public static List<String> getPhotoUrls() {
        return Arrays.asList(
                "photoUrl1",
                "photoUrl2");
    }

    public static String getPetId() {
        return "13";
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
        return Tag.builder()
                .withId(RandomGenerator.generateRandomInt())
                .withName(RandomGenerator.generateRandomString())
                .build();
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
                .withId(String.valueOf(getRandomPetId()))
                .withCategory(
                        getRandomPetCategory()
                ).withPhotoUrls(getRandomPetPhotoUrls())
                .withStatus(getRandomPetStatus())
                .withTags(getRandomPetTags())
                .build();
    }

    public static Pet getRandomRequiredPet() {
        return Pet.builder()
                .withName(getRandomPetName())
                .withPhotoUrls(getRandomPetPhotoUrls())
                .build();
    }

    public static Pet getRandomWithoutRequiredPet() {
        return Pet.builder()
                .withId(String.valueOf(getRandomPetId()))
                .withCategory(
                        getRandomPetCategory())
                .withStatus(getRandomPetStatus())
                .withTags(getRandomPetTags())
                .build();
    }

    public static Pet getNullPetPet() {
        return Pet.builder().build();
    }

}
