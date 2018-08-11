<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Thanks</title>
		<link rel="icon" type="image/png" href="Images/javalogo.gif" />
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<style type="text/css">
			body {
				background-image: url("Images/online-food.gif");
			}
		</style>
	</head>
	<body>
	    <div>   
			Thank you.
			<br />
			<a href="index.jsp">Login Again</a>
			<% session.invalidate(); %>
		</div>
	</body>
</html>