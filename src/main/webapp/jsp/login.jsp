<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>

<html>
<head>
    <title>Login</title>
</head>
<body>
<form method="post" action="login">
<div class="form-group">
<label for="username">Логин</label>
<input type="text" class="form-control" id="username" name="username"></input>
</div>
<div class="form-group">
<label for="password">Пароль</label>
<input type="password" class="form-control" id="password" name="password"></input>
</div>
<button type="submit" class="btn btn-primary">Войти</button>
<button type="button" class="btn btn-success" onClick='location.href="/flowershop/registration"'>Регистрация</button>
</form>
<label for="error">${error}</label>
</body>
</html>