<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login form</title>
</head>
<body>
	<h1>${message}</h1>
	<form action="loginServlet" method="post">
		<label for="email">email : </label> <input name="email"> 
		<br> 
		<label for="password">password : </label> <input name="password"> 
		<br> 
		<input type="submit" value="submit">
		
	</form>
</body>
</html>