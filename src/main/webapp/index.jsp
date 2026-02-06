<%--
  Created by IntelliJ IDEA.
  User: zzj
  Date: 2019/9/4
  Time: 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
  <head>
    <title>主页</title>
  </head>

  <body>
  <center>
    <font size="5">显示所有信息</font><br>
    <a href="add.jsp">添加</a>
  <table>
    <tr>
      <td><strong>Id</strong></td>
      <td><strong>姓名</strong></td>
      <td><strong>性别</strong></td>
      <td><strong>操作</strong></td>

    </tr>

    <c:forEach items="${requestScope.users}" var="u">
      <tr>
        <td><c:out value="${u.id}"></c:out></td>
        <td><c:out value="${u.name}"></c:out></td>
        <td>
          <c:choose>
            <c:when test= "${u.sex==0}">女</c:when>
            <c:otherwise>男</c:otherwise>
          </c:choose>
        </td>
        <td>
          <a href="getOneServlet?ID=${u.id}">修改</a>
          <a onclick="javascript:if (confirm('确定删除吗？')) { return true;}else{return false;};" href="DeleteServlet?ID=${u.id}">删除</a>

        </td>
      </tr>
    </c:forEach>
  </table>
  <table>
    <tr>
      <td>
        共${sessionScope.p.totalPage}页
<c:forEach begin="1" end="${sessionScope.p.totalPage}" step="1" var="pnum">
  <a href="PagingServlet?reqNum=${pnum}">${pnum}</a>

</c:forEach>
<br/>
        <a href="PagingServlet?reqNum=${sessionScope.p.previous}">上一页</a>
        <a href="PagingServlet?reqNum=${sessionScope.p.next}">下一页</a>
</td>
</tr>
</table>
  </center>
</body>
</html>
