<%--
  Created by IntelliJ IDEA.
  User: fly_l
  Date: 2016/10/20
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>文章列表</title>
    <%@ include file="/WEB-INF/jsp/base/src.jsp"%>
</head>
<body>
<div class="manage-left">
    left
    <%@include file="left.jsp"%>
</div>
<div class="manage-right">
    <div class="article">
        <c:forEach var="article" items="${articles}" varStatus="status">
            <div style="border: aqua solid 1px;; border-radius: 5px">
                title:${article.title}<br>
                <%--content:${article.content}<br>--%>
                createTime:${article.createTime}<br>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
