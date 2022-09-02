//package com.services;
//
//import com.models.Order;
//import com.models.response.AddOrderResponse;
//
//import static io.restassured.RestAssured.given;
//
//public class OrderService extends RestService {
//
//    @Override
//    protected String getBasePath() {
//        return "/store/order";
//    }
//
//    public AddOrderResponse createOrder(Order rq){
//        return given().spec(REQ_SPEC).body(rq).post().as(AddOrderResponse.class);
//    }
//}
