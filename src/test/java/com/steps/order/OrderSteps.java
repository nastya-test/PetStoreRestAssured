package com.steps.order;

import com.models.Order;
import com.test.RestTest;
import com.utils.OrderGenerator;
import io.restassured.response.ValidatableResponse;

public class OrderSteps extends RestTest {

    public ValidatableResponse createRequiredPetField() {
        Order orderRequest = OrderGenerator.getFullFieldOrder();
        ValidatableResponse orderResponse = api.getOrderService()
                .createOrder(orderRequest);
        return orderResponse;
    }
}
