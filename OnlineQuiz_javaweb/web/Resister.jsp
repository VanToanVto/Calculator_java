<%-- 
    Document   : Resister
    Created on : Jun 29, 2021, 4:40:21 PM
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
        <title>Register</title>
    </head>
    <body>
        <div class="container">
              <jsp:include page="Menu.jsp"/>
                <div class="content">
                    <h3>Register Form</h3>
                    <form action="register" method="post">
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
                            <td class="loginLabels">User Type:</td>
                            <td>
                                <select class="slRole" name="role">
                                     <option value="1">Teacher</option>
                                    <option value="2">Student</option>
                                   
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td class="loginLabels">Email:</td>
                            <td>
                                <input type="text" name="email" class="inputEmail">
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                                <button type="submit" class="sign_in">Register</button>
                            </td>
                        </tr>
                    </table>
                </form>
                <div class="registerProblemMessage">${mess}</div>
            </div>
        </div>
    </body>s
</html>
