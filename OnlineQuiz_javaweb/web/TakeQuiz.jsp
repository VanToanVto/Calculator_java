<%-- 
    Document   : TakeQuiz
    Created on : Jul 6, 2021, 11:37:36 PM
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
        <title>Take Quiz</title>
    </head>
    <body >
        <div class="container">
            <div class="header"></div>
            <div class="menu">
                <div class="menuItems">
                    <c:if test="${sessionScope.user.role == 2}">
                        
                        <a href="#">Home</a>
                        <a class="menuTakeQuiz" href="#">Take Quiz</a>
                        <a class="menuLogout" href="#">Log out</a>

                    </c:if>
                    <c:if test="${sessionScope.user.role == 1}">
                        <a href="#">Home</a>
                        <a class="menuTakeQuiz" href="#">Take Quiz</a>
                        <a class="menuMakeQuiz" href="#">Make Quiz</a>
                        <a class="menuManageQuiz" href="#">Manage Quiz</a>
                        <a class="menuLogout" href="#">Log out</a>
                    </c:if>

                </div>
            </div>
            <div class="content">
                <div class="titleLabel">
                    Welcome
                    <span class="username">${sessionScope.user.user_name}</span>
                </div>
                <div class="startQuestion">
                    <div class="timeRemaining">
                        Time Remaining: 
                        <span class="time" id="t"></span>
                    </div>
                    <c:forEach items="${list}" var="item">
                        <div class="perQuestion">
                            <form name="startQuizForm"  action="start-quiz" method="post">
                                <div class="questionName">${item.question}</div>
                                <table>
                                    <tr>
                                        <td><input type="checkbox" name="choice" value="1"></td>
                                        <td>${item.option1}</td>
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox" name="choice" value="2"></td>
                                        <td>${item.option2}</td>
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox" name="choice" value="3"></td>
                                        <td>${item.option3}</td>
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox" name="choice" value="4"></td>
                                        <td>${item.option4}</td>
                                    </tr>
                                </table>
                                <button style="margin: 40px 300px;" id="btn" onclick="nextQuestion(${item.id})" type="button">Next</button>
                            </form>
                        </div>  

                    </c:forEach>

                </div>
            </div>
        </div>
        <script>
                           
            var index = ${tag};// cho cai vtri ban dau là 0
            var txt = '${txt}';//luu lai cau hoi va dap an
            var questions = document.getElementsByClassName('perQuestion');
            function display() {
                //1: an cac cau hoi đi đe hien lên tung cau 1
                for (var i = 0; i < questions.length; i++) {
                        questions[i].style.display = 'none';
			}
			questions[index].style.display = 'block';
			}
		display();
            function submitToServer() {
                  //5: submit du lieu ve server
                //(submit khi mà ng dùng làm xong câu hỏi cuối cùng)
                if (index === questions.length - 1) {//o câu hỏi cuối cùng
                    //muon submit du lieu ve server thif p cos form
                    var myForm = document.createElement("form");
                    myForm.method = "POST";
                    myForm.action = "result";// servlet the laf resultControl
                    myForm.style.display = "none";//form k hthi ma chi sinh ra de day du lieu ve server
                    var myInput = document.createElement("input");
                    myInput.type = "text";
                    myInput.name = "data";
                    myInput.value = txt; //value =txt de truyen du lieu ve server
                    myForm.appendChild(myInput);//add input ve form 
                    document.body.appendChild(myForm);// add form vaof trang web
                    myForm.submit();// submit ve server
			}
			}
                        //lay bo cau hoi va dap an ma ng dung tich ve
		function addQuestion(qid) {
                   
                    txt += qid + '-';
                    var checkboxes = document.querySelectorAll('input[type=checkbox]:checked');
                    if (checkboxes.length !== 0) {
                            for (var i = 0; i < checkboxes.length; i++) {
				if (i !== checkboxes.length) {
					txt += checkboxes[i].value; 
				} 
					}
				//xoa
                            for (var i = 0; i < checkboxes.length; i++) {
					checkboxes[i].checked = false;
					}
				}
				if (index !== questions.length - 1) {
					txt += '|';
                                }
			}
			
			function nextQuestion(qid) {
				addQuestion(qid);
				submitToServer();
				index++;
				document.cookie = "myindex=" + index;
				document.cookie = "answers=" + txt;
				console.log(txt);
				display();
			}

			var total = ${total}; 
			function timer() {
				total--;
                                //khi maf tg chay ve 0 thi nut button tu dong submit
				if (total <= 0) {
					document.getElementById('btn').click();
					submitToServer();
					return;
				}
				var minute = Math.floor(total / 60);
				var second = total - minute * 60;
                                
				var timeBox = document.getElementById('t');
				if (second < 10) {
					timeBox.innerHTML = minute + ":0" + second;
				} else {
					timeBox.innerHTML = minute + ":" + second;
				}
			}
			timer();
			setInterval(function () {
				timer();
			}, 1000);

    


        </script>
    </body>
</html>
