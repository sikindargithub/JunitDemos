package com.mobileapp.testcases;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.mobileapp.exceptions.MobileNotFoundException;
import com.mobileapp.model.Mobile;
import com.mobileapp.service.IMobileService;
import com.mobileapp.service.MobileServiceImpl;

class MobileTests {
	
	IMobileService mobileService;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	List<Mobile> mobileByBrand = null;
	@BeforeEach
	void setUp() throws Exception {
		mobileService = new MobileServiceImpl();
		mobileByBrand =Arrays.asList(new Mobile(1234, "Samsung", "Note10s", 15687.23),
				new Mobile(5674, "Samsung", "SG198", 18654.96), 
				new Mobile(9842, "Samsung", "V146", 20389.23));
			
	}

	@AfterEach
	void tearDown() throws Exception {
		mobileService  = null;
	}

	@Test
	@DisplayName("Testing Id available")
	void testGetById() throws MobileNotFoundException {
		Mobile mobile = mobileService.getById(1234);
		assertNotNull(mobile);
	}
	
	@Test
	@DisplayName("Testing Id not available")
	void testGetByInvalidId() throws MobileNotFoundException  {
		assertThrows(MobileNotFoundException.class,()->mobileService.getById(10));
	}
	
	@Test
	@DisplayName("Testing same object")
	void testGetByIdEquals() throws MobileNotFoundException {
		Mobile mobile1 = new Mobile(1234, "Redmi", "Note10s", 15687.23);
		Mobile mobile = mobileService.getById(1234);
		assertEquals(mobile1.toString(),mobile.toString());
	}
	
	@Test
	@DisplayName("Testing brand available")
	void testGetByBrand() throws MobileNotFoundException {
		List<Mobile> mobileListByBrand = mobileService.getByBrand("Oppo");
		assertNotNull(mobileListByBrand);
	}
	
	@Test
	@DisplayName("Testing brand not available")
	void testGetByInvalidBrand() throws MobileNotFoundException  {
		assertThrows(MobileNotFoundException.class,()->mobileService.getByBrand("htc"));
	}
	
	
	
	
	
	
	
	
	
	

}
