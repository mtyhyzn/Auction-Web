<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
<head>
	<title>Sign in</title>

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
			<h2>Mini Ebay - Login Page</h2>
		
		</div>
		
		<div id="container">

			<form:form action="login" modelAttribute="user" method="GET">
				<!--  need to associate this data with user id -->
				
				<table>
					<tbody>
						<tr>
							<td><label>User name:</label></td>
							<td><form:input path="userName" placeholder="user1"/></td>
						</tr>
						
						<tr>
							<td><label>Password:</label></td>
							<td><form:input path="password" placeholder="pass1"/></td>
						</tr>
						
						<c:if test="${not empty error}">
							Error: ${error}
						</c:if>
						
						<tr>
							<td><label></label></td>
							<td><input type="submit" value="Login" class="save" /></td>
						</tr>
					</tbody>				
				</table>			
			</form:form>
			

		</div>
	
	</div>
	
	<br><br>
	&copy; Created by Yu
</body>
</html>