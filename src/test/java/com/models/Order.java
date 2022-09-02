package com.models;

public class Order {

    //Переменные для конструктора
    private Integer id;
    private Integer petId;
    private Integer quantity;
    private String shipDate;
    private OrderStatus orderStatus;
    private Boolean complete;

    //Пустой конструктор
    public Order() {
    }

    //Геттеры
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

    //Сеттеры
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

    //Преобразовать в строку
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

    //Далее Builder
    //Возвращаем билдера
    public static Builder builder() {
        return Builder.createBuilder();
    }

    public static final class Builder {

        private Order order;

        //Создаём новый заказ
        private Builder() {
            order = new Order();
        }

        //Создаем нового билдера
        private static Builder createBuilder() {
            return new Builder();
        }

        //Далее добавление значений в заказ
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

        public Builder orderStatus(OrderStatus val) {
            order.setOrderStatus(val);
            return this;
        }

        public Builder complete(Boolean val) {
            order.setComplete(val);
            return this;
        }

        //Вернули заказ
        public Order build() {
            return order;
        }
    }
}
