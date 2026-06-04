<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户注册</title>
    <style>
        .success-msg{
            color: red;
        }
    </style>
</head>
<body>
<h2>用户注册</h2>
<c:if test="${not empty message}">
    <div class="success-msg">${message}</div>
</c:if>
<hr>
<form action="${pageContext.request.contextPath}/user/regist.do" method="post">
    用户名：<input type="text" name="username" /><br>
    用户真名：<input type="text" name="realname" /><br>
    用户密码：<input type="text" name="password" /><br>
    用户性别：<input type="radio" name="gender" value="男" />男
    <input type="radio" name="gender" value="女" checked/>女<br>
    <input type="submit" value="注册" />
    <input type="reset" value="重置" />
</form>
</body>
</html>