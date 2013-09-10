<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div id="header">
<a id="" href="<%=application.getContextPath()%>/main"><img alt="SPMS Logo" src="<%=application.getContextPath()%>/images/mainLogo.png" id="mainlogo"> </a>

<div id='cssmenu'>
<ul>
   <li class='active'><a href="<%=application.getContextPath()%>/main"><span>메뉴1</span></a></li>
   <li><a href="<%=application.getContextPath()%>/main"><span>메뉴2</span></a></li>
   <li><a href="<%=application.getContextPath()%>/main"><span>메뉴3</span></a></li>
    <li><a href="<%=application.getContextPath()%>/main"><span>메뉴4</span></a></li>
    <li><a href="<%=application.getContextPath()%>/main"><span>메뉴5</span></a></li>
   <li class='last'><a href="<%=application.getContextPath() %>/auth/logout"><span>LogOut!</span></a></li>
</ul>
</div>
</div>
