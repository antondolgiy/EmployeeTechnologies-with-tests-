<%--
  Created by IntelliJ IDEA.
  User: Anton
  Date: 12.02.2016
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
ADD TECHNOLOGY
<table border="1" cellpadding="2" cellspacing="1" style="width: 800px">
  <tr>
    <td>technoID*</td>
    <td>technoName*</td>
    <td>technoDescription</td>
  </tr>
  <form action="/AddTech" method="post">
    <tr>
      <td><input type="number" name="techID"></td>
      <td><input type="text" name="techName"></td>
      <td><input type="text" name="techDescription"></td>
    </tr>
    <input type="submit" value="add Tech" name="addTech">
  </form>
</table>

</body>
</html>
