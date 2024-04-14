<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style>
			nav {
				
				padding:15px;
				margin-right:0px;
				background-color:blue;
				color:white;
				margin-bottom:10px;
				border-top-right-radius:10px;
				border-top-left-radius:10px;
			}
			fieldset{
				padding:0%;
				width: 50%;
				margin:auto;
				background-color:gray-white;
				border-radius:10px;
			}
			div{
				display:inline;
			}
			button{
			 padding:5px;
			 background-color:blue;
			 color:white;
			 border:none;
			 border-radius:3px;
			 margin-bottom:10px;
			 cursor:pointer;
			}
			input{
				outline:none;
			}
		</style>
	</head>
	<body>
		<fieldset>
			
		<form action="${pageContext.request.contextPath}/Books" method = "post">
			<nav>Recherche des livres</nav>
			<div>
				<label for = "keywords">Keywords: </label>
				<input type = "text" id ="keywords" name = "keywords">
			</div>
			<button type = "submit">Chercher</button>
		</form>
		
		</fieldset>
		
	</body>
</html>