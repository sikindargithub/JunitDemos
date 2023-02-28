package com.carrentalapp.service;

import java.time.LocalDate;
import java.util.List;

import com.carrentalapp.exceptions.CustomerNotFoundException;
import com.carrentalapp.model.Booking;

public interface IBookingService {

	//called by Admin
		void rentCar(Booking bookedCar,int carNumber);
		Booking getById(int bookingId) throws CustomerNotFoundException;
		List<Booking> getByDate(LocalDate date) throws CustomerNotFoundException;
		List<Booking> getByIsPaymentDone(boolean isPaymentDone) throws CustomerNotFoundException;
}
