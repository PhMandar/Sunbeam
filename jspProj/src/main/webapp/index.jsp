<%@ page language="java"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="icon" type="image/png" href="Images/javalogo.gif" />
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<meta charset="UTF-8">
		<title>Login</title>
		<style>
			body {
				background-image: url("Images/online-food.gif");
			}
		</style>
	</head>
	<body>
		<div>
			<table>
				<tr>
					<td></td>
					<td>
						<form method="post" action="login.jsp">
							Email: <input name="email" type="text" /> <br />
							<br /> Password: <input name="password" type="password" /> <br />
							<br /> <input type="submit" value="Sign In" />
						</form>
	
					</td>
				</tr>
			</table>
		</div>
		<h2>Welcome to online foodpanda !</h2>
	</body>
</html>