<%@page import="net.bitacademy.java41.vo.Member" %>
<%@page import="net.bitacademy.java41.vo.Project"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <jsp:useBean id="member" class="net.bitacademy.java41.vo.Member" scope="session"></jsp:useBean>
<!DOCTYPE html>
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
<h1>프로젝트 수정</h1>
<form action="update" method="post">
번호: ${project.no}<br>
프로젝트명: <input type="text" name="title" value="${project.title}"><br>
내용:<br> 
<textarea name="content" rows="4" cols="50"></textarea><br>
시작일: <input type="date" name="startDate" value="${project.startDate}"><br>
종료일: <input type="date" name="endDate" value="${project.endDate}"><br>
태그: <input type="text" name="tag" value="${project.tag}" placeholder="예)태그1 태그2 태그3 (공백으로 구분)"><br><br>
<input type="submit" value="변경">
<a href="list"><input type="button" value="목록"></a><br><br>
</form>
</div>


<jsp:include page="/tail.jsp"></jsp:include>
</body>
</html>