<%-- 
    Document   : jouer_quiz
    Created on : 28 juin 2016, 10:54:02
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quiz Play</title>
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
            <h1>Vous jouez le Quiz ${quizNom}</h1>
            
            <h1>score : ${score}</h1>

            <h3>Question : ${quizQuestion.ordre}</h3>
            
            <h4>Réponse : </h4>
            
            <form method="GET" action="play">

                <input type="radio" name="rep" value="1" class="put" /><h6 class="put">${quizQuestion.rep1}</h6>

                <input type="radio" name="rep" value="2" class="put" /><h6 class="put">${quizQuestion.rep2}</h6>

                <input type="radio" name="rep" value="3" class="put" /><h6 class="put">${quizQuestion.rep3}</h6>

                <input type="radio" name="rep" value="4" class="put" /><h6 class="put">${quizQuestion.rep4}</h6>

                <input type="submit" value="Suivante" />

            </form>
            
        </div>
        
        <div class="pied">
            <c:import url="_PIED.jsp" />
        </div>
        
    </body>
</html>
