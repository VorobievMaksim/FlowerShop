package com.accenture.fe.dto;

import javax.validation.constraints.NotNull;

public class UserDTO {
    private String ID;
    private String username;
    private String password;
    private String fullName;
    private String address;
    private String number;
    private String balance;
    private String discount;
    private String role;

    public UserDTO(String ID, String username, String password, String fullName, String address, String number, String balance, String discount, String role) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.address = address;
        this.number = number;
        this.balance = balance;
        this.discount = discount;
        this.role = role;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
