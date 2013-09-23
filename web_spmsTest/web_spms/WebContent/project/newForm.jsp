<%@page import="net.bitacademy.java41.vo.Member" %>
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
<h1>신규 프로젝트</h1>
<form action="add" method="post">
프로젝트명: <input type="text" name="title" required><br>
내용:<br> 
<textarea name="content" rows="4" cols="50"></textarea><br>
시작일: <input type="date" name="startDate" placeholder="예)2013-4-5" required><br>
종료일: <input type="date" name="endDate" placeholder="예)2013-6-5" required><br>
태그: <input type="text" name="tag" placeholder="예)태그1 태그2 태그3 (공백으로 구분)"><br>
<input type="submit" value="등록"><input type="reset" value="취소"><br>
</form>
<p><a href="list">[목록]</a></p>
</div>


<jsp:include page="/tail.jsp"></jsp:include>
</body>
</html>