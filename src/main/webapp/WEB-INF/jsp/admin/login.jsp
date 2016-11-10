<%--
  Created by IntelliJ IDEA.
  User: fly_l
  Date: 2016/10/17
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="/css/admin.css"/>
</head>
<body>
<form action="/admin/login" method="post" class="login-form">
    <span>用户名：</span>
    <div><input name="username" type="text" height="20" class="input-text"></div>
    <span>密码：</span>
    <div><input name="password" type="password" height="20" class="input-text"></div>
    <input name="submit" type="submit" value="登陆" class="input-submit">
    <a class="register" href="/admin/register">注册</a>
    <%--<a class="find-pwd" href="/admin/update_pwd">更改密码</a>--%>
</form>
</form>
<div style="color: #FFFFFF; font-size:30px;">
    ${error}
</div>
</body>
</html>
