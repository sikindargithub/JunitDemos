package com.bookapp.service;

import java.util.List;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;

// This is the interface to be mocked
public interface IBookService {
	
	// list of books,null,empty,exception
	List<Book> getByAuthor(String author) throws BookNotFoundException;
	List<Book> getByLessPrice(double price) throws BookNotFoundException;
	
	// book,exception,null
	Book getById(int bookId) throws BookNotFoundException;
	
	void addBook(Book book);

}
