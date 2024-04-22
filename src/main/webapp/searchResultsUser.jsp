<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Résultats de la recherche</title>
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

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #4caf50;
            color: white;
        }

        a {
            text-decoration: none;
            color: #2196F3;
        }

        a:hover {
            color: #0d47a1;
        }
    </style>
</head>
<body>
    <h2>Résultats de la recherche</h2>
    <c:if test="${not empty searchedUser}">
        <table>
            <tr>
                <th>User id</th>
                <th>FullName</th>
                <th>Pseudo</th>
                <th>Email</th>
                <th>PassWord</th>
                <th>Action</th>
            </tr>
            <tr>
                <td>${not empty searchedUser.user_id ? searchedUser.user_id: 'N/A'}</td>
                <td>${not empty searchedUser.fullName ? searchedUser.fullName : 'N/A'}</td>
                <td>${not empty searchedUser.pseudo ? searchedUser.pseudo : 'N/A'}</td>
                <td>${not empty searchedUser.email ? searchedUser.email : 'N/A'}</td>
                <td>${not empty searchedUser.password ? searchedUser.password : 'N/A'}</td>
      
                <td>
                  		<a href="${pageContext.request.contextPath}/editUser?user_id=${searchedUser.user_id}">Modifier</a>
    					<a href="${pageContext.request.contextPath}/deleteUser?user_id=${searchedUser.user_id}">Supprimer</a>
                </td>
            </tr>
        </table>
    </c:if>
</body>
</html>
