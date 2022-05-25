package com.lms.entity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Checkout {

	private Book book;
	private User user;
	private BookItem bookItem;
	private String fromDate;
	private String toDate;
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public BookItem getBookItem() {
		return bookItem;
	}
	public void setBookItem(BookItem bookItem) {
		this.bookItem = bookItem;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	
	public boolean isDue() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return (dateFormat.parse(fromDate).after(dateFormat.parse(toDate)));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
}
