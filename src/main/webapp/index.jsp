<%--
  Created by IntelliJ IDEA.
  User: lzmtx
  Date: 2019/4/11
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ssm_test</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script type="text/javascript" src="js/jquery-3.3.1.js"></script>
</head>
<style>
    body {
        padding: 10px;
    }

    input[type=text] {
        display: inline-block;
        width: 120px;
        padding: 0 5px 0 5px;
    }

    .btn {
        margin-top: -5px;
    }

    a, input, br, h5 {
        margin-top: 10px;
    }
</style>
<body>
<div>
    <a href="${pageContext.request.contextPath}/account/findAll" class="btn btn-success">查询所有账户</a>
    <input type="button" class="findall_btna btn btn-success" value="ajax测试查询所有账户"/>

    <h5>form测试插入</h5>
    <form action="${pageContext.request.contextPath}/account/save" method="post">
        <input type="text" name="name" class="name form-control" placeholder="name"/>
        <input type="text" name="money" class="money form-control" placeholder="money"/>
        <input type="submit" class="btn btn-success">
    </form>

    <h5>ajax测试插入</h5>
    <input type="text" name="namea" class="name namea form-control" placeholder="name"/>
    <input type="text" name="moneya" class="money moneya form-control" placeholder="money"/>
    <input type="button" class="submita btn btn-success" value="提交">

    <h5>ajax测试删除</h5>
    <input type="text" name="id_del" class="id_del form-control" placeholder="id"/>
    <input type="submit" class="del btn btn-success" value="根据id删除"/>

    <h5>ajax测试更改</h5>
    <input type="text" name="id" class="idu form-control" placeholder="id"/>
    <input type="text" name="name" class="nameu form-control" placeholder="name"/>
    <input type="text" name="money" class="moneyu form-control" placeholder="money"/>
    <input type="button" class="updatea btn btn-success" value="提交">

    <a href="${pageContext.request.contextPath}/handler/hello" class="btn btn-success">拦截器测试</a>

    <a href="${pageContext.request.contextPath}/account/toMain" class="btn btn-success">跳转到main.jsp</a>


</div>
<script src="js/index.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
