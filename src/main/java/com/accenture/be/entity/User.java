package com.accenture.be.entity;

import com.accenture.be.entity.enums.Role;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.List;

@Entity(name = "User")
@Table(name = "tb_users")
@NamedQueries({
        @NamedQuery(name = "User.findAll",query = "SELECT u FROM User u"),
        @NamedQuery(name = "User.findByUsername",query = "SELECT u FROM User u WHERE u.username = :username"),
        @NamedQuery(name = "User.findById",query = "SELECT u FROM User u WHERE u.id = :id")
})
@XmlRootElement
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "fullName")
    private String fullName;
    @Column(name = "address")
    private String address;
    @Column(name = "number")
    private String number;
    @Column(name = "balance")
    private BigDecimal balance;
    @Column(name = "discount")
    private Integer discount;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    public User() {
    }

    public User(String username, String password, String fullName, String address, String number, BigDecimal balance, Integer discount, Role role) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.address = address;
        this.number = number;
        this.balance = balance;
        this.discount = discount;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    @XmlAttribute
    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    @XmlElement
    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    @XmlElement
    public void setNumber(String number) {
        this.number = number;
    }

    public String getUsername() {
        return username;
    }

    @XmlElement
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    @XmlElement
    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    @XmlElement
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    @XmlElement
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Integer getDiscount() {
        return discount;
    }

    @XmlElement
    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Role getRole() {
        return role;
    }

    @XmlElement
    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", number='" + number + '\'' +
                ", balance=" + balance +
                ", discount=" + discount +
                '}';
    }
}
