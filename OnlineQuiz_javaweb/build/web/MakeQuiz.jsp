<%-- 
    Document   : MakeQuiz
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
        <link href="css/narbar.css" rel="stylesheet" type="text/css"/>
        
        <title>Make Quiz</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="Menu.jsp"/>
                <div class="content">
                    <form   class="makeQuizForm" action="make-quiz" method="post">
                    <table>
                        <tr>
                            <td class="makeQuizLabels">Question:</td>
                            <td>
                                <textarea name="question" rows="7" class="inputQuestion"></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td class="makeQuizLabels">Option 1:</td>
                            <td>
                                <textarea name="option1" class="inputOption"></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td class="makeQuizLabels">Option 2:</td>
                            <td>
                                <textarea name="option2" class="inputOption"></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td class="makeQuizLabels">Option 3:</td>
                            <td>
                                <textarea name="option3" class="inputOption"></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td class="makeQuizLabels">Option 4:</td>
                            <td>
                                <textarea name="option4" class="inputOption"></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td class="makeQuizLabels">Answer(s):</td>

                              <td>
                                <input  type="checkbox" value="1" name="answer"> Option 1                  
                                <input type="checkbox"  value="2"  name="answer"> Option 2
                                <input  type="checkbox" value="3" name="answer"> Option 3
                                <input type="checkbox" value="4"  name="answer"> Option 4
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                               <button type="submit" class="save">Save</button>
                            </td>
                        </tr>
                    </table>
                </form>
               
            </div>
        </div>

    </body>
</html>
