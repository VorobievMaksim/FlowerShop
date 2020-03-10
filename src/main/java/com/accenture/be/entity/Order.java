package com.accenture.be.entity;

import com.accenture.be.entity.enums.Status;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "Order")
@Table(name = "tb_orders")
@NamedQueries({
        @NamedQuery(name = "Order.findAll",query = "SELECT o FROM Order o"),
        @NamedQuery(name = "Order.findById",query = "SELECT o FROM Order o WHERE o.id = :id")
})
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "order")
    private List<OrderFlower> flowers;
    @Transient
    private Double sum;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name = "created_date")
    private LocalDateTime creationDate;
    @Column(name = "closet_date")
    private LocalDateTime closeDate;

    public Order() {
    }

    public Order(Long id, User user, List<OrderFlower> flowers, Double sum, Status status, LocalDateTime creationDate, LocalDateTime closeDate) {
        this.id = id;
        this.user = user;
        this.flowers = flowers;
        this.sum = sum;
        this.status = status;
        this.creationDate = creationDate;
        this.closeDate = closeDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderFlower> getFlowers() {
        return flowers;
    }

    public void setFlowers(List<OrderFlower> flowers) {
        this.flowers = flowers;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(LocalDateTime closeDate) {
        this.closeDate = closeDate;
    }
}
