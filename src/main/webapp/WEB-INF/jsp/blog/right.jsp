<%--
  Created by IntelliJ IDEA.
  User: hello
  Date: 2016/10/29
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="catalogue-list">
    <h2>分类目录</h2>
    <ul>
        <c:forEach items="${catalogues}" var="catalogue">
            <li class="catalogue">
                <a href="/catalogue?name=${catalogue.name}" class="catalogue" target="_blank"
                   style="text-decoration: none;">${catalogue.name}</a>
            </li>
        </c:forEach>
    </ul>
</div>
<div class="label-list">
    <h2>标签</h2>
    <c:forEach var="label" items="${labels}">
        <button class="label label-btn" onclick="tolabel('${label.name}')">
                ${label.name}
        </button>
    </c:forEach>
</div>

<script>
    function tolabel(name){
        console.log(name);
//        windows.location.href = "/label/"+name;
        window.open("/label?name="+name);
    }
</script>