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
    <title>标签管理</title>
</head>
<body>
<div class="manage-left">

    <%@include file="left.jsp"%>
</div>
<div class="manage-right">
    <div style="display: inline; float: left;width: 50%">
        <div class="content-title">标签</div>
    <form action="/manage/add-label" method="post">
        <div>名称</div>
        <input type="text" name="name" class="input-text">
        <input type="submit" value="提交" class="input-submit">
    </form>
    </div>
    <div class="form-option">
        <form method="post">
            <table border="1px solid ">
                <tr>
                    <th>名称</th>
                    <th>总数</th>
                </tr>
                <c:forEach var="label" items="${labels}" varStatus="status">
                    <tr>
                        <td>${label.name}</td>
                    </tr>
                </c:forEach>
            </table>
            <input type="submit" value="删除" class="input-submit">
        </form>
    </div>
</div>
</body>
</html>
