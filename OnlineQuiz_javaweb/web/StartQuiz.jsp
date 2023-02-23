<%-- 
    Document   : StartQuiz
    Created on : Jun 29, 2021, 3:49:45 PM
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
        <title>Start Quiz</title>
    </head>
    <body>
        <div class="container">
           <jsp:include page="Menu.jsp"/>
                <div class="content">
                    <div class="titleLabel">
                        Welcome
                        <span class="username">${sessionScope.user.user_name}</span>
                </div>
                <div class="titleLabel">
                    Enter number of questions:
                </div>
               
                <form  class="takeQuizForm"  action="start-quiz" >
                    <input class="inputNumberOfQuestion" type="number" name="num"/>
                    <br>
                    <input  id="btnStart" class="btnStart" type="submit" value="Start"/>
                </form>
                 
            </div>
        </div>
      
    </body>
</html>
