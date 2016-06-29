<%-- 
    Document   : score
    Created on : 28 juin 2016, 16:22:19
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
            <h1>Votre score Final est de : ${score}</h1>
        </div>
        
        <div class="pied">
            <c:import url="_PIED.jsp" />
        </div>
    </body>
</html>
