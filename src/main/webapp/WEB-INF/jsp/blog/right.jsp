<%--
  Created by IntelliJ IDEA.
  User: hello
  Date: 2016/10/29
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<div class="right-list">--%>
    <div>
        <%--<input type="text" class="search-text" id="search-text">--%>
        <%--<input type="button" class="search-btn" value="搜索" onclick="search()">--%>
    </div>
    <div class="catalogue-list">
        <h1>分类目录</h1>
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
        <h1>标签</h1>
        <c:forEach var="label" items="${labels}">
            <button class="label label-btn" onclick="tolabel('${label.name}')">
                    ${label.name}
            </button>
        </c:forEach>
    </div>
<%--</div>--%>
<script>
    function tolabel(name){
        console.log(name);
        window.open("/label?name="+name);
    }

//    function search() {
//        val = $("#search-text").val();
//        console.log(val);
//        window.open("/search?text="+val);
//    }
</script>