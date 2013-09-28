<%@page import="net.bitacademy.java41.vo.Project"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Refresh" content="1;url=view.do?email=${param.email}">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>암호변경</title>
<link rel="stylesheet" href="${rootPath}/css/style.css">
</head>
<body>

<div class="content">
<c:choose>
<c:when test="${status == 'NEW_PASSWORD_ERROR'}"><h1>신규 암호가 일치하지 않습니다.</h1></c:when>
<c:when test="${status == 'OLD_PASSWORD_ERROR'}"><h1>이전 암호가 맞지 않습니다.</h1></c:when>
<c:when test="${status == 'SUCCESS'}"><h1>내정보가 변경되었습니다.</h1></c:when>
<c:when test="${status == 'ADD_FAIL'}"><h1>동일한 아이디가 있습니다.</h1></c:when>
<c:otherwise>손님</c:otherwise>
</c:choose><br>
</div>



</body>
</html>









