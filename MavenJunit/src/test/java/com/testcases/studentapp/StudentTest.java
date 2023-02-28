package com.testcases.studentapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.acheron.exceptions.ExceedingNumException;
import com.acheron.exceptions.InvalidNumberException;
import com.acheron.exceptions.NegValueException;
import com.acheron.training.Student;

class StudentTest {

	Student student = null;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		student  = new Student();
	}

	@AfterEach
	void tearDown() throws Exception {
		student = null;
	}
	

	@Test
	@DisplayName("Testing positive values")
	void testPosTotalMarks() throws NegValueException, ExceedingNumException{
		
		assertEquals(260, student.totalMarks(80,90,90), "values do not match - expected 260");
	}

	@Test
	@DisplayName("Testing negative values")
	void testNegTotalMarks() {
		
		assertThrows(NegValueException.class,()->student.totalMarks(-90, 87, 67));
		
	}
	
	

	@Test
	@DisplayName("Testing greater than 100")
	void testGreaterTotalMarks() {
		
		assertThrows(ExceedingNumException.class,()->student.totalMarks(190, 87, 67));
		
	}
	@Test
	@DisplayName("Testing grade - A")
	void testGetGradeA() {
		int marks[] = {90,92,95};
		String grade = student.getGrade(marks);
		assertEquals("A",grade,"Expecting grade A");
	}
	@Test
	@DisplayName("Testing grade - B")
	void testGetGradeB() {
		int marks[] = {80,82,85};
		String grade = student.getGrade(marks);
		assertEquals("B",grade,"Expecting grade B");
	}
	@Test
	@DisplayName("Testing grade - C")
	void testGetGradeC() {
		int marks[] = {75,76,80};
		String grade = student.getGrade(marks);
		assertEquals("C",grade,"Expecting grade C");
	}
	@Test
	@DisplayName("Testing grade - D")
	void testGetGradeD() {
		int marks[] = {65,45,55};
		String grade = student.getGrade(marks);
		assertEquals("D",grade,"Expecting grade D");
	}
	@Test
	@DisplayName("Testing grade - Fail")
	void testGetGradeFail() {
		int marks[] = {20,25,35};
		String grade = student.getGrade(marks);
		assertEquals("Fail",grade,"Expecting grade F");
	}
	
	@Test
	@DisplayName("Testing negative grade value")
	void testGetGradeNeg() {
		int marks[] = {30,-40,-56};
		assertThrows(InvalidNumberException.class,()->student.getGrade(marks));
	}
	

	@Test
	@DisplayName("Testing exceeding grade value")
	void testGetGradeExceed() {
		int marks[] = {30,120,140};
		assertThrows(InvalidNumberException.class,()->student.getGrade(marks));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}