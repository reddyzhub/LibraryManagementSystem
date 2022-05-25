package com.lms;

import com.lms.dao.BookDao;
import com.lms.entity.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        BookDao bookDao = new BookDao();

        Book book = new Book();
        book.setAuthor("asdad");
        book.setTitle("Book titel");
        book.setIsbn("23423");
        book.setDewey(1);
        book.setPrice(12.2);
        book.setPublishedYear(1991);
        book.setPublisher("publisher");
       // bookDao.saveBook(book);

        List<Book> books = bookDao.getAllBooks();
        System.out.println(books);
    }



}
