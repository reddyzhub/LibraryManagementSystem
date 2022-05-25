package com.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lms.entity.BookItem;

public class BookItemDao extends GenericDao {

	public void addBookItem(BookItem bookItem) {
		 String query = "INSERT INTO libman.book_item(book_id, code) VALUES (?,?)";
	        Connection connection = getConnection();
	        try {
	            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	            statement.setInt(1, bookItem.getBookId());
	            statement.setString(2, bookItem.getCode());
	            statement.executeUpdate();
	            ResultSet rs = statement.getGeneratedKeys();
	            if(rs.next()) {
	            	bookItem.setItemId(rs.getInt(1));
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
	}
	
	
	public List<BookItem> getBookItems(int bookId) {
		
		String sql = "select book_item_id, book_id,code,is_available from libman.book_item where book_id=?";
        Connection connection = getConnection();
        List<BookItem> items = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, bookId);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                BookItem item = new BookItem();
                item.setBookId(rs.getInt("book_id"));
                item.setCode(rs.getString("code"));
                item.setItemId(rs.getInt("book_item_id"));
                item.setAvailable(rs.getBoolean("is_available"));
                items.add(item);
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
        return items;
		
	}
	
public BookItem getBookItemByCode(String code) {
		
		String sql = "select book_item_id, book_id,code from libman.book_item where code=?";
        Connection connection = getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, code);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                BookItem item = new BookItem();
                item.setBookId(rs.getInt("book_id"));
                item.setCode(rs.getString("code"));
                item.setItemId(rs.getInt("book_item_id"));
               return item;
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
        return null;
		
	}
}
