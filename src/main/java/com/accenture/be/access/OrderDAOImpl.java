package com.accenture.be.access;

import com.accenture.be.entity.Flower;
import com.accenture.be.entity.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Order> getListOrders() {
        List<Order> orders;
        try {
            TypedQuery<Order> query  = entityManager.createNamedQuery("Order.findAll", Order.class);
            orders = query.getResultList();
        } catch (NoResultException nr) {
            orders = Collections.emptyList();
        }
        return orders;
    }

    @Override
    public Order save(Order order) {
        entityManager.persist(order);
        return order;
    }

    @Override
    public Order getByID(Long ID) {
        Order order;
        try {
            TypedQuery<Order> query  = entityManager.createNamedQuery("Order.findById", Order.class).setParameter("id",ID);
            order = query.getSingleResult();
        } catch (NoResultException nr) {
            order = null;
        }
        return order;
    }

    @Override
    public Order update(Order order) {
        return entityManager.merge(order);
    }
}
