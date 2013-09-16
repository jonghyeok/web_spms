<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
    request.setCharacterEncoding("euc-kr");
    String name         = request.getParameter("name");
    String fileName     = request.getParameter("filename");
    String origFileName = request.getParameter("origfilename");
%>
<html>
<head>
<title>파일 업로드 확인</title>
</head>
<body>
fileName : <%=fileName %><BR>
origFileName : <%=origFileName %>
NAME : <%=name %>
FILE NAME : <a href="upload/<%=fileName %>"><%=origFileName %></a><br>
</body>
</html>