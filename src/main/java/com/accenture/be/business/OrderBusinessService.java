package com.accenture.be.business;

import com.accenture.be.entity.Order;
import com.accenture.be.entity.User;

import java.util.List;

public interface OrderBusinessService {
    Order createOrder(Order order);
    Order payForTheOrder(User user, Order order);
    Order closeOrder(Order order);
    List<Order> getListOrders();
}
