<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<title>Java 41 SPMS</title>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<meta name="author" content="fatma.hassan@gmail.com" />
<meta name="description" content="FTM" />

<link rel="stylesheet" href="${rootPath}/css/style.css">
</head>
<body>
	<!-- Generated at www.csscreator.com -->

	<jsp:include page="/header.jsp"></jsp:include>

	<jsp:include page="/sidebar.do"></jsp:include>
<div class="content">
<h1>멤버 변경</h1>
<form action="updateMyInfo.do" method="post" enctype="multipart/form-data">
*이메일: <input type="text" name="email" value="${member.email}" readonly><br>
*암호: <input type="password" name="password"><a href="passwordChange.do?email=${member.email}">[암호변경]</a><br>
<input type="hidden" name="serverpwd" value="${member.password}">
*이름: <input type="text" name="name" value="${member.name}"><br>
*전화: <input type="text" name="tel" value="${member.tel}"><br>
<c:choose>
	<c:when test="${member.photos != null}">
		<img src="${rootPath}/file/${member.photos[0]}" height="200"><br>
	</c:when>
	<c:otherwise>
		<img src="${rootPath}/images/test01.png"><br>
	</c:otherwise>
</c:choose><br>
사진: <input type="file" name="photo"><br>

블로그: <input type="text" name="blog" value="${member.blog}"><br>
우편번호: <input type="text" name="postno">
		<input type="button" value="우편번호찾기"><br>
기본주소: <input type="text" name="basicAddr" ><br>
상세주소: <input type="text" name="detailAddr" value="${member.detailAddress}"><br>
태그: <input type="text" name="tag" value="${member.tag}"><br>
<input type="hidden" name="level" value="${member.level}">
권한: <c:choose>
<c:when test="${member.level == 0}">일반회원</c:when>
<c:when test="${member.level == 1}">관리자</c:when>
<c:when test="${member.level == 2}">PM</c:when>
<c:when test="${member.level == 9}">손님</c:when>
</c:choose><br>

<input type="submit" value="등록">
<input type="reset" value="취소">
</form>




	</div><!-- end content -->
		
	<jsp:include page="/tail.jsp"></jsp:include>
</body>
</html>




