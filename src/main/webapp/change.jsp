<%--
  Created by IntelliJ IDEA.
  User: zzj
  Date: 2019/9/5
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>修改</title>
<%--    <script type="text/javascript" src="js/span.js"></script>--%>
</head>
<body>
<center>
    <font size="5">修改用户信息</font><br>
<form action="${pageContext.request.contextPath}/UpdateServlet" method="post" >
    <table>
        <tr>
            <td>Id：</td><td><input type="text" name="id" readonly="readonly "value="${requestScope.user.id}" /></td>
        </tr>

        <tr>
            <td>姓名：</td><td><input type="text" name="name" value="${requestScope.user.name}" /><span name="nameSpan"></span></td>
        </tr>

        <tr>
            <td>性别：</td><td>
            <c:if test="${requestScope.user.sex==0}">
                <input type="radio" name="sex" value="0" checked="checked"/>女
                <input type="radio" name="sex" value="1"/>男</td>
            </c:if>
            <c:if test="${requestScope.user.sex==1}">
                <input type="radio" name="sex" value="0" />女
                <input type="radio" name="sex" value="1" checked="checked" />男</td>
            </c:if>
        </tr>



    </table>

    <button type="submit" >修改</button><br/>

</form>
</center>
<%--<script type="text/javascript" src="js/submit.js"></script>--%>
</body>
</html>
