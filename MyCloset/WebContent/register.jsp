<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="login-page">
        <div class="form">
            <form class="register-form" action="loginRegister">
                <input type="text" name="username" placeholder="Nome">
                <input type="text" name="cognome"placeholder="Cognome">
                <input type="number" name="eta"placeholder="Età ">
                <input type="text" name="sesso" placeholder="Sesso">
                <input type="text" name="email" placeholder="Inserire e-mail">
                <input type="password" name="password1" placeholder="inserire password">
                <input type="password" name="password2" placeholder="confermare password">
                <button>Create</button>
                <div>
                    <p><a href="index.html?openLogin=true#secondoNav">Hai già  un account?</a></p>
                </div>
            </form>
        </div>
    </div>
    
</body>
</html>