package com.accenture.be.business;


import com.accenture.be.access.OrderDAO;
import com.accenture.be.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.accenture.be.entity.User;
import java.util.List;

@Service
public class OrderBusinessServiceImpl implements OrderBusinessService {

    @Autowired
    private OrderDAO orderDAO;

    @Override
    public Order createOrder(Order order) {
        return null;
    }

    @Override
    public Order payForTheOrder(User user, Order order) {
        return null;
    }

    @Override
    public Order closeOrder(Order order) {
        return null;
    }

    @Override
    public List<Order> getListOrders() {
        return null;
    }
}
