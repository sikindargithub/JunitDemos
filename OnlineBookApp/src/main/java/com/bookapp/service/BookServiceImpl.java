package com.bookapp.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.bookapp.dao.BookDaoImpl;
import com.bookapp.dao.ConnectionUtil;
import com.bookapp.dao.IBookDao;
import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.exceptions.IdNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.util.AllQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements IBookService{

	IBookDao bookDao = new BookDaoImpl();

	@Override
	public void addBook(Book book) {
		bookDao.addBook(book);
	}

	@Override
	public void updateBook(int bookId, double price) {
		bookDao.updateBook(bookId, price);
	}

	@Override
	public void deleteBook(int bookId) {
		bookDao.deleteBook(bookId);
	}

	@Override
	public Book getById(int bookId) throws IdNotFoundException {
		Book book = bookDao.findById(bookId);
		if(book == null)
			throw new IdNotFoundException("Invalid id");
		return book;
	}

	@Override
	public List<Book> getAll() {
		List<Book> bookList = bookDao.findAll();
		return bookList.stream().sorted(Comparator.comparing(Book::getTitle)).collect(Collectors.toList());
	}

	@Override
	public List<Book> getByAuthor(String author) throws BookNotFoundException {
		List<Book> bookListByAuthor = bookDao.findByAuthor(author);
		if(bookListByAuthor.isEmpty())
			throw new BookNotFoundException("Books by this author "+author+" are not found..");
		return bookListByAuthor;
	}

	@Override
	public List<Book> getByCategory(String category) throws BookNotFoundException {
		List<Book> bookListByCategory = bookDao.findByCategory(category);
		if(bookListByCategory.isEmpty())
			throw new BookNotFoundException("Books of this category "+category+" are not found..");
		return bookListByCategory.stream().sorted((o1,o2)->o1.getTitle().compareTo(o2.getTitle())).collect(Collectors.toList());
	}

	@Override
	public List<Book> getByLesserPrice(double price) throws BookNotFoundException {
		List<Book> bookListByPrice = bookDao.findByLesserPrice(price);
		if(bookListByPrice.isEmpty())
			throw new BookNotFoundException("Books below this price  "+price+" are not found..");
		return bookListByPrice.stream().sorted((o1,o2)->o1.getTitle().compareTo(o2.getTitle())).collect(Collectors.toList());
		
	}

}
