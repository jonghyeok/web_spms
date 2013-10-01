<%@page import="net.bitacademy.java41.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="member" class="net.bitacademy.java41.vo.Member"
	scope="session"></jsp:useBean>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SPMS</title>
<link rel="stylesheet" href="${rootPath}/css/style.css">
<link rel="stylesheet" href="${rootPath}/css/page.css">
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.3/jquery.min.js"></script>
<script language="javascript" type="text/javascript"
	src="${rootPath}/js/page.js">
	
</script>
</head>
<body>
	<jsp:include page="/header.do"></jsp:include>

	<jsp:include page="/sidebar.do"></jsp:include>

	<div class="content">

		<!-- 사용자 가입부분 Bar -->
		<div id="main" class="rollup">
			<h2 class="rollup-trigger test1">Feed</h2>

			<div id="faq">
				<div class="oi rollup">
					<dl class="rollup">
						<dt class="rollup-trigger">Feed Add</dt>
						<dd class="hidden">
							<form action="add.do" method="post" enctype="multipart/form-data">
								<br>
								Project No.${pno} <input type="hidden" name="pno" value="${pno}"
									readonly> <br><br> writer ${member.name}(${member.email}) <input type="hidden"
									name="email" value="${member.email}" readonly> <br><br>
								CONTENT <br>
								<textarea rows="5" cols="30" name="content"></textarea><br>
								<input type="submit" value="Feed Add!"> <input
									type="reset" value="Reset!">

							</form>

						</dd>
					</dl>
				</div>
			</div>

		</div>
		<!-- 사용자 가입부분 Bar -->
		<br> <br>
		<hr>

		<c:forEach var="feed" items="${list}">

			<table>
				<!-- table css는 page.css 파일에 참부하겠음..  -->

				<tr>
					<td rowspan="3" width="60"><img src="${rootPath}/file/${feed.photos[0]}" width="50" height="50"></td>
					<td colspan="5">${feed.email}</td>
				</tr>
				<tr>
					<td>${feed.content}</td>
				</tr>
				<tr>
					<td colspan="2" width="65%">작성일 ${feed.regDate}</td>
					
					<c:choose>
						<c:when test="${member.email == feed.email}">
						<td>[파일첨부]</td>
							<td>[수정]</td>
							<td><a
								href="${rootPath}/feed/delete.do?fno=${feed.fno}&pno=${feed.pno}">[삭제]</a></td>
						</c:when>
						<c:when test="${member.level == 1}">
						<td>[파일첨부]</td>
							<td>[수정]</td>
							<td><a
								href="${rootPath}/feed/delete.do?fno=${feed.fno}&pno=${feed.pno}">[삭제]</a></td>
						</c:when>
						<c:when test="${member.level == 2}">
						<td>[파일첨부]</td>
							<td>[수정]</td>
							<td><a
								href="${rootPath}/feed/delete.do?fno=${feed.fno}&pno=${feed.pno}">[삭제]</a></td>
						</c:when>
						<c:otherwise>
							<td></td>
						</c:otherwise>
					</c:choose>
				</tr>


			</table>

			<hr>
		</c:forEach>





	</div>

	<jsp:include page="/tail.do"></jsp:include>
</body>
</html>













