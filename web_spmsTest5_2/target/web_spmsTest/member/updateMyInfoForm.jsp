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
<table border="2">
<tr><td colspan="3"><h1>멤버 변경</h1></td></tr>
<form action="updateMyInfo.do" method="post" enctype="multipart/form-data">
<tr><td>*이메일</td><td colspan="2"><input type="text" name="email" value="${member.email}" readonly></td></tr>
<tr><td>*암호</td><td><input type="password" name="password"></td><td><a href="passwordChange.do?email=${member.email}">[암호변경]</a></td></tr>
<input type="hidden" name="serverpwd" value="${member.password}">
<tr><td>*이름</td><td colspan="2"><input type="text" name="name" value="${member.name}"></td></tr>
<tr><td>*전화</td><td colspan="2"><input type="text" name="tel" value="${member.tel}"></td></tr>
<c:choose>
	<c:when test="${member.photos != null}">
		<tr><td colspan="3"><img src="${rootPath}/file/${member.photos[0]}" height="200" width="100%"></td></tr>
	</c:when>
	<c:otherwise>
		<tr><td colspan="3"><img src="${rootPath}/images/test01.png"></td></tr>
	</c:otherwise>
</c:choose><br>
<tr><td colspan="1">사진</td><td  colspan="2"><input type="file" name="photo"></td></tr>

<tr><td>블로그</td><td colspan="2"><input type="text" name="blog" value="${member.blog}"></td></tr>
<tr><td>우편번호</td><td colspan="1"><input type="text" name="postno"></td><td><input type="button" value="우편번호찾기"></td></tr>
<tr><td>기본주소</td><td colspan="2"><input type="text" name="basicAddr" ></td></tr>
<tr><td>상세주소</td><td colspan="2"><input type="text" name="detailAddr" value="${member.detailAddress}"></td></tr>
<tr><td>태그</td><td colspan="2"><input type="text" name="tag" value="${member.tag}"></td></tr>
<input type="hidden" name="level" value="${member.level}">
<tr><td>권한:</td><td colspan="2"> <c:choose>
<c:when test="${member.level == 0}">일반회원</c:when>
<c:when test="${member.level == 1}">관리자</c:when>
<c:when test="${member.level == 2}">PM</c:when>
<c:when test="${member.level == 9}">손님</c:when>
</c:choose>
</td></tr>

<tr><td colspan="1"><input type="reset" value="초기화"></td><td colspan="1"><a href="../main.do">[돌아가기]</a></td><td colspan="1"><input type="submit" value="등록"></td></tr>
</form>

</table>




	</div><!-- end content -->
		
	<jsp:include page="/tail.jsp"></jsp:include>
</body>
</html>




