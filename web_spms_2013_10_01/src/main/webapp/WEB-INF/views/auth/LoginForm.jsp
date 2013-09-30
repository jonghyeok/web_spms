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
<link  href="http://fonts.googleapis.com/css?family=Reenie+Beanie:regular" rel="stylesheet" type="text/css"> 

<title>SPMS - Login</title>
</head>
<!-- zzzzzzzzzzzzzzzz 메모 스크립트 시작 -->
<style type="text/css">
*{
  margin:0;
  padding:0;
}
h2,p{
  font-size:100%;
  font-weight:normal;
}
ul,li{
  list-style:none;
}
ul{
  overflow:hidden;
  padding:3em;
}
ul li a{
  text-decoration:none;
  color:#000;
  background:#ffc;
  display:block;
  height:10em;
  width:10em;
  padding:1em;
  -moz-box-shadow:5px 5px 7px rgba(33,33,33,1);
  -webkit-box-shadow: 5px 5px 7px rgba(33,33,33,.7);
  box-shadow: 5px 5px 7px rgba(33,33,33,.7);
  -moz-transition:-moz-transform .15s linear;
  -o-transition:-o-transform .15s linear;
  -webkit-transition:-webkit-transform .15s linear;
}
ul li{
  margin:1em;
  float:left;
}
ul li h2{
  font-size:140%;
  font-weight:bold;
  padding-bottom:10px;
}
ul li p{
  font-family:"Reenie Beanie",arial,sans-serif;
  font-size:180%;
}
ul li a{
  -webkit-transform: rotate(-6deg);
  -o-transform: rotate(-6deg);
  -moz-transform:rotate(-6deg);
}
ul li:nth-child(even) a{
  -o-transform:rotate(4deg);
  -webkit-transform:rotate(4deg);
  -moz-transform:rotate(4deg);
  position:relative;
  top:5px;
  background:#cfc;
}
ul li:nth-child(3n) a{
  -o-transform:rotate(-3deg);
  -webkit-transform:rotate(-3deg);
  -moz-transform:rotate(-3deg);
  position:relative;
  top:-5px;
  background:#ccf;
}
ul li:nth-child(5n) a{
  -o-transform:rotate(5deg);
  -webkit-transform:rotate(5deg);
  -moz-transform:rotate(5deg);
  position:relative;
  top:-10px;
}
ul li a:hover,ul li a:focus{
  box-shadow:10px 10px 7px rgba(0,0,0,.7);
  -moz-box-shadow:10px 10px 7px rgba(0,0,0,.7);
  -webkit-box-shadow: 10px 10px 7px rgba(0,0,0,.7);
  -webkit-transform: scale(1.25);
  -moz-transform: scale(1.25);
  -o-transform: scale(1.25);
  position:relative;
  z-index:5;
}
ol{text-align:center;}
ol li{display:inline;padding-right:1em;}
ol li a{color:#fff;}
</style>

<!-- zzzzzzzzzzzzzzzz 메모 스크립트 종료 -->




<!--   ddddddddddddddddddd드래그 스크립트 시작ddddddddddddddddd -->
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
<!-- dddddddddddddddddd드래그 스크립트 종료dddddddddddddd -->
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

<div class="drag">
 <ul>
    <li>
      <a href="loginForm.do"  class="drag">
        <h2>Team Info</h2>
        <p>TeamName : 2Team</p><br>
      </a>
    </li>
    <li>
      <a href="loginForm.do"  class="drag">
        <h2>Group</h2>
        <p>Jonghyeok,Seonjin,</p><p>Jinse,Jehwan,Jaeu</p>
        <p>Bitacademy Java41</p><br>
      </a>
    </li>
    
    <li>
      <a href="loginForm.do"  class="drag">
        <h2>Update Info</h2>
        <p>Last Update : 2013/10/01</p>
        <p>Update : Spring,session</p>
      </a>
    </li>
  </ul>
</div>




</body>



</html>
