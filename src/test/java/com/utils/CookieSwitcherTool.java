package com.utils;

import io.restassured.http.Cookie;
import io.restassured.specification.RequestSpecification;

public class CookieSwitcherTool {
    public static RequestSpecification enabhleAllCoockie(RequestSpecification req) {
        // вызорв запроса получение куки
        Cookie myCookie = new Cookie.Builder("session_id", "1234")
                .setSecured(true)
                .setComment("session id cookie")
                .build();
        req.cookie(myCookie);
        return req;
    }
}
