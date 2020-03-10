package com.accenture.be.entity.cart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<CartItem> cartItems;
    private BigDecimal totalCost;

    public Cart(List<CartItem> cartItems) {
        this.cartItems = cartItems;
        calcTotalCost();
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    private void calcTotalCost(){
        totalCost = new BigDecimal(0);
        for (CartItem cartItem : cartItems) {
            totalCost = totalCost.add(cartItem.getCost());
        }
    }
}
