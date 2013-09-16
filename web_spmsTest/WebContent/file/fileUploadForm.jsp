<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="java.util.*" %>

<%
    String tno = request.getParameter("tno");
  	String pno = request.getParameter("pno");

%>
    
<html>
<head>
<title>FileUpload Form</title>
</head>
<body>
    <form action="fileUpload.jsp?tno=<%=tno%>&pno=<%=pno%>" method="post" enctype="multipart/form-data">
    <table border="3">
        <tr>
            <td colspan="2" align="center"><h4>파일 업로드</h4></td>
        </tr>
        <tr>
            <td>File Name : </td><td><input type="file" name="filename"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="Upload"></td>
        </tr>
    </table>
    </form>
</body>
</html>