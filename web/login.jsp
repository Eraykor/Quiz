<%-- 
    Document   : login
    Created on : 28 juin 2016, 11:30:46
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Quiz</title>
        <c:import url="_STYLESHEET.jsp" />
    </head>
    <body>
        
        <div class="header">
            <c:import url="_HEADER.jsp" />
        </div>
        
        <div class="menu">
            <c:import url="_MENU.jsp" />
        </div>
        
        <div class="contenu">
            <form method="GET" action="connection">
                <p>Login</p>
                <input type="text" name="login" />
                <br>
                <p>Mot de Passe</p>
                <input type="password" name="mdp" />
                <br>
                <br>
                <input type="submit" value="Valider" />
            </form>
        </div>
        
        <div class="pied">
            <c:import url="_PIED.jsp" />
        </div>
        
    </body>
</html>
