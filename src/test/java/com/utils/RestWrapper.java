package com.utils;

//import com.services.OrderService;
import com.services.PetService;
//import com.services.UserService;

public class RestWrapper {

    private static String BASE_URL = "https://petstore.swagger.io/v2";
    public static String getBaseUrl() {
        return BASE_URL;
    }
    public static void setBaseUrl(String baseUrl) {
        BASE_URL = baseUrl;
    }

    public static RestWrapper prepare() {
        return new RestWrapper();
    }

    private PetService petService;
//    private OrderService orderService;
//    private UserService userService;

    private RestWrapper() {
        petService = new PetService();
//        orderService = new OrderService();
//        userService = new UserService();
    }

    public PetService getPetService() {
        return petService;
    }
//    public OrderService getOrderService() {return orderService;}
//    public UserService getUserService() {return userService;}

    private void setPetService(PetService petService) {
        this.petService = petService;
    }
//    private void setOrderService(OrderService orderService) {
//        this.orderService = orderService;
//    }
//    private void setUserService(UserService userService) {
//        this.userService = userService;
//    }
}
