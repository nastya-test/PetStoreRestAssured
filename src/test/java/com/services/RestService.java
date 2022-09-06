package com.services;

import com.utils.CookieSwitcherTool;
import com.utils.HeaderSwitcherTool;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

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

    public RequestSpecification baseSpec(){
        return given().spec(REQ_SPEC);
    }

    public RequestSpecification addCookie(RequestSpecification req){
        return CookieSwitcherTool.enableAllCookie(req);
    }

    public RequestSpecification addHeader(RequestSpecification req){
        return HeaderSwitcherTool.enableAllHeader(req);
    }


}
