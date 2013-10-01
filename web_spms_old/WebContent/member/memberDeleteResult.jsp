<%@page import="net.bitacademy.java41.vo.Project"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Refresh" content="1;url=list.do">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>멤버 정보 변경</title>
<link rel="stylesheet" href="${rootPath}/css/style.css">
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>

<jsp:include page="/sidebar.jsp"></jsp:include>

<div class="content">
<c:choose>
<c:when test="${status == 'FAIL'}">삭제 오류</c:when>
<c:when test="${status == 'SUCCESS'}">삭제완료</c:when>
</c:choose><br>
</div>

<jsp:include page="/tail.jsp"></jsp:include>

</body>
</html>









