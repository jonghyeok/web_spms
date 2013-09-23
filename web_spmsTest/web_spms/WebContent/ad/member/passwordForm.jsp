<%@page import="net.bitacademy.java41.vo.Member" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <jsp:useBean id="member" class="net.bitacademy.java41.vo.Member" scope="session"></jsp:useBean>
<!DOCTYPE html PUBLIC">
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
<h1>암호변경</h1>
<form action="passwordChange" method="post">
이메일: <input type="text" name="email" value="${param.email}" readonly><br>
이전 암호: <input type="password" name="password" value="****"><br>
새 암호: <input type="password" name="newPassword"><br>
새 암호 확인: <input type="password" name="newPassword2"><br>
<input type="submit" value="변경">

</form>
<p>
<a href="view?email=${param.email}">[이전]</a>
<a href="list">[목록]</a></p>
</div>


<jsp:include page="/tail.jsp"></jsp:include>
</body>
</html>