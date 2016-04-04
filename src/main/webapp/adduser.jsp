<%--
  Created by IntelliJ IDEA.
  User: Anton
  Date: 04.02.2016
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
ADD USER
<table border="1" cellpadding="2" cellspacing="1" style="width: 800px">
  <tr>
    <td>UserID*</td>
    <td>UserName*</td>
    <td>UserSurname*</td>
    <td>UserAdress</td>
    <td>DateofBirth*</td>
    <td>DateofHire*</td>
  </tr>
  <form action="AddUser" method="post">
    <tr>
      <td><input type="number" name="userID"></td>
      <td><input type="text" name="userName"></td>
      <td><input type="text" name="userSurname"></td>
      <td><input type="text" name="userAdress"></td>
      <td><input type="date"  name="DateofBirth"></td>
      <td><input type="date"  name="DateofHire"></td>
    </tr>
    <input type="submit" value="add user" name="addUser">
  </form>
</table>

</body>
</html>
