<%@page import="net.bitacademy.java41.vo.Project" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <jsp:useBean id="member" class="net.bitacademy.java41.vo.Member" scope="session"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
이전 암호: <input type="password" name="password"><br>
새 암호: <input type="password" name="newPassword"><br>
새 암호 확인: <input type="password" name="newPassword2"><br>
<input type="submit" value="변경">

</form>
<p>
<a href=<%=request.getHeader("REFERER")%>>[이전]</a>
<a href="<%=application.getContextPath()%>/main">[취소]</a></p>
</div>

<jsp:include page="/tail.jsp"></jsp:include>
</body>
</html>