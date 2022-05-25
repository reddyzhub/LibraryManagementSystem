package com.lms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.lms.entity.Book;
import com.lms.entity.BookItem;
import com.lms.entity.Checkout;
import com.lms.entity.User;


public class CheckOutDao extends GenericDao {

	public void checkout(int userId, int bookItemId) {
		 String query = "INSERT INTO libman.checkout(user_id, book_item_id, from_date , to_date ) VALUES (?,?,?,?)";
	        Connection connection = getConnection();
	        try {
	            PreparedStatement statement = connection.prepareStatement(query);
	            statement.setInt(1, userId);
	            statement.setInt(2,bookItemId);
	            statement.setDate(3, new Date(System.currentTimeMillis()));
	            Calendar cal = Calendar.getInstance();
	            cal.add(Calendar.MONTH, 1);
	            statement.setDate(4, new Date(cal.getTimeInMillis()));
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	}
	
	public List<Checkout> getAllCheckedoutBooks(int userId) {
		String sql = "select book.book_id, book_item.book_item_id,checkout.user_id, title, author, isbn, code, from_date, to_date from libman.book inner join libman.book_item on book_item.book_id=book.book_id inner join libman.checkout on checkout.book_item_id=book_item.book_item_id where checkout.user_id=?";
        Connection connection = getConnection();
        List<Checkout> checkoutObjects = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
            	Checkout checkout = new Checkout();
            	
            	Book book = new Book();
            	book.setAuthor(rs.getString("author"));
            	book.setTitle(rs.getString("title"));
            	book.setIsbn(rs.getString("isbn"));
            	book.setBookId(rs.getInt("book_id"));
            	
            	BookItem bookItem = new BookItem();
            	bookItem.setCode(rs.getString("code"));
            	bookItem.setItemId(rs.getInt("book_item_id"));
            	
                User user = new User();
                user.setUserId(rs.getInt("user_id"));
                
                checkout.setBook(book);
                checkout.setBookItem(bookItem);
                checkout.setUser(user);
                checkout.setFromDate(rs.getString("from_date"));
                checkout.setToDate(rs.getString("to_date"));
                
                checkoutObjects.add(checkout);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return checkoutObjects;
	}
}
