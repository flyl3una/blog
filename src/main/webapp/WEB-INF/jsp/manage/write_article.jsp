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
    <%@ include file="/WEB-INF/jsp/base/src.jsp"%>
    <link rel="stylesheet" href="/editor/css/editormd.css"/>
    <script src="/js/jquery-3.0.0/jquery-3.0.0.min.js"></script>
    <script src="/editor/editormd.min.js"></script>

</head>
<body>
<div class="manage-left">
    left
    <%@include file="left.jsp"%>
</div>

<div class="manage-right">
    write article
    <form action="/manage/write_article" method="post">
        <div>标题</div>
        <input type="text" name="title">
        <div>内容</div>
        <%--<textarea name="content" style="width: 500px; height: 300px;"></textarea><br>--%>

        <div class="editormd" id="test-editormd">
            <textarea class="editormd-markdown-textarea" name="test-editormd-markdown-doc"></textarea>
            <!-- 第二个隐藏文本域，用来构造生成的HTML代码，方便表单POST提交，这里的name可以任意取，后台接受时以这个name键为准 -->
            <textarea class="editormd-html-textarea" name="content"></textarea>
        </div>
        <input type="submit" value="发布">
    </form>
</div>


</body>
</html>

<script type="text/javascript">
    $(function() {
        path = "<%=request.getContextPath()%>/editor/lib/";
        console.log(path);
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
    });
</script>

