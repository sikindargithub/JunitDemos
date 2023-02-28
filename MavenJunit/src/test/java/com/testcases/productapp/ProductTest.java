package com.testcases.productapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("Product")
public class ProductTest {

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
	@Tag("creation")
	void testAdd() {
		String s1 = "Hello";
		String s2 = "Hello";
		assertSame(s1, s2);
	}
	
	@Test
	@Tag("all-products")
	void testAll() {
		int[] numbers = null;
		assertNull(numbers,"numbers is not null");
	}
	
	@Test
	@Tag("by-brand")
	void testAllBrand() {
		int[] numbers = null;
		assertNotNull(numbers,"numbers is  null");
	}
	
}
