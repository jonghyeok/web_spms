<%@page import="net.bitacademy.java41.vo.Project"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Refresh" content="2;url=list.do?no=${pno}">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>테스크 추가 결과</title>
<link rel="stylesheet" href="${rootPath}/css/style.css">
</head>
<body>
<jsp:include page="/header.do"></jsp:include>

<jsp:include page="/sidebar.do"></jsp:include>

<div class="content">
<c:choose>
<c:when test="${status == 'FAIL'}">테스크 저장에 오류가 발생하였습니다.</c:when>
<c:when test="${status == 'SUCCESS'}">테스크가 저장되었습니다.</c:when>
<c:when test="${status == 'NoSign'}">프로젝트에 가입되지않으면 테스크를 추가할수없습니다.</c:when>
<c:otherwise>손님</c:otherwise>
</c:choose><br>
</div>

<jsp:include page="/tail.do"></jsp:include>

</body>
</html>









