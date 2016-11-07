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
    ${error}
    <div class="article-list">
        <table class="article-list-table">
            <thead>
                <tr>
                    <td style="width: 10%">文章</td>
                    <td style="width: 20%">分类目录</td>
                    <td style="width: 25%">标签</td>
                    <td style="width: 30%">日期</td>
                    <td style="width: 15%">操作</td>
                </tr>
            </thead>
            <tbody style="background: #e9e9e9">
            <c:forEach var="article" items="${articles}" varStatus="status">
                <tr>
                    <td>${article.title}</td>
                    <td>${catalogues[article.id]}</td>
                    <td>
                        <c:forEach var="labelName" items="${labels[article.id]}">
                            <span class="label-span">${labelName}</span>
                        </c:forEach>
                    </td>
                    <td>${article.createTime}</td>
                    <td>
                        <a href="/manage/update_article?id=${article.id}">更改</a>
                            <%--<a onclick="delete_article(${article.id})">删除</a>--%>
                        <a href="/manage/delete_article?id=${article.id}">删除</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>


<script>
    function delete_article(id) {
        $.ajax({
            type: "GET",
            url: "/manage/delete_article?id=" + id,
            success: function (data) {
                if (data.status = "success") {
                    console.log("修改成功");
                } else {
                    name = data.old_name;
                    $(id_name).text(name);
                    alert("修改失败");
                }
            }
        });
    }
</script>