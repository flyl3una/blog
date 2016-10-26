<%--
  Created by IntelliJ IDEA.
  User: fly_l
  Date: 2016/10/20
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>后台管理</title>
<%@ include file="/WEB-INF/jsp/base/src.jsp"%>

</head>
<body>
<div class="manage-left">
    left
    <%@include file="left.jsp"%>
</div>
<div class="manage-right">
    right
    <div class="content">内容</div>
</div>
</body>
</html>


<%--<script>--%>
    <%--$(document).ready(function () {--%>
        <%--$("#show-article-list").click(function () {--%>
            <%--alert("a");--%>
            <%--$.ajax({--%>
                <%--url:"/manage/show-article-list",--%>
                <%--type:'GET',--%>
                <%--contentType:'json',--%>
                <%--success:function (response) {--%>
                    <%--$(".content").innerHTML += response;--%>
                    <%--console.log(response);--%>
                <%--}--%>
            <%--})--%>
        <%--});--%>

        <%--$("#write-article").click(function () {--%>
            <%--alert("b");--%>
            <%--$.ajax({--%>
                <%--url:"/manage/write-article",--%>
                <%--type:"GET",--%>
                <%--contentType:'json',--%>
                <%--success:function (response) {--%>
                    <%--$(".content").innerHTML += response;--%>
                    <%--console.log(response);--%>
                <%--}--%>
            <%--})--%>
        <%--})--%>
    <%--})--%>
<%--</script>--%>