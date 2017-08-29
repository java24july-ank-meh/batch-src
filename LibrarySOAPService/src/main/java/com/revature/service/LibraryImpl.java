package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.model.Book;

public class LibraryImpl implements Library {

	@Override
	public List<Book> getBooks() {
		List<Book> bookList = new ArrayList<>();
		
		//Should get books from backend
		bookList.add(new Book("HIVE", "Mark Walden", 2013));
		bookList.add(new Book("White Night", "Jim Butcher", 2013));
		bookList.add(new Book("Hitchiker's Guide to the Galaxy", "Douglas Adams", 1979));
		
		return bookList;
	}

	@Override
	public String addBook(Book b) {
		return "Successfully added book: " + b.getTitle();
	}

}
