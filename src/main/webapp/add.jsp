<%--
  Created by IntelliJ IDEA.
  User: zzj
  Date: 2019/9/4
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加</title>
<%--    <script type="text/javascript" src="js/span.js"></script>--%>
</head>
<script type="text/javascript">

</script>
<body>
<center>
    <font size="5">添加用户信息</font><br>

<form action="${pageContext.request.contextPath}/AddServlet" method="post"  >
    <table>
        ${msg}

        <tr>
            <td>姓名：</td><td><input type="text" name="name" /><span name="nameSpan"></span></td>
        </tr>

        <tr>
            <td>性别：</td><td><input type="radio" name="sex" value="0" checked="checked"/>女
                                <input type="radio" name="sex" value="1"/>男</td>
        </tr>

    </table>

    <button type="submit" >添加</button>
    <button type="reset" >重置</button><br/>

</form>
</center>

<%--<script type="text/javascript" src="js/submit.js"></script>--%>
</body>
</html>
