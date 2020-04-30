<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h6>Save</h6>
	<form action="addAlien">
		<input type="text" name="aid"><br>
		<input type="text" name="aname"><br>
		<input type="text" name="tech"><br>
		<input type="submit"><br>
	</form>
	<hr>
	<h6>Search by ID</h6>
	<form action="getAlien">
		<input type="text" name="aid"><br>
		<input type="submit"><br>
	</form>
	<hr>
	<h6>Search by technology</h6>
	<form action="getAlienByTech">
		<input type="text" name="tech"><br>
		<input type="submit"><br>
	</form>
</body>
</html>