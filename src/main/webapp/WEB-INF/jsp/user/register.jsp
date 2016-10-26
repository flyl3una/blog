<%--
  Created by IntelliJ IDEA.
  User: fly_l
  Date: 2016/10/17
  Time: 23:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<form action="/admin/register" method="post">
    用户名：<input name="username" type="text" height="20"><br>
    邮箱：<input name="email" type="email" height="30"><br>
    密码：<input name="password" type="password" height="20"><br>
    再次输入密码：<input name="password2" type="password" height="20"><br>
    <input name="submit" type="submit">

</form>
<div style="color: #FFFFFF; font-size:30px;">
    ${error}
</div>
</body>
</html>
