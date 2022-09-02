package com.utils;

import com.models.Order;
import com.models.OrderStatus;
import com.models.Status;

import java.util.Random;

public class OrderGenerator {

    public static Integer getOrderId(){
        return 181;
    }

    public static Integer getOrderPetId(){
        return 10;
    }

    public static Integer getOrderQuantity(){
        return 10;
    }

    public static String getOrderShipDate(){
        return "29.08.2022";
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
                .orderStatus(getOrderStatus())
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
                .orderStatus(getRandomOrderStatus())
                .complete(getRandomOrderComplete())
                .build();
    }

}
