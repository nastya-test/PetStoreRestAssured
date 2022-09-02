package com.utils;

import com.models.Order;
import com.models.OrderStatus;
import com.models.Status;

import java.util.Random;

public class OrderGenerator {

    public static Integer getOrderId(){
        return 12345;
    }

    public static Integer getOrderPetId(){
        return 10;
    }

    public static Integer getOrderQuantity(){
        return 0;
    }

    public static String getOrderShipDate(){
        return "2022-09-02T09:26:18.172Z";
    }

    public static OrderStatus getOrderStatus(){
        return OrderStatus.approved;
    }

    public static Boolean getOrderComplete(){
        return true;
    }

    public static Order getFullFieldOrder() {
        return Order.builder()
                .id(getOrderId())
                .petId(getOrderPetId())
                .quantity(getOrderQuantity())
                .shipDate(getOrderShipDate())
                .status(getOrderStatus())
                .complete(getOrderComplete())
                .build();
    }

    public static Integer getRandomOrderId(){
        return RandomGenerator.generateRandomInt();
    }

    public static Integer getRandomOrderPetId(){
        return RandomGenerator.generateRandomInt();
    }

    public static Integer getRandomOrderQuantity(){
        return RandomGenerator.generateRandomInt();
    }

    public static String getRandomOrderShipDate(){
        return RandomGenerator.generateRandomString();
    }

    public static OrderStatus getRandomOrderStatus(){
        return OrderStatus.values()[new Random().nextInt(Status.values().length)];
    }

    public static Boolean getRandomOrderComplete(){
        return RandomGenerator.generateRandomBoolean();
    }

    public static Order getRandomFullFieldOrder() {
        return Order.builder()
                .id(getRandomOrderId())
                .petId(getRandomOrderPetId())
                .quantity(getRandomOrderQuantity())
                .shipDate(getRandomOrderShipDate())
                .status(getRandomOrderStatus())
                .complete(getRandomOrderComplete())
                .build();
    }

}
