<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter un abonné</title>
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
    <form action="${pageContext.request.contextPath}/saveSubscriber" method="post">
        <h2>Ajouter un nouvel abonné</h2>
        
        <div>
            <label for="name">Nom:</label>
            <input type="text" id="name" name="name" required>
        </div>
        <div>
            <label for="adresse">Adresse:</label>
            <input type = "text" id = "adresse" name = "adresse">
        </div>
        <div>
            <label for="telephone">Téléphone: </label>
            <input type="text" id="telephone" name="telephone" required>
        </div>
        <div>
            <label for="dateAdh">Date d'adhésion:</label>
            <input type="date" id="dateAdh" name="dateAdh"  required>
        </div>
        <div>
            <label for="dateNaissance">Date de Naissance:</label>
            <input type="date" id="dateNaissance" name="dateNaissance"  required>
        </div>
        <div>
            <label for="professionalCategory">Catégorie Proféssionnelle:</label>
            <input type="text" id="professionalCategory" name="professionalCategory"  required>
        </div>
        <div>
            <button type="submit">Ajouter un abonné</button>
        </div>
    </form>
</body>
</html>
