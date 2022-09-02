package com.test.order;

import com.models.Order;
import com.test.RestTest;
import com.utils.OrderGenerator;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

public class PostTest extends RestTest {
    @Test()
    public void createRequiredPetField() {
        Order orderRequest = OrderGenerator.getFullFieldOrder();
        ValidatableResponse orderResponse = api.getOrderService()
                .createOrder(orderRequest);
    }
}
