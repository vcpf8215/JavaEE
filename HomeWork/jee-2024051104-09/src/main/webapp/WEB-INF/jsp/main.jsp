<%@ page import="java.util.Date" %>
<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户管理首页</title>
</head>
<body>
<h1>用户管理首页</h1> <br>
当前登录的用户是：${user.name}
当前时间是：<%=new Date()%>
<br>
<a href="logout">退出登录</a>
</body>
</html>