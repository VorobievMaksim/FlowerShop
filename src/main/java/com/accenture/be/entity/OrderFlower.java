package com.accenture.be.entity;

import javax.persistence.*;

@Entity
@Table(name = "tb_order_flower")
public class OrderFlower {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "flower_id")
    private Flower flower;
    @Column(name = "quantity")
    private Integer quantity;

    public OrderFlower() {
    }

    public OrderFlower(Long id, Order order, Flower flower, Integer quantity) {
        this.id = id;
        this.order = order;
        this.flower = flower;
        this.quantity = quantity;
    }

    public Long getid() {
        return id;
    }

    public void setid(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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
    }
}
