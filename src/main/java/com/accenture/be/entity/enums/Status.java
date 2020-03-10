package com.accenture.be.entity.enums;

public enum Status {
    CREATED("Создан"),
    PAID("Оплачен"),
    CLOSED("Завершен");

    private String value;

    public String getValue() {
        return value;
    }

    Status(String value){
        this.value=value;
    }
}
