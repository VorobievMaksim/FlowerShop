package com.accenture.be.entity.enums;

public enum Role {
    USER("Пользователь"),
    ADMIN("Администратор");

    private String value;

    public String getValue() {
        return value;
    }

    Role(String value){
        this.value=value;
    }
}
