<%@page import="net.bitacademy.java41.vo.Member"%>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<h1>가입회원 목록</h1>
<div>
 <form action="<%=application.getContextPath()%>/ad/member/serch">  
	<input type="text" name="email"	placeholder="Put Member E-mail">
	<input type="submit" value='Serch'>
 </form>
 
  <form action="<%=application.getContextPath()%>/ad/member/signup">  
	<input type="submit" value='SighUp'>
 </form>
 
 
</div>
<jsp:useBean id="list" scope="request" type="java.util.List"></jsp:useBean>
<table>
<tr>
	<th>이름</th>
	<th>이메일</th>
	<th>전화</th>
	<th>등급</th>
</tr>
<%for(Member member : (List<Member>)list) {%>
<tr>
	<td><%=member.getName()%></td>
	<td><a href="<%=application.getContextPath()%>/ad/member/serch?email="+<%=member.getEmail()%>><%=member.getEmail()%></a></td>
	<td><%=member.getTel()%></td>
	<td><%if(member.getLevel()==0){%>학생<%}
	 else if(member.getLevel()==1){%>관리자<%}
	 else if(member.getLevel()==2){%>PM강사<%}
	 else{%>X<%}%>
	
	
</tr>	
<%}%>
</table>
</div>

<jsp:include page="/tail.jsp"></jsp:include>

</body>
</html>









