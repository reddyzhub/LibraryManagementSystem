package com.lms.dao;

import com.lms.entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDao extends GenericDao {

    public void saveBook(Book book) {
        String query = "INSERT INTO libman.book(title, isbn, author , publisher ,published_year, dewey, price) VALUES (?,?,?,?,?,?,?)";
        Connection connection = getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getIsbn());
            statement.setString(3, book.getAuthor());
            statement.setString(4, book.getPublisher());
            statement.setInt(5, book.getPublishedYear());
            statement.setInt(6, book.getDewey());
            statement.setDouble(7, book.getPrice());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if(rs.next()) {
            	book.setBookId(rs.getInt(1));
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

    public List<Book> getAllBooks() {
        String sql = "select book_id,title, isbn, author , publisher ,published_year, dewey, price  from libman.book";
        Connection connection = getConnection();
        List<Book> books = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                Book book = new Book();
                book.setBookId(rs.getInt("book_id"));
                book.setTitle(rs.getString("title"));
                book.setIsbn(rs.getString("isbn"));
                book.setAuthor(rs.getString("author"));
                book.setPublisher(rs.getString("publisher"));
                book.setPublishedYear(rs.getInt("published_year"));
                book.setDewey(rs.getInt("dewey"));
                book.setPrice(rs.getDouble("price"));
                books.add(book);
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
        return books;
    }
    
    public List<Book> searchBooks(Book searchCriteria) {
    	
        String sql = "select book_id,title, isbn, author , publisher ,published_year, dewey, price  from libman.book";
        String criteria = "";
        if(searchCriteria.getTitle() != null  && !"".equals(searchCriteria.getTitle().trim())) {
        	criteria += "title = '" + searchCriteria.getTitle() +"'";
        	criteria += " and ";
        }
        if(searchCriteria.getAuthor() != null && !"".equals(searchCriteria.getAuthor().trim())) {
        	criteria += " author = '" + searchCriteria.getAuthor() + "'";
        	criteria += " and ";
        }
        if(searchCriteria.getIsbn() != null  && !"".equals(searchCriteria.getIsbn().trim())) {
        	criteria += " isbn = '" + searchCriteria.getIsbn() + "'";
        	criteria += " and ";
        }
        if(!criteria.isEmpty()) {
        	criteria = criteria.substring(0, criteria.length() - 4);
        	sql += " where " + criteria;
        }
        Connection connection = getConnection();
        List<Book> books = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                Book book = new Book();
                book.setBookId(rs.getInt("book_id"));
                book.setTitle(rs.getString("title"));
                book.setIsbn(rs.getString("isbn"));
                book.setAuthor(rs.getString("author"));
                book.setPublisher(rs.getString("publisher"));
                book.setPublishedYear(rs.getInt("published_year"));
                book.setDewey(rs.getInt("dewey"));
                book.setPrice(rs.getDouble("price"));
                books.add(book);
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
        return books;
    }
}
