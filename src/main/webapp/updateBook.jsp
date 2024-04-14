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
    <form action="${pageContext.request.contextPath}/updateBook" method="post">
        <h2>Modifiez un livre</h2>
        <div>
            <label for="codeCatalogue">Code Catalogue:</label>
            <input type="text" id="codeCatalogue" name="codeCatalogue" value = "${book.codeCatalogue}" required>
        </div>
        <div>
            <label for="titre">Titre:</label>
            <input type="text" id="titre" name="titre" value = "${book.titre}" required>
        </div>
        <div>
            <label for="auteur">Auteur:</label>
            <input type = "text" id = "auteur" value = "${book.auteur}" name = "auteur">
        </div>
        <div>
            <label for="editeur">Editeur: </label>
            <input type="text" id="editeur" name="editeur" value = "${book.editeur}"required>
        </div>
        <div>
            <label for="theme">Thème:</label>
            <input type="text" id="theme" name="theme" value = "${book.theme}" required>
        </div>
        <div>
            <label for="dateAcq">Date d'acquisition:</label>
            <input type="date" id="dateAcq" name="dateAcq" value = "${book.dateAcq}" required>
        </div>
        <div>
            <label for="CodeUsure">Code Usure:</label>
            <input type="text" id="codeUsure" name="codeUsure"  value = "${book.codeUsure}"required>
        </div>
        <div>
            <button type="submit">Modifiez</button>
        </div>
    </form>
</body>
</html>
