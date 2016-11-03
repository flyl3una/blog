<%--
  Created by IntelliJ IDEA.
  User: fly_l
  Date: 2016/10/20
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<head>
    <title>文章列表</title>
</head>
<body>
<div class="manage-left">

    <%@include file="left.jsp"%>
</div>
<div class="manage-right">
    <div class="article-list">
        <table>
            <tr>
                <td>文章</td>
                <td>分类目录</td>
                <td>标签</td>
                <td>日期</td>
                <td>操作</td>
            </tr>
        <c:forEach var="article" items="${articles}" varStatus="status">
            <%--<div style="border: aqua solid 1px;; border-radius: 5px">--%>
                <tr>
                    <td>${article.title}</td>
                    <td>${catalogue[article.id]}</td>
                    <td>
                        <c:forEach var="labelName" items="${labels[article.id]}">
                            <a>labelName</a>
                        </c:forEach>
                    </td>
                    <td>${article.createTime}</td>
                    <td>
                        <a onclick="update_article(${article.id})">更改</a>
                        <a href="/manage/delete_article?id=${article.id}">删除</a>
                    </td>
                </tr>
            <%--</div>--%>
        </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
