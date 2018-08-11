<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
		<head>
			<title>Show Cart</title>
			<link rel="icon" type="image/png" href="Images/javalogo.gif" />
			<link href="css/style.css" rel="stylesheet" type="text/css" />
			<style type="text/css">
				body {
					background-image: url("Images/online-food.gif");
				}
			</style>
		</head>
		<body>
			<jsp:useBean id="cb" scope="session"
				class="com.sunbeaminfo.sh.onlinefood.beans.CartBean" />
			<jsp:useBean id="ib"
				class="com.sunbeaminfo.sh.onlinefood.beans.ItemBean" />
			<c:set var="total" value="0.0" />
			<div>
			<table border="1">
				<thead>
					<tr>
						<td>Id</td>
						<td>Name</td>
						<td>Info</td>
						<td>Category</td>
						<td>Price</td>
						<td>Quantity</td>
						<td>Item Total</td>
					</tr>
				</thead>
				<c:forEach var="itemQty" items="${cb.cart.entrySet()}">
					<jsp:setProperty name="ib" property="id" value="${itemQty.key}" />
		            ${ib.findItem()}
		            <tr>
						<td>${itemQty.key}</td>
						<td>${ib.item.name}</td>
						<td>${ib.item.info}</td>
						<td>${ib.item.category}</td>
						<td>${ib.item.price}</td>
						<td>${itemQty.value}</td>
						<td>${ib.item.price * itemQty.value}</td>
					</tr>
					<c:set var="total" value="${total + ib.item.price * itemQty.value}" />
				</c:forEach>
				<tr>
				    <td></td>
				    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>Total Price :</td>
                    <td>Rs. ${total}/-</td>
				</tr>
			</table>
			<br />
			<a href="categories.jsp">Menu</a> |
			<a style="float: right" href="logout.jsp">Sign Out</a>
			</div>
		</body>
</html>