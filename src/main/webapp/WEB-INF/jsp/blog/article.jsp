<%--
  Created by IntelliJ IDEA.
  User: fly_l
  Date: 2016/10/28
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/WEB-INF/jsp/base/src.jsp" %>
    <%@include file="/WEB-INF/jsp/base/head.jsp" %>


    <div class="content">
        <div class="content-article">
            <div class="a-article">
                <div class="article-title">
                    ${article.title}
                </div>
                <div class="article-title2">
                    发布于: ${article.createTime}
                </div>
                <div class="article-content">
                    ${article.content}
                </div>
            </div>
        </div>
        <div class="content-right">
            <%@include file="right.jsp" %>
        </div>
    </div>

    <%@include file="/WEB-INF/jsp/base/footer.jsp" %>
