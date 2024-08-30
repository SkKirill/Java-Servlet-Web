<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Management</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        .container {
            max-width: 400px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            margin-bottom: 30px;
        }

        label {
            display: block;
            margin-bottom: 10px;
        }

        input[type="text"],
        input[type="password"],
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #4caf50;
            color: #fff;
            cursor: pointer;
            font-size: 16px;
            border: none;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>User Management</h1>
    <form action="flower/flower" method="post" id="myForm">
        <label for="id_flower">Id:</label>
        <% if (request.getParameter("id_flower")==null){
            response.sendRedirect(request.getContextPath() + "/flower/data");
        }; %>
        <input type="text" id="id_flower" name="id_flower" value="<%=request.getParameter("id_flower")%>" readonly>

        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${name}">

        <input type="submit" value="Change" name="action" onclick="setAction('change')">
        <input type="submit" value="Delete" name="action" onclick="setAction('delete')">
    </form>

    <script>
        function setAction(action) {
            document.getElementById('myForm').action = '${pageContext.servletContext.contextPath}/flower/flower?action=' + action;
        }
    </script>
    </form>
</div>
</body>
</html>
