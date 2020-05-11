<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>My Bids</title>
	
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">
	
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/main-menu-style.css">
		  
	<style>
		body {
		  background-image: url("${pageContext.request.contextPath}/resources/img/background.jpg");
		  background-repeat: no-repeat;
		  background-attachment: fixed; 
		  background-size: 100% 100%;
		}
	</style>
	
	<!--  overwrite the table width -->
	<style>
		table {
			width: 80%;
		}
	
	</style>
		  	  
</head>

<body bgcolor="#ebe5da">

	<div id="wrapper">
		<div id="header">
		<h2>Mini Ebay - My Bids</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">	
			
			
			<br><br>
			Hey ${user.userName}: Here is your bid history.
			<br><br>
						
			
			<h3>My Bids</h3>
			<Table>
				<tr>
					<th>Item ID</th>
					<th>Item Name</th>
					<th>Bid Time</th>
					<th>Bid Amount</th>
					<th>Action</th>
				</tr>
				<!--  loop over and print our items  -->
				<c:forEach var="tempBid" items="${bids}">
				
					<!-- constructor an "detail link with item id -->
					<c:url var="detailLink" value="/item/showItemDetail">
						<c:param name="itemId" value="${tempBid.bidItem.itemId}"/>
						<c:param name="userName" value="${user.userName}"/>
					</c:url>
					<!-- 
					<c:url var="deleteLink" value="/home/delete">
						<c:param name="itemId" value="${tempItem.itemId}" />
					</c:url>
					-->
					<tr>
						<td> ${tempBid.bidItem.itemId} </td>
						<td> ${tempBid.bidItem.itemName} </td>
						<td> ${tempBid.id.bidTime} </td>
						<td> ${tempBid.bidAmount} </td>
						
						<td>
							<!--  display the detail link -->
							<a href="${detailLink}">View Item Detail</a>
							<!--  
							|
							<a href="${deleteLink}"
							   onclick="if(!(confirm('Are you sure you want to delete this item?'))) return false">Delete</a>
							--> 
							   
						</td>
					</tr>
					
				</c:forEach>			
			</Table>
		
		</div>
	
	</div>
	
	<br><br>
	<br><br>
	<p>
	<a href="${pageContext.request.contextPath}/home/mainMenu?userName=${user.userName}">Back to Home Page</a>
	</p>	
	&copy; Created by Yu
</body>
</html>