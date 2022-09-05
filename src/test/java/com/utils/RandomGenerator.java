package com.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import java.util.Random;


public class RandomGenerator {
    public static String generateRandomString(){
        String randomText = RandomStringUtils.randomAlphabetic(10);
        return randomText;
    }

    public static int generateRandomInt(){
        int randomId = RandomUtils.nextInt(11000, 12000);
        return randomId;
    }

    public static Boolean generateRandomBoolean(){
        Random random = new Random();
        return random.nextBoolean();
    }

}
