<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
<head>
	<title>View Item Detail</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">
	
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/view-item-style.css">

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
			<h2>Mini Ebay - Item Detail</h2>
		
		</div>
		<br></br>
		<div id="container">
			<h3>${item.itemName}</h3>
			
			<img src="${pageContext.request.contextPath}/resources/img/${item.itemName}.png" 
			onError="this.src = '${pageContext.request.contextPath}/resources/img/Null Image.png'"
			height="300">
			
			<br><br>
			<b>Item ID</b>: ${item.itemId}
			<br><br>
			<b>Item Name</b>: ${item.itemName}
			<br><br>
			<b>Owner</b>: ${item.ownerUsername.firstName} ${item.ownerUsername.lastName}
			<br><br>
			<b>Description</b>: ${item.description}
			<br><br>
			<b>Condition</b>: 
								<c:set var="val" value="${item.condition}"/>
								<c:choose>
									<c:when test="${val == '1'}">
								        New
								    </c:when>
									<c:when test="${val == '2'}">
								        Very good
								    </c:when>
									<c:when test="${val == '3'}">
								        Good
								    </c:when>
								    <c:when test="${val == '4'}">
								        Fair
								    </c:when>
								    <c:otherwise>
								        Poor
								    </c:otherwise>
								</c:choose>
			<br><br>			
			<b>Start Biding Price</b>: ${item.startBidingPrice}
			<br><br>
			<b>Min Sale Price</b>: ${item.minSalePrice}
			<br><br>
			<b>Get it now Price</b>: ${item.getItNowPrice}
			<br><br>
			<b>Auction Ends Time</b>: ${item.auctionEndsTime}
			<br><br>
			<b>Returnable</b>:  
								<c:choose>
								    <c:when test="${item.returnable}">
								        Yes
								    </c:when>
								    <c:otherwise>
								        No
								    </c:otherwise>
								</c:choose>

			<br><br>
			<b>Category</b>: ${item.name.name}
			<br><br>
			
			<h3>Bid History</h3>
			<Table>
				<tr>
					<th>Item ID</th>
					<th>Item Name</th>
					<th>Bid Time</th>
					<th>Bid Amount</th>
					<th>Bid By</th>
				</tr>
				<c:set var="val" value="${bids}"/>
				<c:choose>
					<c:when test="${empty val}">
				        <td> No record found </td>
				    </c:when>
				</c:choose>
				<!--  loop over and print our items  -->
				<c:forEach var="tempBid" items="${bids}">
				
					<tr>
						<td> ${tempBid.bidItem.itemId} </td>
						<td> ${tempBid.bidItem.itemName} </td>
						<td> ${tempBid.id.bidTime} </td>
						<td> ${tempBid.bidAmount} </td>
						<td> ${tempBid.bidUsername.firstName} ${tempBid.bidUsername.lastName}</td>

					</tr>
					
				</c:forEach>			
			</Table>
			
					
			<br><br>
			<br><br>			
			<div style="clear; both;"></div>			
			<p>
				<a href="${pageContext.request.contextPath}/home/mainMenu?userName=${user.userName}">Back to Home Page</a>
			</p>	
		</div>
	
	</div>	
	&copy; Created by Yu
</body>
</html>