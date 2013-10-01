<%@page import="net.bitacademy.java41.vo.Task"%>
<%@page import="net.bitacademy.java41.vo.Project"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:useBean id="member" class="net.bitacademy.java41.vo.Member" scope="session"></jsp:useBean>    
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://code.jquery.com/jquery-latest.js"></script>

<script type="text/javascript">
function updateSlider(slideAmount) {
//get the element
var display = document.getElementById("chosen");
//show the amount
display.innerHTML=slideAmount+"%";
}
</script>

<title>SPMS</title>
<link rel="stylesheet" href="${rootPath}/css/style.css">
</head>
<body>

<jsp:include page="/header.do"></jsp:include>

<jsp:include page="/sidebar.do"></jsp:include>

<div class="content">

<a href="view.do?no=${pno}">[기본정보]</a> |
<a href="../task/list.do?no=${pno}">[작업들]</a> |
<a href="../feed/list.do?pno=${pno}">[게시판]</a>

<h3>Task 추가</h3>

<form action="add.do" method="post" enctype="multipart/form-data">

Project No.${pno} <input type="text" name="pno" value="${pno}" readonly> 
Writener <input type="text" name="email" value="${member.email}" readonly>
<br>
UI Prototype <input type="file" name="UIFile"><br>
<input type="hidden" name="NoUI" value="">

Work Title <input type="text" name="title" required ><br>

CONTENT <br>
<textarea rows="5" cols="50" name="content"></textarea><br>
Start Date<input type="date" name="startDate" required><br>
End Date<input type="date" name="endDate" required><br>
Status<select name="status">
<option value="0" selected>0%</option>
<option value="1" >10%</option>
<option value="2" >20%</option>
<option value="3" >30%</option>
<option value="4" >40%</option>
<option value="5" >50%</option>
<option value="6" >60%</option>
<option value="7" >70%</option>
<option value="8" >80%</option>
<option value="9" >90%</option>
<option value="10">작업완료(100%)</option>
</select><br>

<br>(아래 기능은 구현중..)

<br> 0(%)<input type="range" min="0" max="100" name="status1" step="1"  value="this.value" onchange="updateSlider(this.value)" required>100(%)
<div id="chosen"></div>
<input type="submit" value="Task Add!" >

<input type="reset" value="Reset!" >

</form>







</div>

<jsp:include page="/tail.do"></jsp:include>
</body>
</html>