
<%--
  Created by IntelliJ IDEA.
  User: Anton
  Date: 08.02.2016
  Time: 19:29
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
<h2>LIST OF USERS</h2>
  <tr>
    <td><strong>id</strong></td>
    <td><strong>name</strong></td>
    <td><strong>surname</strong></td>
    <td><strong>adress</strong></td>
    <td><strong>DoBirth</strong></td>
    <td><strong>DoHire</strong></td>
    <td><strong> </strong></td>
    </tr>

<c:forEach var="us" items="${requestScope['userslist']}">
  <td>${us.userId}</td>
  <td>${us.userName}</td>
  <td>${us.userSurname}</td>
  <td>${us.userAdress}</td>
  <td>${us.getDateOfBirth()}</td>
  <td>${us.getDateOfHire()}</td>
  <form action="GetUsersTechByID" method="post">
    <input type="hidden"  value=${us.userId} name="userID">
    <input type="hidden"  value=${us.userName} name="userName">
    <input type="hidden"  value=${us.userSurname} name="userSurname">
    <td><input type="submit" value="user skills" name="UserSkillsbyID" id="SkillByID${us.userId}"></td>
  </form>
  <form action="UserByID" method="post">
    <input type="hidden"  value=${us.userId} name="userID">
    <td><input type="submit" value="edit/delete" name="EditUser"></td>
    </form>
  </tr>
  </c:forEach>
</table>
<br>
<a  href="http://localhost:8080/adduser"><strong>ADD USER</strong></a>



</body>
</html>

