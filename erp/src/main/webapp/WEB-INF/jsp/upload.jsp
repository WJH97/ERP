<%--
  Created by IntelliJ IDEA.
  User: 10625
  Date: 2019/4/6
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="${ctx}/pic/upload" enctype="multipart/form-data">
    <input type="text" id="dir" name="dir">
    <input type="file" id="uploadFile" name="uploadFile">
    <input type="submit">
</form>

</body>
</html>
