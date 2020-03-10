package com.accenture.be.access;

import com.accenture.be.entity.Order;

import java.util.List;

public interface OrderDAO {
    List<Order> getListOrders();
    Order save(Order order);
    Order getByID(Long ID);
    Order update(Order order);
}
