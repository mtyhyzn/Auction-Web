<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>
	<title>List Item</title>

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
			<h2>Mini Ebay - List Item</h2>
		
		</div>
		
		<div id="container">
			
			<h3>Listed By: ${user.userName}</h3>

			<form:form action="saveItem" modelAttribute="item" method="POST">
				<!--  need to associate this data with item id -->

				<form:hidden path="itemId" />
				
				<form:hidden path="ownerUsername.userName" value = "${user.userName}"/>


				Item name:        
								<form:input path="itemName" />
								<form:errors path="itemName" cssClass="error" />
				<br><br>
				Description:      
								<form:input path="description" />
								<form:errors path="description" cssClass="error" />
				<br><br>
				Condition:      
								<form:select path="condition" style="font-size: 20px; ">		
								<form:option value="1" label="New" />
								<form:option value="2" label="Very Good" />
								<form:option value="3" label="Good" />
								<form:option value="4" label="Fair" />
								<form:option value="5" label="Poor" />
								</form:select>
								<!--   
								New <form:radiobutton path="condition" value="1" /> 
								Very Good <form:radiobutton path="condition" value="2" />
								Good <form:radiobutton path="condition" value="3" />
								Fair <form:radiobutton path="condition" value="4" />
								Poor <form:radiobutton path="condition" value="5" />
								--> 
				<br><br>
				Start bidding price:	
								<form:input path="startBidingPrice"/>
								<form:errors path="startBidingPrice" cssClass="error" />
				<br><br>
				Min sale price:
								<form:input path="minSalePrice" />
								<form:errors path="minSalePrice" cssClass="error" />
				<br><br>			
				Get it now price:
								<form:input path="getItNowPrice" />
								<form:errors path="getItNowPrice" cssClass="error" />
				<br><br>
				Returnable:		
								
								Yes <form:radiobutton path="returnable" value="true" style="width: 50px"/>
								No <form:radiobutton path="returnable" value="false" style="width: 50px"/>
				<br><br>
				Category:
								<form:select path="name.name" style="font-size: 20px; ">	
								<form:option value="Art" label="Art" />
								<form:option value="Books" label="Books" />
								<form:option value="Electronics" label="Electronics" />
								<form:option value="Home & Garden" label="Home & Garden" />
								<form:option value="Sporting Goods" label="Sporting Goods" />
								<form:option value="Toys" label="Toys" />								
								<form:option value="Others" label="Others" />
								</form:select>

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