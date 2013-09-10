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
<jsp:useBean id="member" scope="session" type="net.bitacademy.java41.vo.Member"/>  
<table>
<tr>
	<th>이름</th>
	<th>이메일</th>
	<th>전화</th>
	<th>블로그</th>
	<th>가입일</th>
	<th>상세주소</th>
	<th>태그</th>
	<th>등급</th>
	
	
</tr>
<tr>
	<td><%=member.getName()%></td>
	<td><%=member.getEmail()%></td>
	<td><%=member.getTel()%></td>
	<td><%=member.getBlog()%></td>
	<td><%=member.getRegDate()%></td>
	<td><%=member.getDetailAddress()%></td>
	<td><%=member.getTag()%></td>
	<td><%if(member.getLevel()==0){%>학생<%}
	 else if(member.getLevel()==1){%>관리자<%}
	 else if(member.getLevel()==2){%>PM강사<%}
	 else{%>X<%}%>
	
	
</tr>	
</table>

<a href="<%=application.getContextPath()%>/ad/member/list">목록으로 돌아가기!</a>
</div>

<jsp:include page="/tail.jsp"></jsp:include>

</body>
</html>









