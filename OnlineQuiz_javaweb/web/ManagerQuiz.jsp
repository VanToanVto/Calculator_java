<%-- 
    Document   : ManagerQuiz
    Created on : Jul 6, 2021, 10:01:28 PM
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
        
        <title>Manage Quiz</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="Menu.jsp"/>
                <div class="content">
                    <div class="manageQuizContent">
                        <span class="totalQuestion">
                            Number of question:
                        </span>
                        <span class="numOfQuest">
                       ${numOfQuestion}
                    </span>
                    <div class="listQuiz">
                        <table>
                            <tr>
                                <th class="titleQuestion">
                                <c:if test="${numOfQuestion!=0}">Question</c:if> 
                                </th>
                                <th class="titleDateCreated">
                                    <c:if test="${numOfQuestion!=0}">
                                    DateCreated
                                </c:if>
                                </th>
                            </tr>
                            <c:forEach items="${listQuiz}" var="o">
                                <tr>
                                    <td class="questionName">
                                        <a href="">${o.question}</a>
                                    </td>
                                    <td class="dateCreated">
                                        ${o.createdDate}
                                    </td>
                                </tr>
                            </c:forEach>    
                        </table>
                    </div>
                    
                </div>
            </div>
        </div>
    </body>
</html>
