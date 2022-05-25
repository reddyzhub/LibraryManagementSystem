<%@page import="com.lms.entity.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Books</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<div class="table-responsive">
<div class="container">
<h1>Search books</h1>
</div>

<form method="post" action="/LMS/BookSearchServlet">
	<table class="mx-auto w-auto table">
		<tr>
			<td>Book title</td>
			<td><input type="text" name="title"></td>
		</tr>
		<tr>
			<td>Book Author</td>
			<td><input type="text" name="author"></td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: center"><input type="submit"
				name="search" value="Search"></td>
		</tr>
	</table>
</form>
</div>
</body>
</html>