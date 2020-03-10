package com.accenture.be.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Flower")
@Table(name = "tb_flowers")
@NamedQueries({
        @NamedQuery(name = "Flower.findAll",query = "SELECT f FROM Flower f"),
        @NamedQuery(name = "Flower.findByName",query = "SELECT f FROM Flower f WHERE f.name LIKE :name"),
        @NamedQuery(name = "Flower.findByPrice",query = "SELECT f FROM Flower f WHERE f.price<=:max AND f.price>=:min")
})
public class Flower {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Double price;
    @Column(name = "description")
    private String description;
    @Column(name ="quantity")
    private Integer quantity;
    @OneToMany(mappedBy = "flower")
    private List<OrderFlower> orders;

    public Flower() {
    }

    public Flower(Long id, String name, Double price, String description, Integer quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getid() {
        return id;
    }

    public void setid(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
