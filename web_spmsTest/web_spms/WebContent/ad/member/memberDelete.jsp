<%@page import="net.bitacademy.java41.vo.Member" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <jsp:useBean id="member" class="net.bitacademy.java41.vo.Member" scope="session"></jsp:useBean>
<!DOCTYPE html">
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
<h1>멤버 삭제</h1>
<form action="delete" method="post">
정말 삭제하시겠습니까?<br><br>
<a href="list"><input type="submit" value="확인"></a>
<a href="list"><input type="button" value="이전"></a>
</form>


</div>


<jsp:include page="/tail.jsp"></jsp:include>
</body>
</html>