<%-- 
    Document   : Login
    Created on : Jun 29, 2021, 3:15:06 PM
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
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        
        <title>Login</title>
    </head>
    <body>
        <div class="container">
          <jsp:include page="Menu.jsp"/>
                <div class="content">
                    <h3>Login Form</h3>
                 
                    <form action="login" method="post">
                    <table>
                        <tr>
                            <td class="loginLabels">User Name:</td>
                            <td>
                                <input type="text" name="user" class="inputUsername">
                            </td>
                        </tr>
                        <tr>
                            <td class="loginLabels">Password:</td>
                            <td>
                                <input type="password" name="pass" class="inputPassword">
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                                <input type="submit" class="btnLogin" value="Sign in"/>
                                <a class="registerLink" href="Resister.jsp">Register</a>
                            </td>
                        </tr>
                    </table>
                </form>
                <div class="loginProblemMessage">${mess}</div>
            </div>
        </div>
    </body>
</html>
