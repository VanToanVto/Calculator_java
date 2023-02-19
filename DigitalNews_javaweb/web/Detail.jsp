<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detail Page</title>
        <link href="css/Style.css" rel="stylesheet" type="text/css"/>
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
                        ${detail.title}
                    </div>
                    <div class="image">
                        <img src="${detail.image}" alt=""/>
                    </div>    
                    <div class="description">
                      ${detail.description}

                    </div>
                    <div class="author">
                        <img src="images/timeicon.gif" alt=""/>
                        <img src="images/comment.gif" alt=""/>
                        By ${detail.author} | ${detail.timePost}

                    </div>
                </div>
                <div class="right">
                    <div class="title">
                        Digital News
                    </div>
                    <div class="short-des">
                       ${detail.shortDes}
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
