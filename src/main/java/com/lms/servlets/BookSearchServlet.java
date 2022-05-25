package com.lms.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.dao.BookDao;
import com.lms.entity.Book;

/**
 * Servlet implementation class BookSearchServlet
 */
@WebServlet("/BookSearchServlet")
public class BookSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		
		BookDao bookDao = new BookDao();
		Book book = new Book();
		book.setTitle(title);
		book.setAuthor(author);
		List<Book> books = bookDao.searchBooks(book);
		request.setAttribute("books", books);
		request.getRequestDispatcher("/get_books.jsp").forward(request, response);
	}

}
