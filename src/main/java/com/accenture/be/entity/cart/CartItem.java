package com.accenture.be.entity.cart;

import com.accenture.be.entity.Flower;

import java.math.BigDecimal;

public class CartItem {
    private Flower flower;
    private Integer quantity;
    private BigDecimal cost;

    public CartItem(Flower flower, Integer quantity) {
        this.flower = flower;
        this.quantity = quantity;
        cost = new BigDecimal(quantity * flower.getPrice());
    }

    public Flower getFlower() {
        return flower;
    }

    public void setFlower(Flower flower) {
        this.flower = flower;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
        cost = new BigDecimal(quantity * flower.getPrice());
    }

    public BigDecimal getCost() {
        return cost;
    }
}
