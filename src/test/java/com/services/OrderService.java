package com.services;

import com.models.Order;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class OrderService extends RestService {

    @Override
    protected String getBasePath() {
        return "/store/order";
    }

    @Override
    protected String getPathParam() {
        return "/{orderId}";
    }

    public ValidatableResponse createOrder(Order rq){
        return given().spec(REQ_SPEC).body(rq).post().then().spec(RES_SPEC);
    }

    public ValidatableResponse GetOrderResponse (Integer id) {return given().spec(REQ_SPEC).pathParam("orderId", id).get(getPathParam()).then();}
}
