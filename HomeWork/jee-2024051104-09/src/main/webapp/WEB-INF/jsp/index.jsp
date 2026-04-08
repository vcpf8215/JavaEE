<%@ page import="java.util.Date" %>
<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>这是一张jsp动态页面，页面在WEB-INF/jsp目录下</title>
</head>
<body>
<h1>这是一张在WEB-INF/jsp目录下的jsp动态页面: index.jsp</h1> <br>
当前时间是：<%=new Date()%>

</body>
</html>