<%--
  Created by IntelliJ IDEA.
  User: fly_l
  Date: 2016/10/19
  Time: 23:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Welcome</title>
<%@include file="/WEB-INF/jsp/base/head.jsp"%>
</head>
<body>
<div class="header">header</div>
<div class="user-info">userinfo</div>
<div class="article-info">article</div>
<div class="blog-info">blog-info</div>

article list
<div>
    <div class="article">
        <c:forEach var="article" items="${articles}" varStatus="status">
            <div style="border: aqua solid 1px;; border-radius: 5px">
                title:${article.title}<br>
                content:${article.content}<br>
                createTime:${article.createTime}<br>
            </div>
        </c:forEach>
    </div>
</div>

<%@include file="/WEB-INF/jsp/base/footer.jsp"%>
