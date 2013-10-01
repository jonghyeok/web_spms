<%@page import="net.bitacademy.java41.vo.MemberProject"%>
<%@page import="net.bitacademy.java41.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="member" type="net.bitacademy.java41.vo.Member" scope="session"/>
<jsp:useBean id="projectService" type="net.bitacademy.java41.services.ProjectService" scope="application"/>  
<% pageContext.setAttribute("myprojects", projectService.getMyProjects(member.getEmail()));%>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<div class="main_nav">
<img id="memberPhoto" src="${rootPath}/images/test01.png">
<div id="memberInfo">
<p id="name"><a href="${rootPath}/member/updateMyInfoForm.do?email=${member.email }">${member.name}</a></p>
<p id="tel">${member.tel }</p>
<p id="email">${member.email }</p>
</div>

<c:choose>
<c:when test="${member.level == 0}">
	<div class="sub_menu">
		<div>프로젝트들</div>
		<a href="${rootPath}/project/list">[전체]</a> 
		
		<c:forEach var="project" items="${myprojects}">
		<a href="${rootPath}/project/view.do?no=${project.no}">${project.title}
	<c:if test="${project.level == 0}">(PL)</c:if></a></c:forEach>
	</div>

</c:when>
<c:when test="${member.level == 1}">
	<div class="sub_menu">
		<div>관리</div>
		<a href="${rootPath}/member/list.do">멤버관리</a>
		<a href="${rootPath}/project/list.do">프로젝트관리</a>
		<a href=""><li>test</li></a>
		<a href=""><li>test</li></a>
	</div>
	</c:when>
</c:choose>
<!-- 	<div class="sub_menu"> -->
<!-- 		<div>메뉴샘플</div> -->
<!-- 		<a href="#">Home</a>  -->
<!-- 		<a href="#">About Us</a>  -->
<!-- 		<a href="#">News</a>  -->
<!-- 		<a href="#">Contact</a>  -->
<!-- 		<a href="#">Links</a> -->
<!-- 	</div> -->
</div>






