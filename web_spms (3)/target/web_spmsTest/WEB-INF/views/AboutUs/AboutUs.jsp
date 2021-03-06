<%@page import="net.bitacademy.java41.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="member" class="net.bitacademy.java41.vo.Member" scope="session"></jsp:useBean>    
<!DOCTYPE>
<html>
<head>
<!-- zzzzzzzzzzzzzzzz 메모 스크립트 시작 -->
<style type="text/css">
*{
  margin:0;
  padding:0;
}
h2,p{
  font-size:105%;
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
  font-size:90%;
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


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SPMS</title>
<link rel="stylesheet" href="${rootPath}/css/style.css">
</head>
<body>
<jsp:include page="/header.do"></jsp:include>

<jsp:include page="/sidebar.do"></jsp:include>

<div class="content">

<h1 style="font-size: 300%"> About Us</h1>

 <ul>
    <li>
      <a href="#">
        <h2>팀 정보</h2>
        <p>팀 이름 : 2팀</p>
        <p>팀 소속 : 비트아카데미 Java고급과정 41기</p>
      </a>
    </li>
    <li>
      <a href="#">
        <h2>Group</h2>
        <p>장종혁,정선진,</p><p>이진세,임재완,송제우</p>
      </a>
    </li>
    
    <li>
      <a href="#">
        <h2>업데이트 정보</h2>
        <p>최근 수정일 : 2013/09/29</p>
        <p>수정내용 : UI,Memo추가</p>
      </a>
    </li>
    
    <li>
      <a href="#">
        <h2>계획?..</h2>
        <p>월화수목월월월</p>
        <p>OTL....</p>
      </a>
    </li>
    
    
    
  </ul>





</div>

<jsp:include page="/tail.do"></jsp:include>
</body>
</html>













