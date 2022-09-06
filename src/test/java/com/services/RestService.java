package com.services;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

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

    public RequestSpecification withParameter(String key, String value){
        return new RequestSpecBuilder().setBasePath(getBasePath() + getPathParam()).addParam(key, value).build();
    }

    public RequestSpecification withHeader(){
        return new RequestSpecBuilder().addHeader("User-Agent", "MyAppName").build();
    }

    public RequestSpecification withCookie(){
        Cookie myCookie = new Cookie.Builder("session_id", "1234")
                .setSecured(true)
                .setComment("session id cookie")
                .build();
        return new RequestSpecBuilder().addCookie(myCookie).build();
    }


}
