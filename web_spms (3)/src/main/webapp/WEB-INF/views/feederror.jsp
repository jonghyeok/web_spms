<%@page import="net.bitacademy.java41.vo.Project"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<!DOCTYPE html>
<html>
<head>
<%-- <meta http-equiv="Refresh" content="2;url=view.do?email=${param.email}"> --%>
<meta http-equiv="Refresh" content="3;url=${rootPath}/feed/list.do?pno="${pno}>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Feed 오류</title>
<link rel="stylesheet" href="${rootPath}/css/style.css">
</head>
<body>

<div class="content">
<c:choose>
<c:when test="${status == 'Error'}">해당 프로젝트의 Feed에 가입되지 않아서 추가할 수 없습니다.</c:when>
<c:when test="${status == 'OLD_PASSWORD_ERROR'}">이전 암호가 맞지 않습니다.</c:when>
<c:when test="${status == 'SUCCESS'}">암호가 변경되었습니다.</c:when>
<c:otherwise>손님</c:otherwise>
</c:choose><br>
</div>



</body>
</html>









