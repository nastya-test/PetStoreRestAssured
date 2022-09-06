package com.utils;

import io.restassured.specification.RequestSpecification;

public class HeaderSwitcherTool {
    public static RequestSpecification enableAllHeader(RequestSpecification req) {
        req.header("User-Agent", "MyAppName");
        return req;
    }
}
