package com.testcases.bankapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.acheron.bank.Bank;
import com.acheron.exceptions.NegValueException;
import com.acheron.exceptions.ValueExceededException;

class BankTest {

	Bank bank = null;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		bank = new Bank(10000);
	}
	

	@AfterEach
	void tearDown() throws Exception {
		bank = null;
	}

	@Test
	@DisplayName("positive values for deposit")
	void testPosDeposit() throws NegValueException, ValueExceededException {
		assertEquals(12000, bank.deposit(2000), "Expecting 12000");
	}
	@Test
	@DisplayName("negative values for deposit")
	void testNegDeposit()  {
		assertThrows(NegValueException.class,()->bank.deposit(-2000));
	}

	@Test
	@DisplayName("exceeded values for deposit")
	void testExceedDeposit() {
		assertThrows(ValueExceededException.class,()->bank.deposit(28000));
	}
	
	

	@Test
	@DisplayName("positive values for withdraw")
	void testPosWithDraw() throws NegValueException, ValueExceededException  {
		assertEquals(3000, bank.withDraw(7000), "Expecting 3000");
	}
	@Test
	@DisplayName("negative values for deposit")
	void testNegWithDraw()  {
		assertThrows(NegValueException.class,()->bank.withDraw(-2000));
	}

	@Test
	@DisplayName("exceeded values for deposit")
	void testExceedWithDraw()  {
		assertThrows(ValueExceededException.class,()->bank.withDraw(3000));
	}
	
	@Test
	@DisplayName("amount greater than balance")
	void testGreaterAmountWithDraw()  {
		assertThrows(ValueExceededException.class,()->bank.withDraw(13000));
	}
	
	
	
	
	
	
	
}
