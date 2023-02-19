<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link href="css/Style.css" rel="stylesheet" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div class="container">
            <div class="pre-header">

            </div>
            <div class="header">
                <h3>My digital news</h3>
            </div>
            <div class="menu">
                <a href="#">News</a>
            </div>
            
            <div class="main">
                <div class="left">
                    <div class="title">
                        ${top1.title}
                    </div>
                    <div class="image">
                        <img src="${top1.image}" alt=""/>
                    </div>   
                    <div class="description">
                        ${top1.description}

                    </div>
                    <div class="author">
                        <img src="images/timeicon.gif" alt=""/>
                        <img src="images/comment.gif" alt=""/>
                        By ${top1.author} | ${top1.timePost}

                    </div>
                </div>
                <div class="right">
                    <div class="title">
                        Digital News
                    </div>
                    <div class="short-des">
                        ${top1.shortDes}
                    </div>
                    <div class="title">
                        Search
                    </div>   
                    <div>
                        <form action="SearchControl" method="post">
                            <input type="text" name="txtSearch" >
                            <button type="submit">Go </button>
                        </form>
                    </div>
                    <div class="title">
                        Last Articles
                    </div>
                     <c:forEach items="${top5}" var="o">
                    <div class="list">
                   
                        <a href="DetailControl?id=${o.id}">${o.title}</a>
                   
                    </div>
                         </c:forEach>
                </div>   
            </div>
            <div class="footer">

            </div>
        </div>
    </body>
</html>
