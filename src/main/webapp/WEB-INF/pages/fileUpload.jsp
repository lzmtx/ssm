<%--
  Created by IntelliJ IDEA.
  User: lzmtx
  Date: 2019/4/20
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/fileUpload" method="post" enctype="multipart/form-data" onsubmit="return check()">
        上传人：<input type="text" id="name" name="name" />
        <br />
        请选择文件：<input type="file" id="file" name="uploadfile" multiple="multiple" />
        <br />
        <input type="submit" value="上传" />
    </form>

    <script>
        //判断是否填写上传人并已选择上传文件
        function check() {
            var name = document.getElementById("name").value;
            var file = document.getElementById("file").value;
            if (name == "") {
                alert("请填写上传人");
                return false;
            }
            if (file.length == 0 || file == "") {
                alert("请选择上传文件");
                return false;
            }
            return true;
        }
    </script>

</body>
</html>
