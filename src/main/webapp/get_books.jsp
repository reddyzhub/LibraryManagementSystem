<%@page import="com.lms.entity.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Books</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<div class="table-responsive">
<div class="container">
<h1>Books Matching Search Criteria</h1>
</div>
	<table class="mx-auto w-auto table">
		<tr>
			<th scope="col">Book Title</th>
			<th scope="col">Author</th>
			<th scope="col">Publisher</th>
			<th scope="col">Year</th>
			<th scope="col">Price</th>
			<th scope="col">ISBN</th>
			<th scope="col">Dewey</th>
		</tr>
		<%
		List<Book> books = (List<Book>) request.getAttribute("books");
		if(books != null && !books.isEmpty()) {
		for (Book book : books) {
		%>
		<tr>
			<td><%=book.getTitle()%></td>
			<td><%=book.getAuthor()%></td>
			<td><%=book.getPublisher()%></td>
			<td><%=book.getPublishedYear()%></td>
			<td><%=book.getPrice()%></td>
			<td><%=book.getIsbn()%></td>
			<td><%=book.getDewey()%></td>

		</tr>
		<%}} %>
	</table>
</div>
</body>
</html>