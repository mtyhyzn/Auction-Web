<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>
	<title>Bid Item</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">
	
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/list-item-style.css">
		  
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
			<h2>Mini Ebay - Bid Item</h2>
		
		</div>
		
		<div id="container">
			
			<br><br>
			Current bid amount: ${bidAmount}		
			<br><br>

			<form:form action="saveBid" modelAttribute="bid" method="POST">
				<!--  need to associate this data with item id -->
				<!--  
				<form:hidden path="id" />
				-->				
				<form:hidden path="bidUsername.userName" value = "${user.userName}"/>
				<form:hidden path="bidItem.itemId" value = "${item.itemId}"/>


				Bid price:        
								<form:input path="bidAmount" />
								<form:errors path="bidAmount" cssClass="error" />

							<td><label></label></td>
							<td><input type="submit" value="Save" class="save" /></td>
			
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