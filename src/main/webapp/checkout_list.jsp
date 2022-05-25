<%@page import="com.lms.entity.LoginDetails"%>
<%@page import="com.lms.dao.CheckOutDao"%>
<%@page import="com.lms.entity.Checkout"%>
<%@page import="com.lms.entity.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<title>View checked out Books</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<div class="table-responsive">
<div class="container">
<h1>Your checked out books</h1>
</div>
	<table class="mx-auto w-auto table">
		<tr>
			<th scope="col">Book Title</th>
			<th scope="col">Author</th>
			<th scope="col">ISBN</th>
			<th scope="col">Book Item Code</th>
			<th scope="col">Checked out Date</th>
			<th scope="col">Due Date</th>
			<th scope="col">Fine Due</th>
		</tr>
		<%
		LoginDetails loginDetails1 = (LoginDetails) session.getAttribute("loginDetails");
		int userId = loginDetails1.getUserId();
		CheckOutDao checkoutDao = new CheckOutDao();
		List<Checkout> checkoutList = checkoutDao.getAllCheckedoutBooks(userId);
		if(checkoutList != null) {
		for (Checkout checkout : checkoutList) {
		%>
		<tr>
			<td><%=checkout.getBook().getTitle()%></td>
			<td><%=checkout.getBook().getAuthor()%></td>
			<td><%=checkout.getBook().getIsbn()%></td>
			<td><%=checkout.getBookItem().getCode() %></td>
			<td><%=checkout.getFromDate() %></td>
			<td><%=checkout.getToDate() %></td>
			<%if(checkout.isDue()){ %>
			<td>50</td>
			<%} else{ %>
			<td>N/A</td>
			<%} %>
		</tr>
		<%
		}
		}
		%>
	</table>
</div>
</body>
</html>