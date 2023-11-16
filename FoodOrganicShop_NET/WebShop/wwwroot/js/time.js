var now = new Date();
var year = now.getFullYear();
var month = String(now.getMonth() + 1).padStart(2, '0');
var day = String(now.getDate()+3).padStart(2, '0');
var formattedDate = year + '/' + month + '/' + day;
document.getElementById("time").setAttribute("data-countdown", formattedDate); 