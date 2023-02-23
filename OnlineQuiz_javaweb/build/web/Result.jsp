<%-- 
    Document   : Result
    Created on : Jul 8, 2021, 11:21:49 PM
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
        <title>Result</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="Menu.jsp"/>
                <div class="content">
                    <div class="titleLabel">
                        Your score
                    <c:if test="${percen>=50}">
                        <span class="passScore">${score}(${percen}%) - PASSED</span>   
                    </c:if>
                    <c:if test="${percen<50}">
                        <span class="failScore">${score}(${percen}%)  - FAILED</span>   
                    </c:if>
                </div>
                <div class="titleLabel">
                   
                      <div class="title">Take another test <a href="StartQuiz.jsp" class="back">Start</a></div>
                      
                </div>
                <div class="endPageResult"></div>
            </div>
        </div>
    </div>
</body>
</html>
