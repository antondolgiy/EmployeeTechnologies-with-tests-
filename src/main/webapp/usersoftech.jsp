<%--
  Created by IntelliJ IDEA.
  User: Anton
  Date: 20.02.2016
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title></title>
</head>
<body>
USERS,SKILLED IN <strong>${requestScope['TechByID'].techName}</strong>
<br>
<table border="1" cellpadding="2" cellspacing="1" style="width: 800px">
<c:forEach var="user" items="${requestScope['UsersOfTech']}">
  <tr>
  <td name="user-id">${user.userId}</td>
  <td name="user-name">${user.userSurname}, ${user.userName}</td>
  </tr>
  </c:forEach>
  </table>



</body>
</html>
