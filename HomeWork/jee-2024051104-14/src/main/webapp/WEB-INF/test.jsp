<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>从控制器过来的jsp页</title>
</head>
<body>
<h1>jsp模板页面</h1>
用户名是：${username}
<br>
<p>
    这是第十四次Java实验 <br>
    <a href="${pageContext.request.contextPath}/index">点击跳转</a>
</p>
</body>
</html>