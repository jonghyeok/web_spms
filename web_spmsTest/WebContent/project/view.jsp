<%@page import="net.bitacademy.java41.vo.Project"%>
<%@page import="net.bitacademy.java41.vo.ProjectMember" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로젝트 정보</title>
<link rel="stylesheet" href="${rootPath}/css/style.css">
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>

<jsp:include page="/sidebar.jsp"></jsp:include>

<div class="content">
<div id="submenu">
<p>
<a href="view.do?no=${project.no}">[기본정보]</a> |
<a href="../task/list.do?projectNo=${project.no}">[작업들]</a> |
<a href="../feed/list.do?projectNo=${project.no}">[게시판]</a>
</div>
<h1>프로젝트 정보</h1>
번호: ${project.no}<br>
프로젝트명: ${project.title }<br>
내용:<br> 
${project.content }<br>
시작일: ${project.startDate }<br>
종료일: ${project.endDate }<br>
태그: ${project.tag }<br>

<h1>참여 프로젝트 맴버 정보</h1>
<table>
<tr>
<td>이름</td> <td>이메일</td> <td>전화</td> <td>블로그</td> <td>PL</td>
</tr>

<tr>
</tr>

<jsp:useBean id="mpview" scope="request" type="java.util.ArrayList<net.bitacademy.java41.vo.ProjectMember>"/>
	
<%for(ProjectMember pm : mpview){ %>
<tr>
<td><%=pm.getName()%></td>
<td><%=pm.getEmail() %></td>
<td><%=pm.getTel()%></td>
<td><%=pm.getBlog()%></td>
<td><%=(pm.getLevel() == 0) ? "(PL)" : "" %></td>
</tr>
<%} %>
</table>

<p>
<a href="list.do">[목록]</a>
<a href="update.do?no=${project.no}">[변경]</a>
<a href="delete.do?no=${project.no}">[삭제]</a>
</p>
</div>

<jsp:include page="/tail.jsp"></jsp:include>

</body>
</html>









