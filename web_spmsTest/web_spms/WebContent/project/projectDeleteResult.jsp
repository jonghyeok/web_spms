<%@page import="net.bitacademy.java41.vo.Project" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <jsp:useBean id="member" class="net.bitacademy.java41.vo.Member" scope="session"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Refresh" content="2;url=list">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=application.getContextPath()%>/style.css" rel="stylesheet"/>

<title>SPMS</title>
</head>
<body>

<jsp:include page="/header.jsp"></jsp:include>
<jsp:include page="/sidebar.jsp"></jsp:include>

<div id="content">
<c:choose>
<c:when test="${status == 'FAIL'}">프로젝트 삭제에 실패하였습니다.</c:when>
<c:when test="${status == 'SUCCESS'}">프로젝트가 정상적으로 삭제 되었습니다.</c:when>
<c:otherwise>손님</c:otherwise>
</c:choose><br>
</div>

<jsp:include page="/tail.jsp"></jsp:include>
</body>
</html>