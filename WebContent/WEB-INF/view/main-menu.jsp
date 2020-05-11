<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Main Menu</title>
	
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

		<h2>Mini Ebay - Home Page</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">	
			
			<a href="<c:url value="/item/showFormForList?userId=${user.userName}"></c:url>">List Item</a>
			&nbsp;&nbsp;&nbsp;
			<a href="<c:url value="/auction/showAuctionList?userId=${user.userName}"></c:url>">Auction List</a>
			&nbsp;&nbsp;&nbsp;
			<a href="<c:url value="/auction/showMyBids?userId=${user.userName}"></c:url>">My Bids</a>
			&nbsp;&nbsp;&nbsp;
			<a href="<c:url value="/loginPage"></c:url>">Log Out</a>
			&nbsp;&nbsp;&nbsp;
			
			<!--  
			<input type="button" value="List Item"
				   onclick="window.location.href='showFormForList'; return false;"
				   class="add-button"
			/>
			-->

			
			<br><br>
			Welcome, ${user.userName}!
			<br><br>
						
			<!--  add out html table here -->

			<h3>Account Info</h3>
			

			<Table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Action</th>
				</tr>
				<!-- constructor an "edit link with item id -->
				<c:url var="editLink" value="/home/editProfile?userId=${user.userName}"></c:url>
				<tr>
					<td> ${user.firstName} </td>
					<td> ${user.lastName} </td>
					<td>
						<!--  display the Edit Profile link -->
						<a href="${editLink}">Edit Profile</a>
					</td>					
				</tr>			
			</Table>

			
			<br><br>
			
			<h3>My Items</h3>
			<Table>
				<tr>
					<th>Item ID</th>
					<th>Item Name</th>
					<th>Action</th>
				</tr>
				<!--  loop over and print our items  -->
				<c:forEach var="tempItem" items="${items}">
				
					<!-- constructor an "detail link with item id -->
					<c:url var="detailLink" value="/item/showItemDetail">
						<c:param name="itemId" value="${tempItem.itemId}"/>
						<c:param name="userName" value="${user.userName}"/>
					</c:url>
					<!-- 
					<c:url var="deleteLink" value="/home/delete">
						<c:param name="itemId" value="${tempItem.itemId}" />
					</c:url>
					-->
					<tr>
						<td> ${tempItem.itemId} </td>
						<td> ${tempItem.itemName} </td>
						
						<td>
							<!--  display the detail link -->
							<a href="${detailLink}">View Detail</a>
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
	&copy; Created by Yu

</body>
</html>