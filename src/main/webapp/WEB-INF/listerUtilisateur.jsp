<%@page import="beans.Utilisateur"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Utilisateurs</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .container {
            padding: 20px;
            text-align: center;
        }

        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            border: 1px solid black;
            padding: 15px;
            text-align: left;
        }

        .add-button {
            background-color: #4CAF50;
            border: none;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin-bottom: 20px;
            cursor: pointer;
        }
        .list-btn{
        display : flex;
      	justify-content: space-between;
        
        }
       .delete-btn {
    background-color: #ff3333; 
    color: white;
    transition: background-color 0.3s; 
}

.delete-btn:hover {
    background-color: #cc0000; 
}

.update-btn {
    background-color: #0077cc; 
    color: white;
    transition: background-color 0.3s; 
}

.update-btn:hover {
    background-color: #005cb3; /* Bleu plus intense au survol */
}
        

    </style>
</head>
<body>
<div class="container">
    <h1>La liste des Utilisateurs</h1>
    
    <c:choose>
		<c:when test="${empty utilisateurs }">
		<p>Desol� la liste des utilisateurs est vide</p>
		</c:when>
		
		<c:otherwise>
    <table size="100" >
            <tr>
                <th>ID</th>
                <th>Nom</th>
                <th>Prénom</th>
                <th>Login</th>
                <th>Password</th>
                <th>Action</th>
            </tr>
           <c:forEach var="user" items="${utilisateurs}">
               <tr>
                    <td>${user.id}</td>
                    <td>${user.nom }</td>
                    <td>${user.prenom }</td>
                    <td>${user.login }</td>
                    <td>${user.password}</td>
                    <td class="list-btn" >
                        <form action="delete" method="post">
                            <input type="hidden" name="id" value=${user.id}>
                            <input  class="delete-btn" type="submit" value="Supprimer">
                        </form>
                         &nbsp; <!-- Ajoute un espace -->
                         <form action="update" method="get">
                            <input type="hidden" name="id" value=${user.id}>
                            <input class="update-btn" type="submit" value="update">
                        </form>
                    </td>
                </tr>
               
            </c:forEach>
          
        </table>
    </c:otherwise>
  
	</c:choose>

    
	<br></br>
    <button class="add-button" onclick="window.location.href='create'">Ajouter Utilisateur</button>
</div>
</body>
</html>
