<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Créer un Utilisateur</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .container {
            width: 400px; /* Ajustez la largeur du bloc ici */
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

        input[type="submit"],
        .button {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        
        .button {
            background-color: #f44336;
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Créer un Utilisateur</h1>
        <form action="create" method="post">
            <label for="nom">Nom :</label>
            <input type="text" id="nom" name="nom" required><br>

            <label for="prenom">Prénom :</label>
            <input type="text" id="prenom" name="prenom" required><br>

            <label for="login">Login :</label>
            <input type="text" id="login" name="login" required><br>

            <label for="password">Mot de passe :</label>
            <input type="password" id="password" name="password" required><br>

            <input type="submit" value="Créer">
        </form>
        <button class="button" onclick="window.location.href='list'">Retour</button>
    </div>
</body>
</html>
