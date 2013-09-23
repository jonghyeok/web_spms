<%@page import="net.bitacademy.java41.vo.Member"%>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SPMS</title>
<link rel="stylesheet" href="<%=application.getContextPath()%>/style.css">
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>

<jsp:include page="/sidebar.jsp"></jsp:include>

<div id="content">
<h1>가입회원 상세보기</h1>
<jsp:useBean id="smember" scope="request" type="net.bitacademy.java41.vo.Member"/>  
<table>
<tr>
	<th>이름</th>	<th><%=smember.getName()%></th>
</tr>

<tr>
	<th>이메일</th>	<th><%=smember.getEmail()%></th>
</tr>

<tr>
	<th>전화</th>	<th><%=smember.getTel()%></th>
</tr>

<tr>
	<th>블로그</th>	<th>${smember.blog}</th>
</tr>


<tr>
	<th>가입일</th><th>${smember.regDate}</th>
</tr>

<tr>
	<th>상세주소</th><th>${smember.detailAddress}</th>
</tr>


<tr>	
	<th>태그</th><th>${smember.tag}</th>
</tr>
	

<tr>	
	<th>등급</th><th><%if(smember.getLevel()==0){%>학생<%}
	 else if(smember.getLevel()==1){%>관리자<%}
	 else if(smember.getLevel()==2){%>PM강사<%}
	 else{%>X<%}%></th>
</tr>
	

</table>
<br>
<br>

<a href="passwordChange?email=${smember.email}">[암호변경]</a>
<a href="<%=application.getContextPath()%>/ad/member/updateMyInfo?email=${smember.email}">[정보 수정]</a>
<a href="<%=application.getContextPath()%>/ad/member/delete?email=${smember.email}">[회원 삭제]</a>
<a href="<%=application.getContextPath()%>/ad/member/list">[목록으로 돌아가기!]</a>
</div>
<jsp:include page="/tail.jsp"></jsp:include>

</body>
</html>









