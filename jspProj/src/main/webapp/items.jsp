<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
	    <title>Items</title>
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
			class="com.sunbeaminfo.sh.onlinefood.beans.CategoryItemsBean" />
		<jsp:setProperty name="ib" property="*" />
		${ib.execute()}
		<form method="post" action="addcart.jsp">
			<table>
				<c:forEach var="item" items="${ib.itemList}" varStatus="status">
					<tr>
						<td>o</td>
						<td>${item.name}</td>
						<td><input type="number" min="0" max="10" style="width: 35px"
							name="qty_${item.id}" value="${cb.getQuantity(item.id)}" /></td>
					</tr>
				</c:forEach>
				<tr>
				     <td></td> <td></td><td>
				         <input type="submit" value="Add Cart" />
				     </td>
				</tr>     
			</table>
			<br /> 
		</form>
	</body>
</html>

