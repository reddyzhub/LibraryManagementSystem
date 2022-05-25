<%@page import="com.lms.entity.LoginDetails"%>
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
 <%LoginDetails loginDetails = (LoginDetails) session.getAttribute("loginDetails"); %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
     <% if(loginDetails != null && !loginDetails.isAdmin()) { %>	
      <li class="nav-item active">
        <a class="nav-link" href="checkout_list.jsp">Checkout List</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="search_books.jsp">Search Books</a>
      </li>
      <%} else if(loginDetails != null) {%>
       <li class="nav-item active">
        <a class="nav-link" href="add_book.jsp">Add Book</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="add_users.jsp">Add User</a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="checkout.jsp">Checkout</a>
      </li>
       <li class="nav-item active">
        <a class="nav-link" href="checkout_list.jsp">Checkout List </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="search_books.jsp">Search Books</a>
      </li>
      <%} %>
      <li class="nav-item">
        <a class="nav-link" href="logout.jsp">Logout</a>
      </li>
 </ul>  
   
  </div>
</nav>
