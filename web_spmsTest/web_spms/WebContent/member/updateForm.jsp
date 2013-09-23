<%@page import="net.bitacademy.java41.vo.Member" %>
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
<h1>개인정보 변경</h1>
<form action="updateMyInfo" method="post">
이메일: <input type="text" name="email" value="${member.email}" readonly><br>
암호: <input type="password" name="password"> <a href="<%=application.getContextPath()%>/member/passwordChange?email=${member.email}">암호 변경</a><br>
이름: <input type="text" name="name" value="${member.name }"><br>
전화: <input type="text" name="tel" value="${member.tel }"><br>
블로그: <input type="text" name="blog" value="${member.blog }"><br>
우편번호: <input type="text" name="postno">
		<input type="button" value="우편번호찾기"><br>
기본주소: <input type="text" name="basicAddr" value="${member.postNo }"><br>
상세주소: <input type="text" name="detailAddr" value="${member.detailAddress }"><br>
태그: <input type="text" name="tag" value="${member.tag }"><br>
<input type="submit" value="등록">
<input type="reset" value="초기화">
</form>

</div>

<jsp:include page="/tail.jsp"></jsp:include>
</body>
</html>