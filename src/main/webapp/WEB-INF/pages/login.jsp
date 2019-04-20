<%--
  Created by IntelliJ IDEA.
  User: lzmtx
  Date: 2019/4/19
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
    ${msg}
    <form action="${pageContext.request.contextPath}/login" method="post">
        用户名：<input type="text" name="username" />
        <br />
        密&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" />
        <br />
        <input type="submit" value="登录" />
    </form>
</body>
</html>
