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
<%@include file="/WEB-INF/jsp/base/src.jsp"%>
<%@include file="/WEB-INF/jsp/base/head.jsp"%>


    <%--content--%>
<%--<div class="header">header</div>--%>
<%--<div class="user-info">userinfo</div>--%>
<%--<div class="article-info">article</div>--%>
<%--<div class="blog-info">blog-info</div>--%>

<div class="content">
    <div class="content-article">
        <c:forEach var="article" items="${articles}" varStatus="status">
            <div class="a-article">
                <div class="article-title">
                    ${article.title}
                </div>
                <a class="article-catalogue">
                    c
                </a>
                <div class="article-content">
                    content:${article.simple}...
                </div>
                <div>
                    <span class="article-time">
                        Post on: ${article.createTime}
                    </span>
                    <a class="article-details" href="/article?id=${article.id}">
                        阅读全文>>
                    </a>
                </div>
            </div>
        </c:forEach>
    </div>
    <div class="content-right">
        <h1>right</h1>
    </div>
</div>

    <%--end content--%>
<%@include file="/WEB-INF/jsp/base/footer.jsp"%>
