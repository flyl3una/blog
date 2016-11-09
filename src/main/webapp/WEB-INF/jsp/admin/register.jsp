<%--
  Created by IntelliJ IDEA.
  User: hello
  Date: 2016/11/9
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" href="/css/admin.css"/>
</head>
<body >
<form action="/admin/register" method="post" class="register-form">
    <span>用户名：</span>
    <div><input name="username" type="text" height="20" class="input-text"></div>
    <span>邮箱：</span>
    <div><input name="email" type="email" height="30" class="input-text"></div>
    <span>密码：</span>
    <div><input name="password" type="password" height="20" class="input-text"></div>
    <span>确认密码：</span>
    <div><input name="password2" type="password" height="20" class="input-text"></div>
    <input name="submit" type="submit" value="注册">
</form>
</form>
<div style="color: #FFFFFF; font-size:30px;">
    ${error}
</div>
</body>
</html>
