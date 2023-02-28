package com.carrentalapp.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import com.carrentalapp.model.Booking;

public interface IBookingDao {
	
	//for knowing booking details of customer
			void rentCar(Booking bookingCar, int carNumber);
			Booking findById(int bookingId);
			List<Booking> findByDate(Date date);
			List<Booking> findByIsPaymentDone(boolean isPaymentDone);
}
