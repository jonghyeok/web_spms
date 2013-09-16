<%@page import="net.bitacademy.java41.vo.Project"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>멤버 등록</title>
<link rel="stylesheet" href="${rootPath}/css/style.css">
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>

<jsp:include page="/sidebar.jsp"></jsp:include>

<div class="content">
<h1>멤버 정보 수정</h1>
<form action="update2.do" method="post">
*이메일: <input type="text" name="email" value="${memberInfo.email}" readonly><br>
*이름: <input type="text" name="name" value="${memberInfo.name}" required><br>
*전화: <input type="text" name="tel" value="${memberInfo.tel}"><br>
블로그: <input type="text" name="blog" value="${memberInfo.blog}"><br>
우편번호: <input type="text" name="postno" value=" "><input type="button" value="우편번호찾기"><br>
상세주소: <input type="text" name="detailAddress" value="${memberInfo.detailAddress}"><br>
태그: <input type="text" name="tag" value="${memberInfo.tag}"><br>
권한: <select name="level">
<option value="0" <c:if test="${member.level}=0">selected</c:if>>일반회원</option>
<option value="1" <c:if test="${member.level}=1">selected</c:if>>관리자</option>
<option value="2" <c:if test="${member.level}=2">selected</c:if>>PM</option>
<option value="9" <c:if test="${member.level}=9">selected</c:if>>손님</option>
</select><br>

<input type="submit" value="변경">
<input type="reset" value="취소">
</form>
<p><a href="list.do">[목록]</a></p>
</div>

<jsp:include page="/tail.jsp"></jsp:include>

</body>
</html>

