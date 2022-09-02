package com.utils;

import com.models.User;

public class UserGenerator {

    public static Integer getUserId(){
        return 181;
    }

    public static String getUserUsername(){
        return "1456";
    }

    public static String getUserLastName(){
        return "Фамилия";
    }

    public static String getUserEmail(){
        return "newmail@mail.com";
    }

    public static String getUserPassword(){
        return "12345";
    }

    public static String getUserPhone(){
        return "88001234567";
    }

    public static Integer getUserUserStatus(){
        return 10;
    }

    public static User getFullFieldUser() {
        return User.builder()
                .id(getUserId())
                .username(getUserUsername())
                .lastName(getUserLastName())
                .email(getUserEmail())
                .password(getUserPassword())
                .phone(getUserPhone())
                .userStatus(getUserUserStatus())
                .build();
    }

    public static Integer getRandomUserId(){
        return RandomGenerator.generateRandomInt();
    }

    public static String getRandomUserUsername(){
        return RandomGenerator.generateRandomString();
    }

    public static String getRandomUserLastName(){
        return RandomGenerator.generateRandomString();
    }

    public static String getRandomUserEmail(){
        return RandomGenerator.generateRandomString();
    }

    public static String getRandomUserPassword(){
        return RandomGenerator.generateRandomString();
    }

    public static String getRandomUserPhone(){
        return RandomGenerator.generateRandomString();
    }

    public static Integer getRandomUserUserStatus(){
        return RandomGenerator.generateRandomInt();
    }

    public static User getRandomFullFieldOrder() {
        return User.builder()
                .id(getRandomUserId())
                .username(getRandomUserUsername())
                .lastName(getRandomUserLastName())
                .email(getRandomUserEmail())
                .password(getRandomUserPassword())
                .phone(getRandomUserPhone())
                .userStatus(getRandomUserUserStatus())
                .build();
    }
}
