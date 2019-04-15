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
    <script type="text/javascript" src="js/jquery-3.3.1.js"></script>
</head>
<style>
    input {
        height: 25px;
        line-height: 25px;
        padding: 0 5px 0 5px;
    }
    input[type=text] {
        width: 100px;
    }
</style>
<body>
    <a href="/ssm/account/findAll">查询所有账户</a>
    <br />
    <br />
    <a href="/ssm/WEB-INF/pages/test.jsp">页面跳转</a>
    <br />
    <br />
    *************************************************
    <br />
    <h3>form测试插入</h3>
    <form action="/ssm/account/save" method="post">
        <input type="text" name="id" class="id" placeholder="id" />
        <input type="text" name="name" class="name" placeholder="name" />
        <input type="text" name="money" class="money" placeholder="money" />
        <input type="submit">
    </form>

    <input type="button" class="findall_btna" value="ajax测试查询所有账户" />

    <h3>ajax测试插入</h3>
    <input type="text" name="ida" class="id ida" placeholder="id" />
    <input type="text" name="namea" class="name namea" placeholder="name" />
    <input type="text" name="moneya" class="money moneya" placeholder="money" />
    <input type="button" class="submita" value="提交">

    <h3>ajax测试删除</h3>
    <input type="text" name="id_del" class="id_del" placeholder="id" />
    <input type="button" class="del" value="根据id删除" />

    <h3>ajax测试更改</h3>


    <script>
        $(".findall_btna").click(function () {
           $.ajax({
               url: "/ssm/account/findAlla",
               type: "post",
               contentType: "application/json",
               dataType: "json",
               data: JSON.stringify({id: $(".ida").val(), name: $(".namea").val(), money: $(".moneya").val()}),
               success: function (data) {
                   console.log(data);
               },
               error: function (data) {
                   alert("响应出错！" + data);
               }
           })
        });
        $(".submita").click(function () {
            if ($(".ida").val() != null && $(".ida").val() != "") {
                $.ajax({
                    url: "/ssm/account/testAjax",
                    type: "post",
                    contentType: "application/json",
                    dataType: "json",
                    data: JSON.stringify({id: $(".ida").val(), name: $(".namea").val(), money: $(".moneya").val()}),
                    success: function (data) {
                        console.log(data);
                    },
                    error: function (data) {
                        alert("响应出错！" + data);
                    }
                });
            } else {
                alert("请填写字段！");
            }
        });
        $(".del").click(function () {
            let id_del = $("id_del").val();
            if (id_del != null && id_del != "") {
                $.ajax({
                    url: "/ssm/account/",
                    type: "post",
                    contentType: "application/json",
                    dataType: "json",
                    data: JSON.stringify({id: id_del}),
                    success: function (data) {
                        alert(data.toString());
                    }
                });
            } else {
                alert("请填写字段！");
            }
        })
    </script>
</body>
</html>
