<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加员工</title>
</head>
<body>
<h2>添加员工</h2>
<hr>
<form action="${pageContext.request.contextPath}/emp/add.do" method="post">
    员工编号：<input type="text" name="id" /><br>
    员工姓名：<input type="text" name="name" /><br>
    员工工资：<input type="text" name="salary" /><br>
    员工年龄：<input type="text" name="age" /><br>
    <input type="submit" value="添加" />
    <input type="reset" value="重置" />
</form>
</body>
</html>
