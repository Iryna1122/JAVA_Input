<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 21.08.2023
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Math operations:</title>
</head>
<body>
<form action="math-servlet" method="post">
    <input type="number" name="num1"><br>
    <input type="number" name="num2"><br>
    <input type="number" name="num3"><br>
    <input type="radio" name="operation" value="max"> max
    <input type="radio" name="operation" value="min"> min
    <input type="radio" name="operation" value="avg"> avg
    <input type="submit">
</form>
</body>
</html>
