<%--
  Created by IntelliJ IDEA.
  User: fly_l
  Date: 2016/10/20
  Time: 23:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>发布新文章</title>


</head>
<body>
<div class="manage-left">

    <%@include file="left.jsp"%>
</div>

<div class="manage-right">
    <div class="content-title">写文章</div>
    <form action="/manage/write_article" method="post">
        <div style="margin:-10px 0 0 5%">文章标题</div>
        <div style="float: left; width:35%;margin-left: 5%;">
            <input type="text" name="title" class="input-text" id="input-title" value="${article.title}">
        </div>
        <div style="float: left;">目录：</div>
        <div style="float: left;">
            <select name="catalogueId" class="select-catalogue" id="select-catalogue-id">
                <c:forEach var="catalogue" items="${catalogues}" varStatus="status">
                    <option value="${catalogue.id}" id="catalogue-${catalogue.id}">${catalogue.name}</option>
                </c:forEach>
            </select>
        </div>
        <div style="float: left; margin-left: 3%;">
            <c:forEach var="label" items="${labels}">
                <input type="checkbox" class="select-labels" name="labelsId" id="delete-${label.id}" value="${label.id}">${label.name}
            </c:forEach>
            <input type="hidden" name="labelsId">
        </div>
        <input type="text" hidden="true" name="id" id="article-id" value="${article.id}">
        <div style="margin-top:5%;">
            <div class="editormd" id="test-editormd">
                <textarea class="editormd-markdown-textarea" name="test-editormd-markdown-doc"
                          onmouseout="write_simple()" id="article-content">${article.original}</textarea>
                <!-- 第二个隐藏文本域，用来构造生成的HTML代码，方便表单POST提交，这里的name可以任意取，后台接受时以这个name键为准 -->
                <textarea class="editormd-html-textarea" name="content" id="content"></textarea>
                <textarea class="hidden" name="simple" id="simple"></textarea>
                <textarea class="hidden" name="original" id="original"></textarea>
            </div>
        </div>
        <input type="submit" value="发布" class="input-submit" style="margin-left: 5%">
    </form>
</div>


</body>
</html>

<script type="text/javascript">

    $(document).ready(function () {
        editormd("test-editormd", {
            width   : "90%",
            height  : 640,
            syncScrolling : "single",
            //你的lib目录的路径
            path    : "<%=request.getContextPath()%>/editor/lib/",
            imageUpload : true,
            imageFormats : ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
            imageUploadURL : "/uploadImg",
            //这个配置在simple.html中并没有，但是为了能够提交表单，使用这个配置可以让构造出来的HTML代码直接在第二个隐藏的textarea域中，方便post提交表单。
            saveHTMLToTextarea : true
        });
        <%--var isUpdate = ${update};--%>
        if (${update}) {
            $("#select-catalogue-id").value = "${catalogueId}";
            <!--$("#input-title").value="
            ${article.title}";-->
            <%--$("#article-id").text("${article.id}");--%>
            <%--$("#article-content").text("${article.original}");--%>
            console.log(${catalogueId});
            $("#catalogue-${catalogueId}").onselect = true;
            <%--console.log(${labelsId});--%>
            <c:forEach var="labelId" items="${labelsId}">
            console.log(${labelId});
            for (label in $(".select-labels")) {
                if (label.id =${labelId}) {
                    label.onselect = true;
                    break;
                }
            }
            </c:forEach>
        }
    });

    function write_simple(){
        $("#simple").value = $("#content").text();
        $("#original").value = $("#article-content").text();
    }
</script>

