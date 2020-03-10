<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>

<html>
    <head>
    <form method="get" action="logout">
    <label for="username">Здравствуй ${username}!</label>
    <label for="balance">Баланс: ${balance}</label>
    <label for="discount">Скидка: ${discount}%</label>
    <button type="submit" class="btn btn-primary">Выйти</button>
    </form>
    </head>
    <body>

    </body>
</html>