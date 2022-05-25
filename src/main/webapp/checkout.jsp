<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Checkout</title>
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	<div class="table-responsive">
		<div class="container">
			<h1>Checkout a Book</h1>
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
		<form method="post" action="/LMS/CheckoutServlet">
			<table class="mx-auto w-auto table">

				<tr>
					<td>Book ISBN</td>
					<td><input type="text" name="isbn"></td>
				</tr>
				<tr>
					<td>Login Id</td>
					<td><input type="text" name="loginId"></td>
				</tr>
				<tr>
				<tr>
					<td colspan="2" style="text-align: center"><input
						type="submit" name="checkout" value="checkout"></td>
			</table>

		</form>
	</div>
</body>
</html>