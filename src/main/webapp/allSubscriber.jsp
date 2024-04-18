<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des abonnés</title>
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
        <a href="${pageContext.request.contextPath}/saveSubscriber.jsp">Ajouter un nouvel abonné</a> 
    </div>
    <div class="add-button">
    	<a href="${pageContext.request.contextPath}/searchForm.jsp">Rechercher un abonné</a>
    </div>
    <h2>Liste Des abonnés!</h2>
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
            <c:forEach var="subscriber" items="${subscribers}">
                <tr>
                    <td>${subscriber.numMatricule}</td>
                    <td>${not empty subscriber.name ? subscriber.name : 'N/A'}</td>
                    <td>${not empty subscriber.adresse ? subscriber.adresse : 'N/A'}</td>
                     <td>${not empty subscriber.phone ? subscriber.phone : 'N/A'}</td>
                    <td>${not empty subscriber.dateAdh ? subscriber.dateAdh : 'N/A'}</td>
                    <td>${not empty subscriber.yearBirth ? subscriber.yearBirth : 'N/A'}</td>
                    <td>${not empty subscriber.professionalCategory ? subscriber.professionalCategory: 'N/A'}</td>
                    <td>
   						 <a href="${pageContext.request.contextPath}/editSubscriber?numMatricule=${subscriber.numMatricule}">Modifier</a>
    					<a href="${pageContext.request.contextPath}/deleteSubscriber?numMatricule=${subscriber.numMatricule}">Supprimer</a>
					</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>
