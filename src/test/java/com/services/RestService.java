package com.services;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
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
               // .expectStatusCode(200)
                .log(LogDetail.BODY)
                .build();
    }

}
