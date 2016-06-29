<%-- 
    Document   : _MENU
    Created on : 24 juin 2016, 14:23:34
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<ul>
    <li><a href="quiz_home" class="menu_click accueil">Accueil</a></li>
    
    <c:choose>
        
        <c:when test="${login==null}">
            <li><a href="login" class="menu_click">Connection</a></li>
        </c:when>
            
        <c:otherwise>
            <li><a href="titre_quiz" class="menu_click">Créer Quiz</a></li>
            
            <li><a href="logout" class="menu_click">Déconnection</a></li>
        </c:otherwise>
            
    </c:choose>
</ul>