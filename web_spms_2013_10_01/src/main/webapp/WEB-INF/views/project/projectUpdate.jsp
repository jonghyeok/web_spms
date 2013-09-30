<%@page import="net.bitacademy.java41.vo.Project"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로젝트 등록</title>
<link rel="stylesheet" type="text/css" href="${rootPath}/css/style.css">
</head>
<body>

<jsp:include page="/header.do"></jsp:include>
<jsp:include page="/sidebar.do"></jsp:include>

<div class="content">

<h1>프로젝트 수정</h1>
<form action="update.do" method="post">
프로젝트 번호: ${project.no}<input type="hidden" name="no" value="${project.no}"><br>
프로젝트명: <input type="text" name="title" value="${project.title }" required><br>
내용:<br><textarea name="content" rows="4" cols="50">${project.content }</textarea><br>
시작일: <input type="date" name="startDate" value="${project.startDate }" required><br>
종료일: <input type="date" name="endDate" value="${project.endDate }"required><br>
태그: <input type="text" name="tag" value="${project.tag }"><br><br>
<input type="submit" value="변경">
<a href="list.do"><input type="button" value="목록"></a><br><br>
</form>

</div>

<jsp:include page="/tail.do"></jsp:include>

</body>
</html>

