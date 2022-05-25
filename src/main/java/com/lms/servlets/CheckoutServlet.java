package com.lms.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.dao.BookDao;
import com.lms.dao.BookItemDao;
import com.lms.dao.CheckOutDao;
import com.lms.dao.LoginDetailsDao;
import com.lms.entity.Book;
import com.lms.entity.BookItem;
import com.lms.entity.LoginDetails;

/**
 * Servlet implementation class CheckoutServlet
 */
@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isbn = request.getParameter("isbn");
		String loginId = request.getParameter("loginId");
		String bookItemCode = request.getParameter("code");
		
		
//		BookDao bookDao = new BookDao();
//		Book book = new Book();
//		book.setIsbn(isbn);
//		List<Book> books = bookDao.searchBooks(book);
//		if(books == null || books.isEmpty()) {
//			request.setAttribute("errorMessage", "No book Found matching isbn:" + isbn);
//		}
//		
		BookDao bookDao = new BookDao();
		Book book = new Book();
		book.setIsbn(isbn);
		List<Book> books = bookDao.searchBooks(book);
		if(books == null || books.isEmpty()) {
			request.setAttribute("errorMessage", "No book Found matching isbn:" + isbn);
		} else {
			BookItemDao bookItemDao = new BookItemDao();
			List<BookItem> bookItems = bookItemDao.getBookItems(books.get(0).getBookId());
			if(bookItems == null || bookItems.isEmpty()) {
				request.setAttribute("errorMessage", "No book Items Found");
			} else {
				Optional<BookItem> bookItem = bookItems.stream().filter(bi -> bi.isAvailable()).findAny();
				if(!bookItem.isPresent()) {
					request.setAttribute("errorMessage", "No books Available to checkout");
				} else {
					LoginDetailsDao loginDetailsDao = new LoginDetailsDao();
					LoginDetails loginDetails = loginDetailsDao.getLoginDetails(loginId);
					if(loginDetails == null) {
						request.setAttribute("errorMessage", "No User Found matching loginId:" + loginId);
					} else {
						CheckOutDao checkoutDao = new CheckOutDao();
						checkoutDao.checkout(loginDetails.getUserId(), bookItem.get().getItemId());
						request.setAttribute("successMessage", "Successfully Checkedout the Book");
					}
				}
			}
			
		}
		request.getRequestDispatcher("/checkout.jsp").forward(request, response);
	}

}
