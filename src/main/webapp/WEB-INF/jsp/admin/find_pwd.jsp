<%--
  Created by IntelliJ IDEA.
  User: fly_l
  Date: 2016/11/9
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>找回密码</title>
</head>
<body>
<form action="/admin/find_pwd" method="post" class="login-form">
    <span>请输入注册邮箱：</span>
    <div><input name="email" type="text" height="20" class="input-text"></div>
    <input name="submit" type="submit" value="发送邮件" class="input-submit">
</form>
</body>
</html>
