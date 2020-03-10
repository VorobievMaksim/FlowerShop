package com.accenture.fe.dto;

public class FlowerDTO {
    private String ID;
    private String name;
    private String price;
    private String quantity;

    public FlowerDTO(String ID, String name, String price, String quantity) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
