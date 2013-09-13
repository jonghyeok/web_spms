<%@page import="net.bitacademy.java41.vo.Project"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로젝트 삭제</title>
<link rel="stylesheet" href="${rootPath}/css/style.css">
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>

<jsp:include page="/sidebar.jsp"></jsp:include>

<div class="content">
<h1>프로젝트 삭제</h1>
<form action="delete.do" method="post">
정말 삭제하시겠습니까?<br><br>
<a href="list"><input type="submit" value="확인"></a>
<a href="list"><input type="button" value="취소"></a>
</form>


</div>

<jsp:include page="/tail.jsp"></jsp:include>

</body>
</html>

