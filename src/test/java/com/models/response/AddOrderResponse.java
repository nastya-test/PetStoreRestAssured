package com.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.models.OrderStatus;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddOrderResponse extends ApiResponse {
    private Integer id;
    private Integer petId;
    private Integer quantity;
    private String shipDate;
    private OrderStatus orderStatus;
    private Boolean complete;

    public AddOrderResponse(Integer id, Integer petId, Integer quantity, String shipDate, OrderStatus orderStatus, Boolean complete) {
        this.id = id;
        this.petId = petId;
        this.quantity = quantity;
        this.shipDate = shipDate;
        this.orderStatus = orderStatus;
        this.complete = complete;
    }

    public AddOrderResponse() {
    }

    public Integer getId() {
        return id;
    }

    public Integer getPetId() {
        return petId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getShipDate() {
        return shipDate;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", petId=" + petId +
                ", quantity=" + quantity +
                ", shipDate='" + shipDate + '\'' +
                ", orderStatus=" + orderStatus +
                ", complete=" + complete +
                '}';
    }

    public static Builder builder() {
        return Builder.createBuilder();
    }

    public static final class Builder {

        private AddOrderResponse addOrderResponse;

        private Builder() {
            addOrderResponse = new AddOrderResponse();
        }

        private static Builder createBuilder() {
            return new Builder();
        }

        public Builder id(Integer val) {
            addOrderResponse.setId(val);
            return this;
        }

        public Builder petId(Integer val) {
            addOrderResponse.setPetId(val);
            return this;
        }

        public Builder quantity(Integer val) {
            addOrderResponse.setQuantity(val);
            return this;
        }

        public Builder shipDate(String val) {
            addOrderResponse.setShipDate(val);
            return this;
        }

        public Builder orderStatus(OrderStatus val) {
            addOrderResponse.setOrderStatus(val);
            return this;
        }

        public Builder complete(Boolean val) {
            addOrderResponse.setComplete(val);
            return this;
        }

        public AddOrderResponse build() {
            return addOrderResponse;
        }
    }
}
