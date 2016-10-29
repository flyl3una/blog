<%--
  Created by IntelliJ IDEA.
  User: fly_l
  Date: 2016/10/24
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>文章目录</title>
</head>
<body>
<div class="manage-left">

    <%@include file="left.jsp"%>
</div>
<div class="manage-right">

    <div class="content">内容</div>
    标签
    <form action="/manage/add-catalogue" method="post">
        名称<input type="text" name="name">
        <input type="submit" value="提交">
    </form>
    <table border="1px">
        <tr><th>catalogue</th></tr>
        <c:forEach var="catalogue" items="${catalogues}" varStatus="status">
            <tr><td>${catalogue.name}</td></tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
