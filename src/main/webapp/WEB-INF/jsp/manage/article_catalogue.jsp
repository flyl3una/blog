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
    <title>分类目录</title>
</head>
<body>
<div class="manage-left">

    <%@include file="left.jsp"%>
</div>
<div class="manage-right">
    <div style="display: inline; float: left;width: 50%">
        <div class="content-title">分类目录</div>
        <form action="/manage/add-catalogue" method="post">
            <div>添加目录</div>
            <input type="text" name="name" class="input-text">
            <input type="submit" value="添加" class="input-submit">
        </form>
    </div>
    <div class="form-option">
        <form>
            <table border="1px" class="table-option">
                <tr style="color: #00a0d2">
                    <td>名称</td>
                    <td>总数</td>
                    <td>操作</td>
                </tr>
                <c:forEach var="catalogue" items="${catalogues}" varStatus="status">
                    <tr>
                        <td>${catalogue.name}</td>
                        <td>0</td>
                        <td><a>更改</a><a>删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <input type="submit" value="删除" class="input-submit">
        </form>
    </div>
</div>
</body>
</html>
