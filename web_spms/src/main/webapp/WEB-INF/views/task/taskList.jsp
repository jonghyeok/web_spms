<%@page import="net.bitacademy.java41.vo.Task"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SPMS</title>
<link rel="stylesheet" href="${rootPath}/css/style.css">
</head>
<body>
<jsp:include page="/header.do"></jsp:include>

<jsp:include page="/sidebar.do"></jsp:include>


<div id="content">
<h1>TASK...</h1>
<a href="../project/view.do?no=${pno}">[기본정보]</a> |
<a href="../task/list.do?no=${pno}">[작업들]</a> |
<a href="..//task/add.do?no=${pno}">[테스크 추가]</a>
<a href="../feed/list.do?projectNo=${pno}">[게시판]</a>
<br>
<br>
<table border=2>
<tr>
	<th>제목</th>
	<th>E-Mail</th>
	<th>시작일</th>
	<th>종료일</th>
	<th>최근 수정일</th>
	<th>상태</th>
</tr>
<c:forEach var="task" items="${list}">

<tr>
	<td><a href="../task/view.do?no=${task.tno}">${task.title}</a></td>
	<td><a href="../member/view.do?email=${task.email}">${task.email}</a></td>
	<td>${task.startDate}</td>
	<td>${task.endDate}</td>
	<td>${task.drawDate}</td>
	<td>${task.status}</td>
</tr>
</c:forEach>
</table>

</div>

<jsp:include page="/tail.do"></jsp:include>

</body>
</html>









