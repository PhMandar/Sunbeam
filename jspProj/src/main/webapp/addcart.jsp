<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
	<head>
	    <title>Add Cart</title>
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
			<jsp:useBean id="cb" scope="session"
				class="com.sunbeaminfo.sh.onlinefood.beans.CartBean" />
			<c:forEach var="p" items="${param}">
				<c:if test="${fn:startsWith(p.key, 'qty') && p.value != '0'}">
		            ${cb.addToCart(fn:substringAfter(p.key, 'qty_'), p.value)}          
		        </c:if>
			</c:forEach>
		</div>
		<jsp:forward page="categories.jsp" />
	</body>
</html>