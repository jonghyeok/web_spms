<%@ page import="net.bitacademy.java41.vo.Member" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="member" class="net.bitacademy.java41.vo.Member" scope="session"></jsp:useBean>
<!DOCTYPE html">
<html>
<head>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=application.getContextPath()%>/style.css" rel="stylesheet"/>

<title>SPMS</title>
</head>
<body>

<jsp:include page="/header.jsp"></jsp:include>
<jsp:include page="/sidebar.jsp"></jsp:include>

<div class="content">
<h1>멤버 정보 수정</h1>
<form action="updateMyinfo.do" method="post">
*이메일: <input type="text" value="${umember.email}" readonly><br>
*이름: <input type="text" name="name" value="${umember.name}" required><br>
*전화: <input type="text" name="tel"  value="${umember.name}"><br>
블로그: <input type="text" name="blog" value="${umember.blog}"><br>
우편번호: <input type="text" name="postno"><input type="button" value="우편번호찾기"><br>
기본주소: <input type="text" name="basicAddr"><br>
상세주소: <input type="text" name="detailAddr"><br>
태그: <input type="text" name="tag"><br>
권한: <select name="level">
<jsp:useBean id="umember" scope="request" type="net.bitacademy.java41.vo.Member"></jsp:useBean>
<option value="0" <%if(umember.getLevel()==0)%><%="selected" %>>일반회원</option>
<option value="1" <%if(umember.getLevel()==1)%><%="selected" %> >관리자</option>
<option value="2" <%if(umember.getLevel()==2)%><%="selected" %> >PM</option>
<option value="9" <%if(umember.getLevel()==3)%><%="selected" %> >손님</option>
</select><br>



<input type="submit" value="변경">
<input type="reset" value="취소">
</form>
<p><a href="list.do">[목록]</a></p>
</div>



<jsp:include page="/tail.jsp"></jsp:include>
</body>
</html>