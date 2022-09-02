package com.services;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public abstract class RestService {
    private static final String BASE_URL = "https://petstore.swagger.io/v2";

    protected RequestSpecification REQ_SPEC;
    protected ResponseSpecification RES_SPEC;

    protected abstract String getBasePath();
    protected abstract String getPathParam();

    public RestService(){

        REQ_SPEC = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setBasePath(getBasePath())
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();

        RES_SPEC = new ResponseSpecBuilder()
                .log(LogDetail.BODY)
                .build();
    }

//    public Map<String, Integer> addParam(String key, Integer value){
//        Map<String, Integer> params = new HashMap<String, Integer>();
//        params.put(key, value);
//        System.out.println(params);
//        return params;
//    }

    public RequestSpecification withParameter(String key, Integer value){
        return REQ_SPEC.basePath(getBasePath() + getPathParam()).pathParam(key, value);
    }

    public RequestSpecification withHeader(){
        return REQ_SPEC.header("User-Agent", "MyAppName");
    }

    public RequestSpecification withCookie(){
        Cookie myCookie = new Cookie.Builder("session_id", "1234")
                .setSecured(true)
                .setComment("session id cookie")
                .build();
        return REQ_SPEC.cookie(myCookie);
    }


}
