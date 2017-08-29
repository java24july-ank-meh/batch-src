package com.revature.service;

import java.util.List;

import javax.jws.WebService;

import com.revature.model.Book;

@WebService
public interface Library {
	List<Book> getBooks();
	String addBook(Book b);
}
