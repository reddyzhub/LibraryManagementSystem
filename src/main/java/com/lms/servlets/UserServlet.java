package com.lms.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.dao.LoginDetailsDao;
import com.lms.dao.UserDao;
import com.lms.entity.LoginDetails;
import com.lms.entity.User;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = new User();
		
		
		user.setFirstName(req.getParameter("firstName"));
		user.setLastName(req.getParameter("lastName"));
		user.setEmailId(req.getParameter("emailId"));
		user.setPhoneNumber(req.getParameter("phoneNumber"));
		user.setAddress(req.getParameter("address"));
		user.setPinCode(req.getParameter("pinCode"));
		
		
		UserDao userDao = new UserDao();
		userDao.addUser(user);
		
		LoginDetails logInDetails = new LoginDetails();
		String password = req.getParameter("password");
		logInDetails.setLoginId(user.getEmailId());
		logInDetails.setPassword(password);
		logInDetails.setAdmin(Boolean.valueOf(req.getParameter("isAdmin")));
		logInDetails.setUserId(user.getUserId());
		LoginDetailsDao loginDetailsDao = new LoginDetailsDao();
		loginDetailsDao.addLogin(logInDetails);
		
		req.setAttribute("successMessage", "Successfully added User" + logInDetails.getLoginId());
		
		req.getRequestDispatcher("/add_users.jsp").forward(req, resp);
	}
}
