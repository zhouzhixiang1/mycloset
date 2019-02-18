<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style>
.search-box {
	position: absolute;
	top: 15%;
	left: 5%;
	background: white;
	border-radius: 40px;
	padding: 2px;
}

.search-box:hover>.search-txt {
	width: 200px;
	padding: 0 6px;
}

.search-box:hover>.search-btn {
	background: white;
}

.search-btn {
	color: #e84118;
	float: right;
	width: 40px;
	height: 40px;
	border-radius: 50%;
	background: black;
	display: flex;
	justify-content: center;
	align-items: center;
	transition: 0.4s;
}

.search-txt {
	border: none;
	background: none;
	outline: none;
	float: right;
	padding: 0;
	color: black;
	font-size: 16px;
	transition: 0.4s;
	line-height: 40px;
	width: 0px;
}
</style>
</head>
<body>
	<aside class="menu">
		<div class="menu-content">
			<i class="fa fa-unlock-alt"></i><a href="#" id="login">login</a> | <i
				class="fa fa-user"></i><a href="registration.html">Register</a>
		</div>
		<div class="arrow-up"></div>
	</aside>
	<div class="login-form">
		<form>
			<label>Username</label>
			<div>
				<input type="text" placeholder="" required />
			</div>
			<label>Password</label>
			<div>
				<input type="password" placeholder="" required />
			</div>
			<div>
				<input type="submit" value="Log In" />
			</div>
			<div>
				<a href="psw-recovery.html"
					style="text-decoration: none; position: relative; top: 20px; font-size: 16px; color: gray;">Lost
					your password?</a>
			</div>
		</form>
	</div>
</body>
</html>