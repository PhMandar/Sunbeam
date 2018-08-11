<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Categories</title>
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
			<jsp:useBean id="cb"
				class="com.sunbeaminfo.sh.onlinefood.beans.CategoryBean" />
			${cb.execute()}
			<form method="post" action="items.jsp">
				<c:forEach var="category" items="${cb.categoryList}">
					<input type="radio" name="category" value="${category}" /> ${category} <br />
				</c:forEach>
				<br /> 
				<input type="submit" value="Show Items" /> 
				<a href="showcart.jsp">Show Cart</a>
			</form>
		</div>
	</body>
</html>
