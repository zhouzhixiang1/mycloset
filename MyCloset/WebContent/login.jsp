<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login</title>
</head>
<body>
	<aside class="menu">
		<div class="menu-content">
			<i class="fa fa-unlock-alt"></i><a href="#" id="login">login</a> | <i
				class="fa fa-user"></i><a href="register.jsp">Register</a>
		</div>
		<div class="arrow-up"></div>
	</aside>
	<div class="login-form">
		<form method="post" action="LoginCheck"><!-- LoginRegister -->
			<label>Username</label>
			<div>
				<input type="text" name="uname" placeholder="" required /> <!-- name -->
			</div>
			<label>Password</label>
			<div>
				<input type="password" name="password" placeholder="" required />
			</div>
			<div>
				<input type="submit" name="submit"value="Log In" /><!-- login -->
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