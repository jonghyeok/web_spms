<!-- This Login Page Was Designed By Aafrin.com (http://www.aafrin.com) -->
<!DOCTYPE html">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" >
<meta http-equiv="imagetoolbar" content="no" >
<meta name="MSSmartTagsPreventParsing" content="true" >
<meta name="description" content="Description" >
<meta name="keywords" content="Keywords" >
<meta name="author" content="Aafrin - Twinz" >

<style type="text/css" media="all">@import "style.css";</style>

<title>SPMS - Login</title>
</head>
<!--   dddddddddddddddddddddddddddddddddddddddddddd -->
<style>
.drag { position: relative; cursor:move }
</style>
<script language="JavaScript">
<!--
var bdown = false;
var x, y;
var sElem;

function mdown() {
 if(event.srcElement.className == "drag") {
  bdown = true;
  sElem = event.srcElement;
  x = event.clientX;
  y = event.clientY;
 }
}
function mup() {
 bdown = false;
}
function moveimg() {
 if(bdown) {
  var distX = event.clientX - x;
  var distY = event.clientY - y;
  sElem.style.pixelLeft += distX;
  sElem.style.pixelTop += distY;
  x = event.clientX;
  y = event.clientY;
 return false;
 }
}
document.onmousedown = mdown;
document.onmouseup = mup;
document.onmousemove = moveimg;
//-->
</script>
<!-- dddddddddddddddddddddddddddddddddddddddddddd -->
<body>

<div id="login" style="cursor:hand";  class="drag">
<img class="logo" alt="" src="images/logo.png" width="192" height="97" >


<form action='login.do' method="post"> 
<p class="user">Username :</p>
<input class="userbox" type="text" name="email"
	<c:if test="${email != ''}">value='${email}'</c:if>
	placeholder="hong@test.com" >
<p class="pass">Password :</p>
<input class="userbox" type="password" name="password" placeholder="password"><br>
<input type="checkbox" name="saveId"
	<c:if test="${isSaveId}">checked</c:if>> 
<a href="default.htm">
<input type="submit" class="btnLogin" value=""></a>

<div id="links">
<a href="../member/signup.do">Register</a> | <a href="default.htm">Forgot Password</a>
</div>

<!--
If you need a copyright enable this. I havent write the css for it. (Aafrin)

<p class="cRight"> :copy Company Name - 2010</p>
-->
</div>



</body>



</html>
