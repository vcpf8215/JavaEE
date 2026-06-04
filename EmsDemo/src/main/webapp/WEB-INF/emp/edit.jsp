<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>编辑员工</title>
</head>
<body>
<h2>编辑员工</h2>
<hr>
<form action="${pageContext.request.contextPath}/emp/edit.do" method="post">
    员工编号：${emp.id}<input type="hidden" name="id" value="${emp.id}" /><br>
    员工姓名：<input type="text" name="name"  value="${emp.name}" /><br>
    员工工资：<input type="text" name="salary"  value="${emp.salary}" /><br>
    员工年龄：<input type="text" name="age"  value="${emp.age}" /><br>
    <input type="submit" value="修改" />
    <input type="reset" value="重置" />
</form>
</body>
</html>
