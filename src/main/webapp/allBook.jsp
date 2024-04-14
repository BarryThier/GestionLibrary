<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des livres</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }


        th {
            background-color: #f2f2f2;
        }

        .add-button {
            margin-top: 10px;
        }
    </style>
</head>
<body>
	 <div class="add-button">
        <a href="${pageContext.request.contextPath}/saveBooks.jsp">Ajouter un nouveau livre</a> 
    </div>
    <div class="add-button">
    	<a href="${pageContext.request.contextPath}/searchBooksByKeywords.jsp">Rechercher un livre à travers son mot clé</a>
    </div>
    <h2>Liste des abonnés</h2>
    <table>
        <thead>
            <tr>
                <th>Numéro de Matricule</th>
                <th>Nom</th>
                <th>Adresse</th>
                <th>Téléphone</th>
                <th>Date D'adhésion</th>
                <th>Date De Naissance</th>
                <th>Catégorie Proféssionnelle</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="book" items="${books}">
                <tr>
                    <td>${book.codeCatalogue}</td>
                    <td>${not empty book.titre ? book.titre : 'N/A'}</td>
                    <td>${not empty book.auteur ? book.auteur : 'N/A'}</td>
                     <td>${not empty book.editeur ? book.editeur : 'N/A'}</td>
                    <td>${not empty book.theme ? book.theme : 'N/A'}</td>
                    <td>${not empty book.dateAcq ? book.dateAcq : 'N/A'}</td>
                    <td>${not empty book.codeUsure ? book.codeUsure: 'N/A'}</td>
                    <td>
   						 <a href="${pageContext.request.contextPath}/editBook?codeCatalogue=${book.codeCatalogue}">Modifier</a>
    					<a href="${pageContext.request.contextPath}/deleteBook?codeCatalogue=${book.codeCatalogue}">Supprimer</a>
					</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>
