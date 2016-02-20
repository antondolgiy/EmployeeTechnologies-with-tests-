<%--
  Created by IntelliJ IDEA.
  User: Anton
  Date: 08.02.2016
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title></title>
</head>
<body>
<h2>Skills of User:${requestScope['username']},${requestScope['usersurname']}</h2>
<br>
<table border="1" cellpadding="2" cellspacing="1" style="width: 800px">
  <c:forEach var="tec" items="${requestScope['usertech']}">
    <tr>
      <td>${tec.techId}</td>
      <td>${tec.techName}</td>
      <td>
        <form action="DelUserSkill" method="post">
          <input type="hidden" value="${tec.techId}" name="tech2delete">
          <input type="hidden" value="${requestScope['userID']}" name="userID">
          <input type="hidden" value="${requestScope['username']}" name="userName">
          <input type="hidden" value="${requestScope['usersurname']}" name="userSurname">
          <input type="submit" value="delete tech">
        </form>
      </td>
    </tr>
  </c:forEach>
 </table>


<br>ADD USER SKILL
<form action="AddUserSkill">
  <select name="tech2add">
    <c:forEach var="ufo" items="${requestScope['unknown']}">
      <option value="${ufo.techId}"  >${ufo.techName}</option>
    </c:forEach>
  </select>
  <input type="hidden" value="${requestScope['userID']}" name="userID">
  <input type="hidden" value="${requestScope['username']}" name="userName">
  <input type="hidden" value="${requestScope['usersurname']}" name="userSurname">

  <input type="submit" value="add selected">
</form>

</body>
</html>
