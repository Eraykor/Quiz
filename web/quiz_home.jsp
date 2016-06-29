<%-- 
    Document   : quiz_home
    Created on : 24 juin 2016, 14:14:59
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
            <h1>Liste des Quiz jouable !</h1>
            
            <table class="table_home">
                <tbody>
                    <c:forEach items="${quiz}" var="monQuiz">
                        <tr>
                            
                            <td><a href="jouer_quiz?quizId=${monQuiz.id}" class="deco"><h3>Jouer au ${monQuiz.nom}</h3></a></td>
                            
                            <c:if test="${login == 'admin'}">
                                <td><a href="change_quiz_actuel?quizId=${monQuiz.id}" class="deco"><h4>Modifier</h4></a></td>
                                <td><a href="supprimer_quiz_actuel?quizId=${monQuiz.id}" class="deco"><h4>Supprimer</h4></a></td>
                            </c:if>
                                
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        
        <div class="pied">
            <c:import url="_PIED.jsp" />
        </div>
        
    </body>
</html>
