<%@page import="net.bitacademy.java41.vo.Task"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<jsp:useBean id="member" class="net.bitacademy.java41.vo.Member" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로젝트 정보</title>
<link rel="stylesheet" href="${rootPath}/css/style.css">
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>

<jsp:include page="/sidebar.jsp"></jsp:include>

<div class="content">


<a href="../project/view.do?no=${task.pno}">[기본정보]</a> |
<a href="../task/list.do?no=${task.pno}">[작업들]</a> |
<a href="..//task/add.do?no=${task.pno}">[테스크 추가]</a>
<a href="../feed/list.do?projectNo=${task.pno}">[게시판]</a>


<h1>Task View</h1>

<table border="1" draggable="true">
<tr>
	<th>Task NO</th><th>${task.tno }</th>
	<th>Project No</th><th>${task.pno }</th>
	
</tr>

<tr>
	<td colspan="1">작업명</td><td colspan="3">${task.title }</td>
</tr>
<tr>
	<td colspan="1">작성자 E-mail</td><td colspan="3">${task.email }</td>
</tr>
<tr>
	<td colspan="1">최근 수정일</td><td colspan="3">${task.drawDate }</td>
</tr>
<tr>
	<th>시작일(착수일)</th><th>${task.startDate }</th>

	<th>종료예정일</th><th>${task.endDate }</th>
</tr>
<tr>
	<td colspan="1">상태</td><td colspan="3">${task.status*10 }%</td>
</tr>
<tr>
	<td colspan="1">내용</td><td colspan="3" height=50px;>${task.content }</td>
</tr>
<tr>
	<td colspan="1">첨부파일</td><td colspan="2">${task.uiProtoUrl }</td>
	<td colspan="1"><a href="/web_spms/upload/${task.uiProtoUrl}">Down!</a></td>
</tr>


</table>

<p>
<a href="../task/list.do?no=${task.pno}">[목록]</a>


<c:choose>
<c:when test="${member.level == 0}">
	<c:choose>
	<c:when test="${member.email == task.email}">
	<a href="../file/fileUploadForm.jsp?tno=${task.tno}&pno=${task.pno}">[파일 첨부]</a>
	<a href="../task/update.do?tno=${task.tno}&pno=${task.pno}">[수정]</a>
	<a href="../task/delete.do?tno=${task.tno}&pno=${task.pno}">[삭제]</a>
	</c:when>	
	</c:choose>

</c:when>
<c:when test="${member.level == 1}">
<a href="../task/list.do">[수정]</a>
<a href="../task/delete.do?tno=${task.tno}&pno=${task.pno}">[삭제]</a>
</c:when>
<c:when test="${member.level == 2}">
<a href="../task/delete.do?tno=${task.tno}&pno=${task.pno}">[삭제]</a>
</c:when>
<c:otherwise>권한없음</c:otherwise>
</c:choose>












</p>
</div>

<jsp:include page="/tail.jsp"></jsp:include>

</body>
</html>









