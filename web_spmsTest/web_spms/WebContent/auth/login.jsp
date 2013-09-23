<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<jsp:useBean id="email" type="java.lang.String" scope="request"></jsp:useBean>
<jsp:useBean id="isSaveId" type="java.lang.Boolean" scope="request"></jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset='UTF-8'>
<title>SPMS_LogIn</title>
<link rel="stylesheet" type="text/css" href="login.css" />
<link rel="stylesheet" href="site.css" media="all" />
<link rel="stylesheet" href="page.css" media="all" />
<link rel="stylesheet" href="print.css" media="print" />
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.3/jquery.min.js"></script>
<script language="javascript" type="text/javascript" src="page.js"></script>

<style>
#joinBTN {
	width: 156px;
	height: 61px;
	margin-top: 0px;
	background-image: url("join.png");
	background-repead: no-repeat;
	background-position: center center;
}
</style>

</head>
<body bgcolor=C8BFE7>
	<div id="SPMSIMG">
		<span id="SPMS-img"></span>
	</div>
	<div id="inform">
		<form action="login" method="post">
			<input type='text' name='email' 
			<%=(email != null) ? ("value='" + email + "'") : ""%>
			placeholder='E-mail'> <br>
			<input type='password' name='password' placeholder='Password'><br>
			<input type='checkbox' name='saveId' <%=isSaveId ? "checked" : ""%>
			FontSize=10> Remember Email<br>
			<p></p>
			<input type='submit' + id='liginBTN' value=' '>
			<p></p>
		</form>
		<form action="signup">
			<input type="submit" id="joinBTN" value="">
		</form>
	</div>
		
	<form action="findpwd">
		<div id="main1" class="rollup">
			<p class="rollup-trigger test1">Forgot Password?</p>
			<div id="faq">
				<div class="oi rollup">
					<p class="rollup-trigger">└>Find by email!</p>
					<dl class="hidden">
						<dt class="rollup-trigger">

		<form action="findpwd">  
			<input type="text" name="email"	placeholder="Put E-mail">
			<input type="submit" value='Find!'>
		</form>
						
		</dt>
				</div>
		
		</div>
		</dt>
		</div>
		</div>
	</form>
	</div>
</body>
</html>
