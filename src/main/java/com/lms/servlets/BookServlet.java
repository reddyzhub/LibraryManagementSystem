package com.lms.servlets;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.dao.BookDao;
import com.lms.dao.BookItemDao;
import com.lms.entity.Book;
import com.lms.entity.BookItem;

@WebServlet(name = "/BookServlet", urlPatterns = {"/BookServlet"})
public class BookServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Book book = new Book();
		book.setAuthor(req.getParameter("author"));
		book.setIsbn(req.getParameter("isbn"));
		book.setTitle(req.getParameter("title"));
		book.setPublisher(req.getParameter("publisher"));
		book.setPublishedYear(Integer.valueOf(req.getParameter("publishedYear")));
		book.setPrice(Double.valueOf(req.getParameter("price")));
		book.setDewey(Integer.valueOf(req.getParameter("dewey")));
		int bookCount = Integer.valueOf(req.getParameter("numberOfBooks"));
		BookDao bookDao = new BookDao();
		bookDao.saveBook(book);
		BookItemDao bookItemDao = new BookItemDao();
		for(int i = 0; i < bookCount; i++) {
			BookItem bookItem = new BookItem();
			bookItem.setBookId(book.getBookId());
			bookItem.setCode(UUID.randomUUID().toString());
			bookItemDao.addBookItem(bookItem);
		}
		List<Book> books = bookDao.getAllBooks();
		req.setAttribute("books", books);
		req.getRequestDispatcher("/get_books.jsp").forward(req, resp);
		
	}
}
