<%@page import="net.bitacademy.java41.vo.MemberProject"%>
<%@page import="net.bitacademy.java41.vo.Member"%>
<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="member" 
	scope="session" 
	type="net.bitacademy.java41.vo.Member"/>    
<div id="sidebar">
<div id="member">
<img id="memberPhoto" src="<%=application.getContextPath()%>/images/test02.png">
<div id="memberInfo">
<p id="name"><%=member.getName()%></p>
<p id="tel"><%=member.getTel()%></p>
<p id="email"><%=member.getEmail()%></p>
</div>
</div>
<jsp:useBean id="myprojects" 
	scope="session" 
	type="java.util.List<net.bitacademy.java41.vo.MemberProject>"></jsp:useBean>
	
<%if(0==member.getLevel()){ %>
<h3>프로젝트들 <a href="<%=application.getContextPath()%>/project/list">[전체]</a></h3>
<ul>
<%for(MemberProject project : myprojects) { %>
	<li><a href="<%=application.getContextPath()%>/project/view?no=<%=project.getNo()%>"
	><%=project.getTitle()%><%=(project.getLevel() == 0) ? "(PL)" : ""%></a></li>
<%}%>
</ul>
<%}else if(1==member.getLevel()){ %>

<h3>[관리메뉴]</a></h3>
<ul>
	<li><a href="<%=application.getContextPath()%>/ad/member/list">회원관리</a></li>
	<li>프로젝트 관리</li>
</ul>
<%} %>
</div>







