<%@page import="net.bitacademy.java41.vo.Project"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=application.getContextPath()%>/style.css" rel="stylesheet"/>
<title>SPMS</title>
</head>
<body>

<jsp:include page="/header.jsp"></jsp:include>
<jsp:include page="/sidebar.jsp"></jsp:include>

<div id="content">
<h1>프로젝트</h1>
<table>
<tr>
	<th>번호</th>
	<th>프로젝트</th>
	<th>시작</th>
	<th>종료</th>
</tr>

<c:forEach var="project" items="${list}">
<tr>
	<td>${project.no}</td>
	<td><a href="view?no=${project.no}">${project.title}</a></td>
	<td>${project.startDate}</td>
	<td>${project.endDate}</td>
</tr>	
</c:forEach>
</table>

<p><a href="${rootPath}/project/add">[신규 프로젝트]</a></p>

</div>


<jsp:include page="/tail.jsp"></jsp:include>
</body>
</html>




