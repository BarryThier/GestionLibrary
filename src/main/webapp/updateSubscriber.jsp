<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter un livre</title>
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
    <form action="${pageContext.request.contextPath}/updateSubscriber" method="post">
        <h2>Modifiez un abonné</h2>
        <div>
            <label for="numMatricule">Num de Matricule:</label>
            <input type="text" id="numMatricule" name="numMatricule" value = "${subscriber.numMatricule}" required>
        </div>
        <div>
            <label for="name">Nom:</label>
            <input type="text" id="name" name="name" value = "${subscriber.name}" required>
        </div>
        <div>
            <label for="adresse">Adresse:</label>
            <input type = "text" id = "adresse" value = "${subscriber.adresse}" name = "adresse">
        </div>
        <div>
            <label for="telephone">Téléphone: </label>
            <input type="text" id="telephone" name="telephone" value = "${subscriber.phone}"required>
        </div>
        <div>
            <label for="dateAdh">Date D'adhésion:</label>
            <input type="text" id="dateAdh" name="dateAdh" value = "${subscriber.dateAdh}" required>
        </div>
        <div>
            <label for="dateNaissance">Date De Naissance:</label>
            <input type="date" id="dateNaissance" name="dateNaissance" value = "${subscriber.yearBirth}" required>
        </div>
        <div>
            <label for="professionalCategory">Catégorie Proféssionnelle:</label>
            <input type="text" id="professionalCategory" name="professionalCategory"  value = "${subscriber.professionalCategory}"required>
        </div>
        <div>
            <button type="submit">Modifiez</button>
        </div>
    </form>
</body>
</html>
