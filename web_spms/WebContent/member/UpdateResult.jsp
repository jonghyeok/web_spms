<%@page import="net.bitacademy.java41.vo.Project" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <jsp:useBean id="member" class="net.bitacademy.java41.vo.Member" scope="session"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Refresh" content="2;url=updateMyInfo">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=application.getContextPath()%>/css/style.css" rel="stylesheet"/>

<title>SPMS</title>
</head>
<body>

<jsp:include page="/header.jsp"></jsp:include>
<jsp:include page="/sidebar.jsp"></jsp:include>

<div class="content">
<c:choose>
<c:when test="${status == 'pwdnull'}">암호를 입력하시지 않았습니다.</c:when>
<c:when test="${status == 'longpwd'}">입력하신 암호가 맞지 않습니다.</c:when>
<c:when test="${status == 'SUCCESS'}">사용자의 정보가 변경되었습니다.</c:when>
<c:otherwise>손님</c:otherwise>
</c:choose><br>
</div>

<jsp:include page="/tail.jsp"></jsp:include>
</body>
</html>