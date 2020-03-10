package com.accenture.be.exeptions;

public enum FlowerShopErrors {
    USER_IS_NOT_EXIST("Пользователя с данным именем не существует.(User with this name does not exist)"),
    USER_IS_EXIST("Пользователь с данным именем уже существует.(User with this name already exists)"),
    PASSWORD_IS_INCORRECT("Неправильный пароль.(Invalid Password)"),
    USERNAME_IS_SHORT("Имя пользователя должно быть не менее 3 символов"),
    PASSWORD_IS_SHORT("Пароль должен быть не менее 6 символов");

    private String value;

    public String getValue() {
        return value;
    }

    FlowerShopErrors(String value) {
        this.value = value;
    }
}
