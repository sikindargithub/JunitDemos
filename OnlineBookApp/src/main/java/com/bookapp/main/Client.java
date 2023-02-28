package com.bookapp.main;

import java.util.Scanner;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.exceptions.IdNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.BookServiceImpl;
import com.bookapp.service.IBookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {

	public static void main(String[] args) {
		IBookService bookService = new BookServiceImpl();
		Book book1 = new Book(1234,"Java","Cathy","Tech",1234.56);
		Book book2 = new Book(3567,"Python","David","AI",1546.89);
		Book book3 = new Book(8732,"C++","Jenny","Tech",368.23);
		Book book4 = new Book(9342,"Kotlin","Cathy","Andriod",1897.24);

//		bookService.addBook(book1);
//		bookService.addBook(book2);
//		bookService.addBook(book3);
//		bookService.addBook(book4);

//		bookService.updateBook(8732, 450);
		bookService.deleteBook(9342);
		
//		try {
//			System.out.println(bookService.getById(3567));
//		} catch (IdNotFoundException e) {
//			e.printStackTrace();
//		}
		
//		System.out.println("All books : ");
//		bookService.getAll().forEach(System.out::println);
//		System.out.println("Books by author(Cathy) : ");
//		try {
//			bookService.getByAuthor("Cathy").forEach(System.out::println);
//		} catch (BookNotFoundException e) {
//			e.printStackTrace();
//		}
		
//		System.out.println("Books by category(Tech) : ");
//		try {
//			bookService.getByCategory("Tech").forEach(System.out::println);
//		} catch (BookNotFoundException e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println("Books below price of 1500 Rs : ");
//		try {
//			bookService.getByLesserPrice(1500).forEach(System.out::println);
//		} catch (BookNotFoundException e) {
//			e.printStackTrace();
//		}
		
		
	}

}
