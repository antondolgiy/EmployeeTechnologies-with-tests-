<%--
  Created by IntelliJ IDEA.
  User: Anton
  Date: 04.02.2016
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>



   <table border="1" cellpadding="2" cellspacing="1" style="width: 800px">
        <caption><strong>EDITING UZER ${requestScope['user'].userId}</strong></caption>
        <tr>
            <td>userID</td>
            <td>userName</td>
            <td>userSurname</td>
            <td>userAdress</td>
            <td>DateofBirth</td>
            <td>DateofHire</td>
        </tr>
        <form action="UpdateUser" method="post" >
            <tr>
                <td>${requestScope['user'].userId}</td>
                <td><input type="text" value=${requestScope['user'].userName} name="edName"> </td>
                <td><input type="text" value=${requestScope['user'].userSurname} name="edSurname"></td>
                <td><input type="text" value=${requestScope['user'].userAdress} name="edAdress"></td>
                <td><input type="date" value=${requestScope['user'].getDateOfBirth()} name="edDOB"></td>
                <td><input type="date" value=${requestScope['user'].getDateOfHire()} name="edDOH"></td>
            </tr>
            <br>
            <input type="hidden"  value=${requestScope['user'].userId} name="userID">
            <input type="submit" value="save changes" name="saveuzer">
        </form>
       <form action="DeleteUser" method="post">
           <input type="hidden"  value=${requestScope['user'].userId} name="userID">
           <input type="submit" value="DELETE USER" name="deluzer">

       </form>

    </table>



</body>
</html>
