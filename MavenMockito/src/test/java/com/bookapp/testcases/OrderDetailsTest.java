package com.bookapp.testcases;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.IBookService;
import com.bookapp.service.OrderDetails;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
class OrderDetailsTest {

	
	
	@Mock
	IBookService bookService; // creating a proxy of IBookService
	@InjectMocks
	OrderDetails orderDetails = null;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	Book book1,book2,book3,book4,book5;
	@BeforeEach
	void setUp() throws Exception {
		
		 book1 = new Book(1,"Java","Kathy",900);
		 book2 = new Book(2,"Css","Kathy",200);
		 book3 = new Book(2,"Seven Habits","Steve",300);
		 book4 = new Book(2,"5am club","Robin",800);
		 book5 = new Book(2,"Spring","Kathy",1000);
	}

	@AfterEach
	void tearDown() throws Exception {
		orderDetails = null;
	}

	@Test
	@DisplayName("Testing By Author")
	void testBookByAuhtor() throws BookNotFoundException {
		String author = "Kathy";
		List<Book> bookByAuthor = Arrays.asList(book1,book2,book5);
		//mock the method  and assume it returns a list of books by author
		Mockito.when(bookService.getByAuthor(author)).thenReturn(bookByAuthor);
		//after getting the data
		List<Book> books = orderDetails.findByAuthor(author);
		assertNotNull(books);
		
	}
	
	@Test
	@DisplayName("Testing By Author -returning null")
	void testBookByAuhtorNull() throws BookNotFoundException {
		String author = "David";
		//mock the method  and assume it returns null
		when(bookService.getByAuthor(author)).thenReturn(null);
		List<Book> actualList = orderDetails.findByAuthor(author);
		assertNull(actualList);
		
		
	}
	
	@Test
	@DisplayName("Testing By Author - sort by name")
	void testByAuthorSorted() throws BookNotFoundException {
		String author = "Kathy";
		List<Book> expected = Arrays.asList(book2,book1,book5); // sorted books
		when(bookService.getByAuthor(author)).thenReturn(Arrays.asList(book1,book2,book5));
		// method to be tested
		List<Book> actualList = orderDetails.findByAuthor(author);
		assertEquals(expected.toString(),actualList.toString());	
		
	}
	
	@Test
	@DisplayName("Testing By Author - empty list")
	void testByAuthorEmpty() throws BookNotFoundException {
		String author = "Kathy";
		when(bookService.getByAuthor(author)).thenReturn(new ArrayList<Book>());
		assertThrows(BookNotFoundException.class, ()->orderDetails.findByAuthor(author));
	}
	
	@Test
	@DisplayName("Testing By Author - throw exception")
	void testByAuthorException() throws BookNotFoundException {
		String author = "paul";
		when(bookService.getByAuthor(author)).thenThrow(new BookNotFoundException());
		assertThrows(BookNotFoundException.class, ()->orderDetails.findByAuthor(author));	
	}
	
	@Test
	@DisplayName("Testing verify")
	void testVerify() throws BookNotFoundException {
		String author = "Kathy";
		List<Book> expected = Arrays.asList(book2,book1,book5);
		
		when(bookService.getByAuthor(author)).thenReturn(Arrays.asList(book1,book2,book5));
		List<Book> actualList = orderDetails.findByAuthor(author);
		assertEquals(expected.toString(),actualList.toString());
		assertNotNull(actualList);
		
		when(bookService.getByAuthor(author)).thenReturn(null);
		List<Book> actual = orderDetails.findByAuthor(author);
		assertNull(actual);
		
		verify(bookService,times(2)).getByAuthor(author);
		verify(bookService,atLeastOnce()).getByAuthor(author);
		verify(bookService,atLeast(2)).getByAuthor(author);
	}
	
	
	
	
	
	
	
	
	
	
	

}

