<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Registration</title>
</head>
<body>
    <form method="post" action="registration">
<div class="form-group">
    <label for="username">Логин</label>
    <input type="text" class="form-control" id="username" name="username"></input>
</div>
<div class="form-group">
    <label for="password">Пароль</label>
    <input type="password" class="form-control" id="password" name="password"></input>
</div>
<div class="form-group">
    <label for="fullName">Ф.И.О.</label>
    <input type="text" class="form-control" id="fullName" name="fullName"></input>
</div>
<div class="form-group">
    <label for="address">Адрес</label>
    <input type="text" class="form-control" id="address" name="address"></input>
</div>
<div class="form-group">
    <label for="number">Номер телефона</label>
    <input type="text" class="form-control" id="number" name="number"></input>
</div>
    <button type="submit" class="btn btn-primary">Зарегистрироваться</button>
    <button type="button" class="btn btn-success" onClick='location.href="/flowershop/login"'>Логин</button>
</form>
<label for="error">${error}</label>
</body>
</html>