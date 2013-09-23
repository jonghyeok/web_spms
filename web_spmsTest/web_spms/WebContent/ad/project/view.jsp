<%@page import="net.bitacademy.java41.vo.Project"%>
<%@page import="net.bitacademy.java41.vo.ProjectMember" %>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로젝트 정보</title>
<link rel="stylesheet" href="<%=application.getContextPath()%>/style.css">
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>

<jsp:include page="/sidebar.jsp"></jsp:include>

<div id="content">
<h1>프로젝트 정보</h1>
<jsp:useBean id="project" 
		scope="request" 
		type="net.bitacademy.java41.vo.Project"></jsp:useBean>
번호: <%=project.getNo() %><br>
프로젝트명: <%=project.getTitle() %><br>
내용:<br> 
<%=project.getContent() %><br>
시작일: <%=project.getStartDate() %><br>
종료일: <%=project.getEndDate() %><br>
태그: <%=project.getTag() %><br>

<div>
<h3>참여 프로젝트 맴버 정보</h3>
<table>
<tr>
<td>이름</td> <td>이메일</td> <td>전화</td> <td>블로그</td> <td>PL</td>
</tr>
<tr>
<hr/>
</tr>

<jsp:useBean id="mpview" scope="request" type="java.util.ArrayList<net.bitacademy.java41.vo.ProjectMember>"/>
	
<%for(ProjectMember pm : mpview){ %>
<tr>
<td><%=pm.getName()%></td><td><%=pm.getEmail() %></td>
<td><%=pm.getTel()%></td><td><%=pm.getBlog()%></td>
<td><%=(pm.getLevel() == 0) ? "(PL)" : "" %></td>
</tr>
<%} %>
</table>
</div>

<a href="update?no=${project.no }">[프로젝트 수정]</a>
<a href="delete?no=${project.no }">[프로젝트 삭제]</a>

</div>

<jsp:include page="/tail.jsp"></jsp:include>

</body>
</html>