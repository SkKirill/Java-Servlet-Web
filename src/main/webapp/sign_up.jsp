<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .login-container {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            color: #333333;
        }

        input[type="text"],
        input[type="password"],
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin-top: 10px;
            margin-bottom: 10px;
            border: 1px solid #cccccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #007bff;
            color: #ffffff;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }

        button {
            padding: 10px 7px;
            background: #5cda60;
            border-radius: 5px;
            width: 100%;
            outline: none;
            color: white;
            border: 0px;
            transition: all 300ms ease-in-out;
        }

        button:hover {
            background: #4caf50;
            transform: translateY(5px);
        }

    </style>
</head>
<body>
<div class="login-container">
    <h2>Registration</h2>
    <form action="sign_up" method="POST">
        <input type="text" name="login" id="login" placeholder="Login"><br>
        <input type="password" name="password" id="password" placeholder="Password"><br>
        <button type="submit">Зарегистрироваться</button>
    </form>
</div>
</body>
</html>

