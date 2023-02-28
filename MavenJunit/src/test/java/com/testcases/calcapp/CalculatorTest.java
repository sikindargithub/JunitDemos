package com.testcases.calcapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.acheron.training.Calculator;

public class CalculatorTest {
	Calculator calc = null;

	@BeforeAll
	public static void init() {
		System.out.println("runs before all test cases");
	}

	@AfterAll
	public static void cleanup() {
		System.out.println("runs after all test cases");
	}
	
	@BeforeEach
	public void setup() {
		calc = new Calculator();
		System.out.println("runs before each test case");
	}

	@AfterEach
	public void teardown() {
		calc = null;
		System.out.println("runs after each test case");
	}
	@Test
	public void testAdd() {
		// call the method to be tested
		int actualResult = calc.add(20, 30);
		int expected = 50;
		assertEquals(expected, actualResult, "The expected result is 50");
	}
	
	@Test
	public void testProduct() {
		assertEquals(20,calc.product(5, 4),"The expected result is 20");
	}
	
	@Test
	public void testDifference() {
		assertEquals(8,calc.difference(20, 12),"The expected result is 8");
	}
	
	@Test
	public void testGreetUser() {
		assertEquals("Welcome SIKINDAR",calc.greetUser("sikindar"));
	}
	
	
}
