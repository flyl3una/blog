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
    <div class="content-title">标签</div>
    <div style="display: inline; float: left;width: 50%">
    <form action="/manage/add-label" method="post">
        <div style="margin: 0 0 0 5%">添加标签</div>
        <input type="text" name="name" class="input-text">
        <input type="submit" value="添加" class="input-submit">
    </form>
    </div>
    <div class="form-option">
        <form method="post" action="/manage/delete_labels">
            标签管理
            <table class="table-option">
                <thead>
                <tr>
                    <td style="width:55px"><input type="checkbox" id="delete-all" class="checkbox-delete"
                                                  onclick="selete_all()"></td>
                    <td>名称</td>
                    <td>总数</td>
                    <td>操作</td>
                </tr>
                </thead>
                <c:forEach var="label" items="${labels}" varStatus="status">
                    <tbody>
                    <tr>
                        <td><input type="checkbox" class="checkbox-delete" id="delete-${label.id}"></td>
                        <td>
                            <div contenteditable="true" id="${label.id}-name">${label.name}</div>
                        </td>
                        <td>0</td>
                        <td>
                            <a onclick="update_name(${label.id})">更改</a>
                            <a href="/manage/delete_label?id=${label.id}">删除</a>
                        </td>
                    </tr>
                    </tbody>
                </c:forEach>
            </table>
            <input type="submit" value="删除" class="input-submit">
        </form>
    </div>
</div>
</body>
</html>


<script>

    function update_name(id) {
        console.log(id);
        id_name = "#" + id + "-name";
        name = $(id_name).text();
        console.log(name);
        $.ajax({
            type: "GET",
            url: "/manage/update_label?id=" + id + '&name=' + name,
            success: function (data) {
                if (data.status = "success") {
                    console.log("修改成功");
                } else {
                    name = data.old_name;
                    $(id_name).text(name);
                    alert("修改失败");
                }
            }
        })
    }

    function selete_all() {
        if (document.getElementById("delete-all").checked == true)
            check();
        else
            uncheck();
    }
    function check() {
        var checkbox_delete = document.getElementsByClassName("checkbox-delete");
        for (var i = 0; i < checkbox_delete.length; i++) {
            checkbox_delete[i].checked = true;
        }
    }
    function uncheck() {
        var checkbox_delete = document.getElementsByClassName("checkbox-delete");
        for (var i = 0; i < checkbox_delete.length; i++) {
            checkbox_delete[i].checked = false;
        }
    }
</script>