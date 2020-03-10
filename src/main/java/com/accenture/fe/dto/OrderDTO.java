package com.accenture.fe.dto;

import java.util.List;

public class OrderDTO {
    private String ID;
    private UserDTO user;
    private List<FlowerDTO> flowers;
    private String sum;
    private String status;
    private String creationDate;
    private String closeDate;

    public OrderDTO(String ID, UserDTO user, List<FlowerDTO> flowers, String sum, String status, String creationDate, String closeDate) {
        this.ID = ID;
        this.user = user;
        this.flowers = flowers;
        this.sum = sum;
        this.status = status;
        this.creationDate = creationDate;
        this.closeDate = closeDate;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public List<FlowerDTO> getFlowers() {
        return flowers;
    }

    public void setFlowers(List<FlowerDTO> flowers) {
        this.flowers = flowers;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }
}
