<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>
	<title>Edit Profile</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">
	
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/user-form-style.css">
		  	  
	<style>
		body {
		  background-image: url("${pageContext.request.contextPath}/resources/img/background.jpg");
		  background-repeat: no-repeat;
		  background-attachment: fixed; 
		  background-size: 100% 100%;
		}
	</style>

</head>

<body bgcolor="#ebe5da">

	<div id="wrapper">
		<div id="header">
			<h2>Mini Ebay - Account Info</h2>
		
		</div>
		
		<div id="container">
			<h3>${user.userName}</h3>

			<form:form action="saveUser" modelAttribute="user" method="POST">
				<!--  need to associate this data with user id -->
				<form:hidden path="userName" />
				
				<table>
					<tbody>
						<tr>
							<td><label>First name:</label></td>
							<td><form:input path="firstName" /></td>
						</tr>
						
						<tr>
							<td><label>Last name:</label></td>
							<td><form:input path="lastName" /></td>
						</tr>
						
						<tr>
							<td><label>Password:</label></td>
							<td><form:input path="password" /></td>
						</tr>
						
						<tr>
							<td><label></label></td>
							<td><input type="submit" value="Save" class="save" /></td>
						</tr>
					</tbody>				
				</table>			
			</form:form>
			
			<div style="clear; both;"></div>			
			<p>
				<a href="${pageContext.request.contextPath}/home/mainMenu?userName=${user.userName}">Back to Home Page</a>
			</p>		
		</div>
	
	</div>
	&copy; Created by Yu
</body>
</html>