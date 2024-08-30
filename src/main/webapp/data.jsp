<%@ page import="com.flower.repository.FlowerRepository" %>
<%@ page import="java.util.List" %>
<%@ page import="com.flower.entity.Flower" %>
<%@ page import="com.flower.service.FlowerService" %>
<%@ page import="com.flower.entity.Flower" %>
<%@ page import="com.flower.repository.FlowerRepository" %>

<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Information</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            padding: 0;
            background-color: #f2f2f2;
        }

        h1 {
            color: #333;
            text-align: center;
        }

        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            border: 1px solid #ddd;
            background-color: #fff;
        }

        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #f5f5f5;
        }

        form {
            text-align: center;
            margin-top: 20px;
        }

        input[type="text"], input[type="submit"] {
            padding: 10px;
            font-size: 16px;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

<h1>Flower Information</h1>

<form action="${pageContext.servletContext.contextPath}/flower/data" method="post">
    <label for="id_flower">Enter Flower ID:</label>
    <input type="text" id="id_flower" name="id_flower">
    <input type="submit" value="Submit">
</form>

<form id="myForm" action="${pageContext.servletContext.contextPath}/flower/add" method="post">
    <label for="new_name">Enter Name:</label>
    <input type="text" id="new_name" name="name">
    <input type="submit" value="Add">
</form>

<script>
    document.getElementById('myForm').addEventListener('submit', function(event) {
        event.preventDefault(); // Предотвращаем отправку формы

        var nameValue = document.getElementById('new_name').value;
        var formAction = this.getAttribute('action');
        formAction += "?new_name=" + encodeURIComponent(nameValue);
        this.setAttribute('action', formAction);

        this.submit();
    });
</script>
<table>
    <tr>
        <th>ID</th>
        <th>PROFILE ID</th>
        <th>Name</th>
    </tr>
    <%
        FlowerService flowerService = new FlowerService(new FlowerRepository());
        Long id = (Long) request.getAttribute("id");
        List<Flower> flowers = flowerService.getAllFlower(id);
        for (Flower flower : flowers) {
%>
<tr>
    <td><%= flower.getId() %></td>
    <td><%= flower.getId_profile() %></td>
    <td><%= flower.getName() %></td>
</tr>
<%
        }
    %>
</table>

<form action="${pageContext.servletContext.contextPath}/logout" method="post">
    <input type="submit" value="Logout" name="Logout">
</form>

</body>
</html>
