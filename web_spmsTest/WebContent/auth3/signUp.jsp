<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SPMS_SignUp!</title>
</head>
<style type="text/css">
#signup {
	width: 450px;
	height: 530px;
	margin: 100px auto 50px auto;
	padding: 20px;
	position: relative;
	background: #fff
		url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAMAAAAECAMAAAB883U1AAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAAlQTFRF7+/v7u7u////REBVnAAAAAN0Uk5T//8A18oNQQAAABZJREFUeNpiYGJiYmBiYgRiBhAGCDAAALsAFJhiJ+UAAAAASUVORK5CYII=);
	border: 1px solid #ccc;
	border-radius: 3px;
}

#signup::before,#signup::after {
	content: "";
	position: absolute;
	bottom: -3px;
	left: 2px;
	right: 2px;
	top: 0;
	z-index: -1;
	background: #fff;
	border: 1px solid #ccc;
}

#signup::after {
	left: 4px;
	right: 4px;
	bottom: -5px;
	z-index: -2;
	box-shadow: 0 8px 8px -5px rgba(0, 0, 0, .3);
}

::-webkit-input-placeholder {
	color: #bbb;
}

:-moz-placeholder {
	color: #bbb;
}

.placeholder {
	color: #bbb;
}

#signup input {
	margin: 5px 0;
	padding: 1px;
	width: 100%;
	*width: 518px;
	box-sizing: border-box;
	border: 1px solid #ccc;
	border-radius: 3px;
}

#signup input:focus {
	outline: 0;
	border-color: #aaa;
	box-shadow: 0 2px 1px rgba(0, 0, 0, .3) inset;
}

#signup button {
	margin: 20px 0 0 0;
	padding: 15px 8px;
	width: 100%;
	cursor: pointer;
	border: 1px solid #2493FF;
	overflow: visible;
	display: inline-block;
	color: #fff;
	font: bold 1.4em arial, helvetica;
	text-shadow: 0 -1px 0 rgba(0, 0, 0, .4);
	background-color: #6A5ACD;
	background-image: linear-gradient(top, rgba(255, 255, 255, .5),
		rgba(255, 255, 255, 0) );
	transition: background-color .2s ease-out;
	border-radius: 3px;
	box-shadow: 0 2px 1px rgba(0, 0, 0, .3), 0 1px 0 rgba(255, 255, 255, .5)
		inset;
}

#signup button:hover {
	background-color: #7cbfff;
	border-color: #7cbfff;
}

#signup button:active {
	position: relative;
	top: 3px;
	text-shadow: none;
	box-shadow: 0 1px 0 rgba(255, 255, 255, .3) inset;
}

#logo {
	position: relative;
	top: 3px;
	text-shadow: none;
	box-shadow: 0 1px 0 rgba(255, 255, 255, .3) inset;
}
background-color
:
 
#7cbfff
;
</style>
<body bgcolor=C8BFE7>
	<div id=logo>
		<img src='logo.png' />
	</div>
	<div>
		<form id="signup" action="signup" method="post">
			<p>*는 필수 입력값 입니다.(E-mail, Password, Name)</p>
			<input type='text' name='email' placeholder='* E-mail' required>
			<input type='password' name='password' placeholder='* Password'	required> 
			<input type='text' name='name' placeholder='* Name' required>
			 <input type="text" name="tel" placeholder="*PhoneNumber" required>
			 <input type="text" name="blog" placeholder="Blog URL">
			  <input type="text" name="detailAddress" placeholder="Address">
			<button type="submit">SignUp!</button>
			<button type="reset">Cancle!</button>
			
		</form>
	</div>
</body>
</html>
