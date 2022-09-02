//package com.services;
//
//import com.models.User;
//import com.models.response.AddUserResponse;
//
//import static io.restassured.RestAssured.given;
//
//public class UserService extends RestService{
//    @Override
//    protected String getBasePath() {
//        return "/store/order";
//    }
//
//    public AddUserResponse createUser(User rq){
//        return given().spec(REQ_SPEC).body(rq).post().as(AddUserResponse.class);
//    }
//}
