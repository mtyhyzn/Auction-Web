<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Auction List</title>
	
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
		  	  
</head>

<body bgcolor="#ebe5da">

	<div id="wrapper">
		<div id="header">
		<h2>Mini Ebay - Auction List</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">	
			
			
			<br><br>
			Hey ${user.userName}: Here is the auction list.
			<br><br>
						
			
			<h3>Open Auction</h3>
			<Table>
				<tr>
					<th>Item ID</th>
					<th>Item Name</th>
					<th>Action</th>
				</tr>
				<c:set var="val" value="${openItems}"/>
				<c:choose>
					<c:when test="${empty val}">
				        <td> No record found </td>
				    </c:when>
				</c:choose>
				<!--  loop over and print our items  -->
				<c:forEach var="tempItem" items="${openItems}">
				
					<!-- constructor an "detail link with item id -->
					<c:url var="detailLink" value="/item/showItemDetail">
						<c:param name="itemId" value="${tempItem.itemId}"/>
						<c:param name="userName" value="${user.userName}"/>
					</c:url>

					<c:url var="bidLink" value="/auction/bidItem">
						<c:param name="userId" value="${user.userName}" />
						<c:param name="itemId" value="${tempItem.itemId}" />
					</c:url>

					<tr>
						<td> ${tempItem.itemId} </td>
						<td> ${tempItem.itemName} </td>
						
						<td>
							<!--  display the detail link -->
							<a href="${detailLink}">View Detail</a>
 
							|
							<a href="${bidLink}"
							   onclick="if(!(confirm('Are you sure you want to bid this item?'))) return false">Bid</a>
							   
						</td>
					</tr>
					
				</c:forEach>			
			</Table>
			<br><br>
			<h3>Closed Auction</h3>
			<Table>
				<tr>
					<th>Item ID</th>
					<th>Item Name</th>
					<th>Action</th>
				</tr>
				<!--  loop over and print our items  -->
				<c:forEach var="tempItem" items="${closedItems}">
				
					<!-- constructor an "detail link with item id -->
					<c:url var="detailLink" value="/item/showItemDetail">
						<c:param name="itemId" value="${tempItem.itemId}"/>
						<c:param name="userName" value="${user.userName}"/>
					</c:url>

					<c:url var="bidLink" value="/item/showItemDetail">
						<c:param name="itemId" value="${tempItem.itemId}" />
					</c:url>

					<tr>
						<td> ${tempItem.itemId} </td>
						<td> ${tempItem.itemName} </td>
						
						<td>
							<!--  display the detail link -->
							<a href="${detailLink}">View Detail</a>							   
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