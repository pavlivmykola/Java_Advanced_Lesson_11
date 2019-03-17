<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>${message}</h1>
	<form action="registrationServlet" method="post">
		<label for="firstName">First Name : </label> <input name="firstName">
		<br> 
		<label for="lastName">Last Name : </label> <input name="lastName"> 
		<br> 
		<label for="email">email : </label> <input name="email"> 
		<br> 
		<label for="password">password : </label> <input name="password"> 
		<br> 
		<input type="submit" value="submit" name="button">
		<input type="submit" value="login" name="button">
	</form>
</body>
</html>