package com.revature.main;

import java.util.List;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.revature.model.Book;
import com.revature.service.Library;

public class Client {

	public static void main(String[] args) {
		String serviceURL = "http://localhost:8181/LibrarySOAPService/Library";
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(Library.class);
		factory.setAddress(serviceURL);
		
		//Set up interceptors to view soap messages
		factory.getInInterceptors().add(new LoggingInInterceptor());
		factory.getOutInterceptors().add(new LoggingOutInterceptor());
		
		//Consume WebService
		Library library = (Library) factory.create();
		List<Book> bookList = library.getBooks();
		for(Book b : bookList) {
			System.out.println(b);
		}
		
		System.out.println(library.addBook(new Book("demo", "demo", 1998)));

	}

}
