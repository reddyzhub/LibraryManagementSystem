<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a new book</title>
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	<div class="table-responsive">
		<div class="container">
			<h1>Add a New Book</h1>
		</div>
		<form method="post" action="/LMS/BookServlet">
			<table class="mx-auto w-auto table">
				<tr>
					<td>Book Title</td>
					<td><input type="text" name="title"></td>
				</tr>
				<tr>
					<td>Book ISBN</td>
					<td><input type="text" name="isbn"></td>
				</tr>
				<tr>
					<td>Book Author</td>
					<td><input type="text" name="author"></td>
				</tr>
				<tr>
					<td>Book Publisher</td>
					<td><input type="text" name="publisher"></td>
				</tr>
				<tr>
					<td>Book Published Year</td>
					<td><input type="text" name="publishedYear"></td>
				</tr>
				<tr>
					<td>Book Price</td>
					<td><input type="text" name="price"></td>
				</tr>
				<tr>
					<td>Book Dewey</td>
					<td><input type="text" name="dewey"></td>
				</tr>
				<tr>
					<td>Number of Books</td>
					<td><input type="text" name="numberOfBooks"></td>
				</tr>

				<tr>
					<td colspan="2" style="text-align: center"><input
						type="submit" name="addBook" value="Add"></td>
			</table>

		</form>
	</div>
</body>
</html>