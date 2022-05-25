<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<!-- Dependencies -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0-beta1/jquery.min.js" type="text/javascript"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" type="text/javascript"></script>
<script src="http://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.js" type="text/javascript"></script>

<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" type="text/css" media="screen" />
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" media="screen" />
<!-- Core files -->

<script src="jquery.alerts.js" type="text/javascript"></script>
<link href="jquery.alerts.css" rel="stylesheet" type="text/css" media="screen" />
<title>Welcome to LMS</title>
<style>
body {
    height: 100%;
}

.container {
    height: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
}
</style>
</head>
<body>
<div class="table-responsive">
<div class="container">
<h1>Welcome to LMS</h1>
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
<form method="post" action="/LMS/LoginServlet">
<table class="mx-auto w-auto">

<tr>
<td>Login Id</td>
<td><input type="text" name="loginId"></td>
</tr>
<tr>
<td>Password</td>
<td><input type="password" name="password"></td>
</tr>
<tr>
<td colspan="2" style="text-align:center">
<input type="submit" name="login" value="Login">
</td>
</table>
</form>
</div>
</body>
</html>