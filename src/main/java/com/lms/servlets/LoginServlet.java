package com.lms.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.dao.CheckOutDao;
import com.lms.dao.LoginDetailsDao;
import com.lms.entity.Checkout;
import com.lms.entity.LoginDetails;	

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String loginId = req.getParameter("loginId");
		String password = req.getParameter("password");
		
		LoginDetailsDao loginDetailsDao = new LoginDetailsDao();
		LoginDetails loginDetails = loginDetailsDao.getLoginDetails(loginId);
		req.getSession().setAttribute("loginDetails", loginDetails);
		if(loginDetails == null || !loginDetails.getPassword().equals(password)) {
			req.setAttribute("errorMessage", "invalid credentials");
			req.getRequestDispatcher("/welcome.jsp").forward(req, resp);
		} else if(loginDetails.isAdmin()) {
			req.getRequestDispatcher("/add_book.jsp").forward(req, resp);
		} else {
			CheckOutDao checkoutDao = new CheckOutDao();
			List<Checkout> checkedoutBooks = checkoutDao.getAllCheckedoutBooks(loginDetails.getUserId());
			req.setAttribute("checkoutList", checkedoutBooks);
			req.getRequestDispatcher("/checkout_list.jsp").forward(req, resp);
		}
	}

}
