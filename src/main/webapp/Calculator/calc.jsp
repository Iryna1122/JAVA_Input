<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 22.08.2023
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>

<form action="calc-servlet" method="post">
    <input type="number" name="num1" min="1"><br><hr><br>
    <input type="radio" name="operation" value="+"> +
    <input type="radio" name="operation" value="-"> -
    <input type="radio" name="operation" value="*"> *
    <input type="radio" name="operation" value="/"> /
    <input type="radio" name="operation" value="pow"> pow
    <input type="radio" name="operation" value="%"> %
    <br><br><hr><input type="number" name="num2" min="1">
    <input type="submit" value="Calculate">

</form>

</body>
</html>
