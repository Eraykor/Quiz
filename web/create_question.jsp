<%-- 
    Document   : create_question
    Created on : 27 juin 2016, 09:41:10
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
            <h1>creation de question pour le Quiz ${quizNom}</h1>
            
            <form method="POST" action="create_question">
                
                <p>Titre de la Question :</p>
                <input type="text" name="titre" />
                
                <p>Ordre</p>
                <input type="text" name="ordre" />
                
                <p>Réponse 1</p>
                <input type="text" name="rep1" /><input type="radio" name="rep" value="1" />
                
                <p>Réponse 2</p>
                <input type="text" name="rep2" /><input type="radio" name="rep" value="2" />
                
                <p>Réponse 3</p>
                <input type="text" name="rep3" /><input type="radio" name="rep" value="3" />
                
                <p>Réponse 4</p>
                <input type="text" name="rep4" /><input type="radio" name="rep" value="4" />
                <br>
                <br>
                
                <input type="submit" value="valider" />
                
            </form>
        </div>
        
        <div class="pied">
            <c:import url="_PIED.jsp" />
        </div>
        
    </body>
</html>
