<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户登录</title>
    <style>
        span {
            color: red;
        }
    </style>
</head>
<body>
<h1>用户登录</h1> <br>
<form action="login" method="post">
    用户名：<input type="text" name="name" /> <br>
    密码： <input type="password" name="password"/> <br>
    <input type="submit" value="登录" />
    <input type="reset" value="重置">
    <span>${msg}</span>
</form>

</body>
</html>