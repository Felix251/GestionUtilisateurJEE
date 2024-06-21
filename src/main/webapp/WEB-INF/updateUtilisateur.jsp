<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modifier un Utilisateur</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .container {
            width: 300px;
            border: 2px solid #ccc;
            padding: 20px;
            text-align: center;
        }

        label {
            display: block;
            margin-bottom: 10px;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Modifier un Utilisateur</h1>
        <%-- Récupération des informations de l'utilisateur à partir de l'attribut de la requête --%>
            <% beans.Utilisateur utilisateur = (beans.Utilisateur) request.getAttribute("utilisateur"); %>
        <form action="update" method="post">
            <%-- Champ caché pour l'ID de l'utilisateur
            utiliser c:out pour ne pas exposer les donnees
             --%>
            <input type="hidden" name="id" value=<%=utilisateur.getId()%> >
            <label for="nom">Nom</label>
            <input type="text" id="nom" name="nom" value=<%=utilisateur.getNom()%> ><br>

            <label for="prenom">Prénom :</label>
            <input type="text" id="prenom" name="prenom" value=<%=utilisateur.getPrenom()%> ><br>

            <label for="login">Login :</label>
            <input type="text" id="login" name="login" value=<%=utilisateur.getLogin()%> ><br>

            <label for="password">Mot de passe :</label>
            <input type="password" id="password" name="password" value=<%=utilisateur.getPassword()%> ><br>

            <input type="submit" value="update">
            
        </form>
        <button onclick="window.location.href='list'">Retour</button>
    </div>
</body>
</html>
