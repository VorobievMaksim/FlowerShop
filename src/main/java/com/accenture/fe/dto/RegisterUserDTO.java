package com.accenture.fe.dto;

public class RegisterUserDTO {
    private String username;
    private String password;
    private String fullName;
    private String address;
    private String number;

    public RegisterUserDTO(String username, String password, String fullName, String address, String number) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.address = address;
        this.number = number;
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
}
