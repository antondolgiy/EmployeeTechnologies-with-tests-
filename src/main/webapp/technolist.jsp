<%@ page import="ru.dolgiy.model.Technologies" %>
<%--
  Created by IntelliJ IDEA.
  User: Anton
  Date: 05.02.2016
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title></title>
</head>
<body>

<table border="1" cellpadding="2" cellspacing="1" style="width: 800px">
  <h2>TECHNOLOGIES LIST</h2>
  <tr>
    <td><strong>tech id</strong></td>
    <td><strong>tech name</strong></td>
    <td><strong>tech description</strong></td>
  </tr>
  <c:forEach var="tec" items="${requestScope['techlist']}">
    <tr>
      <td name="us1">${tec.techId}</td>
      <td>${tec.techName}</td>
      <td>${tec.techDescription}</td>
      <td>
        <form action="/DeleteTech" method="post">
          <input type="hidden" value=${tec.techId} name="TechID">
          <input type="submit" value="delete tech" name="DelTech${tec.techId}">
        </form>
      </td>>
    </tr>
  </c:forEach>
</table>
<br>
<a name="redirect2addtech" href="http://localhost:8080/addtech"><strong>ADD TECHNOLOGY</strong></a>
<br>
<br>
ENTER TECH ID TO SEE USERS,SKILLED IN IT
<br>
<form action="/GetUsersByTechID" method="post">
  <input id ="find-id" type="number" name="TechIDtoFind">
  <input type="submit" value="select tech" name="SelectTechID">
</form>

</body>
</html>
