<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add new User</title>
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	<div class="table-responsive">
		<div class="container">
			<h1>Add a New User</h1>
		</div>
			<% if(request.getAttribute("errorMessage") != null) { %>
		<div class="alert alert-danger alert-dismissible fade show"
			role="alert">
			<%= request.getAttribute("errorMessage") %>	
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
		<%} %>
		<% if(request.getAttribute("successMessage") != null) { %>
		<div class="alert alert-success alert-dismissible fade show"
			role="alert">
			<%= request.getAttribute("successMessage") %>	
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
		<%} %>
		<form method="post" action="/LMS/UserServlet">
			<table class="mx-auto w-auto table">

				<tr>
					<td>First Name</td>
					<td><input type="text" name="firstName"></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="lastName"></td>
				</tr>
				<tr>
					<td>Email Id</td>
					<td><input type="text" name="emailId"></td>
				</tr>
				<tr>
					<td>Phone Number</td>
					<td><input type="text" name="phoneNumber"></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><input type="text" name="address"></td>
				</tr>
				<tr>
					<td>Pin Code</td>
					<td><input type="text" name="pinCode"></td>
				</tr>
				<tr>
					<td>isAdmin</td>
					<td><input type="checkbox" name="isAdmin"></td>
				</tr>
				<tr>
					<td>password</td>
					<td><input type="password" name="password"></td>
				</tr>


				<tr>
					<td colspan="2" style="text-align: center"><input
						type="submit" name="addUser" value="Add"></td>
				</tr>
			</table>

		</form>
	</div>

</body>
</html>