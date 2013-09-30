<%@page import="net.bitacademy.java41.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="member" class="net.bitacademy.java41.vo.Member" scope="session"></jsp:useBean>    
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SPMS</title>
<link rel="stylesheet" href="${rootPath}/css/style.css">
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>

<jsp:include page="/sidebar.do"></jsp:include>

<div class="content">

<table border="2">
<tr><td colspan="2"><br><h1>사용자정보</h1></td></tr>
<tr><td><br>이름<br></td><td><br>${member.name }<br></td></tr>
<tr><td><br>이메일<br></td><td><br>${member.email }<br></td></tr>
<tr><td><br>전화<br></td><td><br>${member.tel }<br></td></tr>
</table>

</div>

<jsp:include page="/tail.jsp"></jsp:include>
</body>
</html>













