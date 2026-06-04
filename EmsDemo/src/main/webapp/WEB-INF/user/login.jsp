<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户登录</title>
    <style>
        .success-msg{
            color: red;
        }
    </style>
</head>
<body>
<h2>用户登录</h2>
<c:if test="${not empty message}">
    <div class="success-msg">${message}</div>
</c:if>
<hr>
<form action="${pageContext.request.contextPath}/user/login.do" method="post">
    用户名：<input type="text" name="username" /><br>
    用户密码：<input type="text" name="password" /><br>
    <input type="submit" value="登录" />
    <input type="reset" value="重置" />
</form>
<hr>
<a href="${pageContext.request.contextPath}/user/index">回到主页</a>
</body>
</html>
