<%@page import="net.bitacademy.java41.vo.Member" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="member" class="net.bitacademy.java41.vo.Member" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=application.getContextPath()%>/css/style.css" rel="stylesheet"/>

<title>SPMS</title>
</head>
<body>

<jsp:include page="/header.jsp"></jsp:include>
<jsp:include page="/sidebar.jsp"></jsp:include>

<div class="content">

<h1>개인정보 변경</h1>

<form action="updateMyInfo.do" method="post">
이메일: <input type="text" name="email" value="${member.email}" readonly><br>
암호: <input type="password" name="password" value="${member.password }"> <a href="<%=application.getContextPath()%>/member/passwordChange.do?email=<%=member.getEmail() %>">암호 변경</a><br>
이름: <input type="text" name="name" value="${member.name }"><br>
전화: <input type="text" name="tel" value="${member.tel }"><br>
블로그: <input type="text" name="blog" value="${member.blog }"><br>
우편번호: <input type="text" name="postno">
		<input type="button" value="우편번호찾기"><br>
상세주소: <input type="text" name="detailAddr" value="${member.detailAddress}"><br>
태그: <input type="text" name="tag" value="${member.tag }"><br>
<input type="submit" value="변경">
<input type="reset" value="초기화">
</form>

</div>

<jsp:include page="/tail.jsp"></jsp:include>
</body>
</html>