<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter un utilisateur</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        form {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            color: #333333;
        }

        label {
            display: block;
            margin-bottom: 8px;
            color: #333333;
        }

        input, textarea {
            width: 100%;
            padding: 8px;
            margin-bottom: 16px;
            box-sizing: border-box;
            border: 1px solid #dddddd;
            border-radius: 4px;
        }

        button {
            background-color: #4caf50;
            color: #ffffff;
            padding: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <form action="${pageContext.request.contextPath}/saveUser" method="post">
        <h2>Ajouter un nouvel utilisateur</h2>
        
        <div>
            <label for="fullName">FullName:</label>
            <input type="text" id="fullName" name="fullName" value = "${user.fullName}" required>
        </div>
        <div>
            <label for="pseudo">Pseudo:</label>
            <input type = "text" id = "pseudo" value = "${user.pseudo}" name = "pseudo">
        </div>
        <div>
            <label for="email">Email:</label>
            <input type="Email" id="email" name="email" value = "${user.email}"required>
        </div>
        <div>
            <label for="password">Password:</label>
            <input type="Password" id="password" name="password" value = "${user.password}" required>
        </div>
        <div>
            <button type="submit">Ajouter un utilisateur </button>
        </div>
    </form>
</body>
</html>
