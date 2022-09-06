package com.models;

//import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {

    private Integer id;
    private Integer petId;
    private Integer quantity;
    private String shipDate;
    private OrderStatus status;
    private Boolean complete;

    public Order() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getShipDate() {
        return shipDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Boolean getComplete() {
        return complete;
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
                ", status=" + status +
                ", complete=" + complete +
                '}';
    }

    public static Builder builder() {
        return Builder.createBuilder();
    }

    public static final class Builder {

        private Order order;

        private Builder() {
            order = new Order();
        }

        private static Builder createBuilder() {
            return new Builder();
        }

        public Builder id(Integer val) {
            order.setId(val);
            return this;
        }

        public Builder petId(Integer val) {
            order.setPetId(val);
            return this;
        }

        public Builder quantity(Integer val) {
            order.setQuantity(val);
            return this;
        }

        public Builder shipDate(String val) {
            order.setShipDate(val);
            return this;
        }

        public Builder status (OrderStatus val) {
            order.setStatus(val);
            return this;
        }

        public Builder complete(Boolean val) {
            order.setComplete(val);
            return this;
        }

        public Order build() {
            return order;
        }
    }
}
