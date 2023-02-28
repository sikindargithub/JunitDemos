package com.bookapp.testcases;

import static org.junit.jupiter.api.Assertions.*;

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
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookapp.model.Book;
import com.bookapp.service.BookDetails;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
class BookDetailsTest {

	@Spy // this will create an object for BookDetails and call the real methods
	BookDetails bookDetails;
	
	@Mock
	BookDetails mbookDetails;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@DisplayName("Using Spy")
	void testShowBookSpy() {
		List<String> books = bookDetails.showBooks();
		assertEquals(3, books.size());
	}

	

	@Test
	@DisplayName("Using Mock")
	void testShowBookMock() {
		List<String> books = mbookDetails.showBooks();
		assertEquals(3, books.size());
	}
}
