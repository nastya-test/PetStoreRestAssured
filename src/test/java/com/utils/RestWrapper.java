package com.utils;

import com.services.OrderService;
import com.services.PetService;

public class RestWrapper {

    public static RestWrapper prepare() {
        return new RestWrapper();
    }

    private PetService petService;
    private OrderService orderService;
//    private UserService userService;

    private RestWrapper() {
        petService = new PetService();
        orderService = new OrderService();
//        userService = new UserService();
    }

    public PetService getPetService() {
        return petService;
    }
    public OrderService getOrderService() {return orderService;}
//    public UserService getUserService() {return userService;}

}
