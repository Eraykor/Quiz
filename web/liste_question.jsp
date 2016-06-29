<%-- 
    Document   : liste_question
    Created on : 24 juin 2016, 15:22:37
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
            <h2>Quiz ${quizNom}</h2>
            
            <a href="create_question" class="cree_q">Créer des Questions</a>
            
            <br>
            <br>

            <table class="table_admin">
                    <thead>
                        <th>Titre Question</th>
                        <th>Ordre</th>
                        <th>Reponse 1</th>
                        <th>Reponse 2</th>
                        <th>Reponse 3</th>
                        <th>Reponse 4</th>
                    </thead>
                    <tbody>

                        <c:forEach items="${questions}" var="q">
                            <tr>
                                <td>${q.titre}</td>
                                <td>${q.ordre}</td>
                                <td>${q.rep1}</td>
                                <td>${q.rep2}</td>
                                <td>${q.rep3}</td>
                                <td>${q.rep4}</td>
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
