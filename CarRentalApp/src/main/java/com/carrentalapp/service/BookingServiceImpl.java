package com.carrentalapp.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import com.carrentalapp.dao.BookingDaoImpl;
import com.carrentalapp.dao.IBookingDao;
import com.carrentalapp.exceptions.CustomerNotFoundException;
import com.carrentalapp.model.Booking;

public class BookingServiceImpl implements IBookingService {

	IBookingDao customerDao = new BookingDaoImpl();
	public void rentCar(Booking bookingCar,int carNumber) {
		customerDao.rentCar(bookingCar,carNumber);
		
	}

	public Booking getById(int bookingId) throws CustomerNotFoundException {
		Booking bookedCar =  customerDao.findById(bookingId);
		if(bookedCar == null)
			throw new CustomerNotFoundException("The customer with "+bookingId+" is not available...");
		return bookedCar;
		
	}

	public List<Booking> getByDate(LocalDate date) throws CustomerNotFoundException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY-MM-dd");
		String strDate = dtf.format(date);
		Date date1 = Date.valueOf(strDate);
		
		List<Booking> bookedCarsByDate = customerDao.findByDate(date1);
		if(bookedCarsByDate.isEmpty())
			throw new CustomerNotFoundException("The customers list by "+ date+" is not available ");
		return bookedCarsByDate.stream().sorted((o1,o2)->o1.getDate().compareTo(o2.getDate())).collect(Collectors.toList());
				
	}

	public List<Booking> getByIsPaymentDone(boolean isPaymentDone) throws CustomerNotFoundException {
		List<Booking> bookedCarsByPayment = customerDao.findByIsPaymentDone(isPaymentDone);
		if(bookedCarsByPayment.isEmpty())
			throw new CustomerNotFoundException("The customers list by "+ isPaymentDone+" is not available ");
		return bookedCarsByPayment.stream().sorted((o1,o2)->o1.getName().compareTo(o2.getName())).collect(Collectors.toList()) ;
	}

}
