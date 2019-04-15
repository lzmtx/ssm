<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lzmtx
  Date: 2019/4/11
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>查询所有账户</title>
</head>
<body>

    <h3>执行成功</h3>
    <c:forEach items="${users}" var="users" >
        <p>
        id: ${users.id} &emsp;&emsp;
        name: ${users.name} &emsp;&emsp;
        money: ${users.money} &emsp;&emsp;
        </p>
    </c:forEach>
</body>
</html>
