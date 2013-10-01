<%@page import="net.bitacademy.java41.vo.Task"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
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
<a href="../feed/list.do?projectNo=${pno}">[게시판]</a>


<h3>Task 변경</h3>

<form action="update.do" method="post" enctype="multipart/form-data">
<input type="hidden" name="tno" value="${uptask.tno}">
Project No.${pno} <input type="hidden" name="pno" value="${pno}" readonly> 
<input type="hidden" name="email" value="${member.email}" readonly>
<br>
Work Title <input type="text" name="title" value="${uptask.title}" required ><br>
UI Prototype <input type="file" name="UIFile"><br>
<input type="hidden" name="Orignal_uiProtoUrl" value="${uptask.uiProtoUrl}">
CONTENT <br>
<textarea rows="5" cols="50" name="content">${uptask.content}</textarea><br>
Start Date<input type="date" name="startDate" value="${uptask.startDate }" required><br>
End Date<input type="date" name="endDate" value="${uptask.endDate }" required><br>
Status<select name="status">
<option value="0" <c:if test="${uptask.status}==0">selected</c:if>>0%</option>
<option value="1" <c:if test="${uptask.status}==1">selected</c:if> >10%</option>
<option value="2" <c:if test="${uptask.status}==2">selected</c:if>>20%</option>
<option value="3" <c:if test="${uptask.status}==3">selected</c:if>>30%</option>
<option value="4" <c:if test="${uptask.status}==4">selected</c:if>>40%</option>
<option value="5" <c:if test="${uptask.status}==5">selected</c:if>>50%</option>
<option value="6" <c:if test="${uptask.status}==6">selected</c:if>>60%</option>
<option value="7" <c:if test="${uptask.status}==7">selected</c:if>>70%</option>
<option value="8" <c:if test="${uptask.status}==8">selected</c:if>>80%</option>
<option value="9" <c:if test="${uptask.status}==9">selected</c:if>>90%</option>
<option value="10"<c:if test="${uptask.status}==10">selected</c:if>>작업완료(100%)</option>
</select><br>


<input type="submit" value="Task Add!" >

<input type="reset" value="Reset!" >

</form>







</div>

<jsp:include page="/tail.do"></jsp:include>
</body>
</html>