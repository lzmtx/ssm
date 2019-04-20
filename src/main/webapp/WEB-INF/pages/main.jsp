<%--
  Created by IntelliJ IDEA.
  User: lzmtx
  Date: 2019/4/19
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>系统主页</title>
</head>
<body>
    当前用户：${user_session.username}
    <a href="${pageContext.request.contextPath}/logout">退出系统</a>
</body>
</html>
