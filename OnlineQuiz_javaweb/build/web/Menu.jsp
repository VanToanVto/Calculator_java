<%-- 
    Document   : Menu
    Created on : Jun 29, 2021, 3:22:18 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/menu.css" rel="stylesheet" type="text/css"/>
        <link href="css/narbar.css" rel="stylesheet" type="text/css"/>
        <title>Header</title>
    </head>
    <body>
        <div class="header"></div>
        <div class="menu" >
            <div class="menuItems" id="myTopnav">
                <c:if test="${sessionScope.user.role==null}">
                    <a href="#">Home</a>
                    <a href="login">Take Quiz</a>
                    <a href="login">Make Quiz</a>
                    <a href="login">Manage Quiz</a>
                </c:if>
                <c:if test="${sessionScope.user.role==1}">
                    <a href="#">Home</a>
                    <a href="StartQuiz.jsp">Take Quiz</a>
                    <a href="MakeQuiz.jsp">Make Quiz</a>
                    <a href="manager">Manage Quiz</a>
                    <a href="logout">Log out</a>
                </c:if>

                <c:if test="${sessionScope.user.role==2}">
                    <a href="#">Home</a>
                    <a href="StartQuiz.jsp">Take Quiz</a>
                    <a href="logout">Log out</a>
                </c:if>
                <a href="javascript:void(0);" style="font-size:15px;" class="icon" onclick="myFunction()">&#9776;</a>
            </div>
        </div>
        <script>
            function myFunction() {
//                khi icon dc kich thì nó sẽ day sang css resposive
                var x = document.getElementById("myTopnav");
                if (x.className === "menuItems") {
                    x.className += " responsive";
                } else {
                    x.className = "menuItems";
                }
            }
        </script>
    </body>
</html>
