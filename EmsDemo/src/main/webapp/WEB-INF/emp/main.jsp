<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>员工管理首页</title>
    <script type="text/javascript">
        // 删除异步处理
        function del(id){
            // 安全删除
            if(confirm('是否要删除id为'+id+'的员工 ？')){
                location.href="${pageContext.request.contextPath}/emp/del?id="+id;
            }
        }

    </script>
    <style>
        .username{
            color: aqua;
            background-color: grey;
        }
    </style>

</head>
<body>
<h2>员工列表</h2>
<div>
    欢迎 <span class="username">${user.realname}</span>使用员工管理系统 &nbsp;&nbsp;&nbsp;&nbsp;
    <span><a href="${pageContext.request.contextPath}/user/exit">点击退出</a></span>
</div><hr>
<table border="1">
    <thead>
    <tr>
        <td colspan="6">
            <a href="${pageContext.request.contextPath}/emp/add">添加员工</a> &nbsp;&nbsp;&nbsp;&nbsp;
        </td>
    </tr>
    <tr>
        <th>序号</th>
        <th>员工ID</th>
        <th>员工姓名</th>
        <th>员工工资</th>
        <th>员工年龄</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${empty emps}">
        <tr><td colspan="6">还没有员工数据！！！</td></tr>
    </c:if>
    <c:if test="${not empty emps}">
        <c:forEach items="${emps}" varStatus="status" var="emp">
            <tr>
                <td>${status.count}</td>
                <td>${emp.id}</td>
                <td>${emp.name}</td>
                <td>${emp.salary}</td>
                <td>${emp.age}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/emp/edit?id=${emp.id}">编辑</a> &nbsp;&nbsp;
                    <a href="javascript: del('${emp.id}')">删除</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
    </tbody>
</table>
</body>
</html>
