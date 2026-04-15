<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户登录</title>
</head>
<body>
<h2>用户登录</h2>
<hr>
<form action="${pageContext.request.contextPath}/user/login.do" method="post">
    用户名：<input type="text" name="username" /><br>
    用户密码：<input type="text" name="password" /><br>
    <input type="submit" value="登录" />
    <input type="reset" value="重置" />
</form>
</body>
</html>
