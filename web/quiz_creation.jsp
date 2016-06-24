<%-- 
    Document   : quiz_creation
    Created on : 24 juin 2016, 14:39:49
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
   
        <div class="header">
            <c:import url="_HEADER.jsp" />
        </div>
        
        <div class="menu">
            <c:import url="_MENU.jsp" />
        </div>
        
        <div class="contenu">
            <p>crée un <a href="quiz_creation">Quiz</a></p>
        </div>
        
        <div class="pied">
            <c:import url="_PIED" />
        </div>

    </body>
</html>
