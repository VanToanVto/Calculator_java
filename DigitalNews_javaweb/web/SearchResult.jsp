<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
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
                    <h3>The result search have ${result} news</h3>
                    <c:forEach items="${listS}" var="o">
                        <div class="per-article">
                            <div class="title" id="titles">
                                <a href="DetailControl?id=${o.id}">      
                                    ${o.title}
                                </a>
                            </div> 
                            <div class="image_search">
                            <img src="${o.image}" alt=""/>
                        </div>
                            <div class="search-description">
                                ${o.shortDes}
                            </div>
                        </div>
                    </c:forEach>
                    <div class="paging">
                        <c:if test="${endP > 1}">
                            <c:forEach begin="1" end="${endP}" var="i">
                                <a class="${tag==i?"active":""}" href="SearchControl?index=${i}&txtSearch=${txt}">${i}</a>
                            </c:forEach>
                        </c:if>
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
                            <input type="text" name="txtSearch" id="input" value="${txtS}" >
                            <button type="submit" id="search">Go</button>
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
        <script>
            let search = () =>{
                let textToSearch = document.getElementById("input").value
                let titles = document.querySelectorAll(".title")
                let pattern = new RegExp(textToSearch,"gi");
                titles.forEach((title) => {
                    title.innerHTML = title.innerHTML.replace(pattern, match => {
                        return `<mark>` + match + `</mark>`
                    }
                )  
                })
            }
            search()

        </script>
    </body>
</html>
