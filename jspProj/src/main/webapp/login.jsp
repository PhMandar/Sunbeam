<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login</title>
		<link rel="icon" type="image/png" href="Images/javalogo.gif" />
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<style type="text/css">
			body {
				background-image: url("Images/online-food.gif");
			}
		</style>
	</head>
	<body>
		<jsp:useBean id="lb"
			class="com.sunbeaminfo.sh.onlinefood.beans.LoginBean" />
		<jsp:setProperty name="lb" property="*" />
		<c:choose>
			<c:when test="${lb.status == true}">
				<c:redirect url="categories.jsp" />
			</c:when>
			<c:otherwise>
	            Invalid email and password. <br />
				<br />
				<a href="index.jsp">Login Again</a>
			</c:otherwise>
		</c:choose>
	</body>
</html>