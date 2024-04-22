<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des utilisateurs</title>
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
        <a href="${pageContext.request.contextPath}/saveUser.jsp">Ajouter un nouvel Utilisateur</a> 
    </div>
    <div class="add-button">
    	<a href="${pageContext.request.contextPath}/searchUser.jsp">Rechercher un utilisateur</a>
    </div>
    <h2>Listes Des utilisateurs</h2>
    <table>
        <thead>
            <tr>
                <th>User id</th>
                <th>FullName</th>
                <th>Pseudo</th>
                <th>Email</th>
                <th>PassWord</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.user_id}</td>
                    <td>${not empty user.fullName ? user.fullName : 'N/A'}</td>
                    <td>${not empty user.pseudo ? user.pseudo : 'N/A'}</td>
                     <td>${not empty user.email ? user.email : 'N/A'}</td>
                    <td>${not empty user.password ? user.password : 'N/A'}</td>
                   
                    <td>
   						<a href="${pageContext.request.contextPath}/editUser?user_id=${user.user_id}">Modifier</a>
    					<a href="${pageContext.request.contextPath}/deleteUser?user_id=${user.user_id}">Supprimer</a>
					</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>
