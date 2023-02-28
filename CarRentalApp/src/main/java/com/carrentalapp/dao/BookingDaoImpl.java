package com.carrentalapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Timestamp;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.carrentalapp.model.Booking;
import com.carrentalapp.util.AllQueries;

public class BookingDaoImpl implements IBookingDao {

	private static Connection connection = null;

	public void rentCar(Booking bookingCar, int carNumber) {
		connection = ConnectionUtil.openConnection();
		PreparedStatement preparedStatement = null;
		double price = 0.0;
		double totalCost = 0.0;
		try {
			preparedStatement = connection.prepareStatement(AllQueries.TOTALCOSTQUERY);
			preparedStatement.setInt(1, carNumber);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
			price = rs.getDouble("pricePerHour");
			}
			int days = bookingCar.getNoOfDays();
			totalCost = price * days;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		try {
			preparedStatement = connection.prepareStatement(AllQueries.BOOKINGQUERY);
			preparedStatement.setInt(1, bookingCar.getBookingId());
			preparedStatement.setString(2, bookingCar.getName());
			preparedStatement.setString(3, bookingCar.getGender());
			LocalDate date = bookingCar.getDate();
			Date date1 = Date.valueOf(date);
			preparedStatement.setDate(4, date1);
			preparedStatement.setTime(5, bookingCar.getTime());
			preparedStatement.setLong(6, bookingCar.getPhoneNo());
			preparedStatement.setBoolean(7, bookingCar.isPaymentDone());
			preparedStatement.setInt(8, bookingCar.getNoOfDays());
			preparedStatement.setInt(9, carNumber);
			preparedStatement.setDouble(10, totalCost);
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionUtil.closeConnection();
		}
	}

	public Booking findById(int bookingId) {
		connection = ConnectionUtil.openConnection();
		PreparedStatement preparedStatement = null;
		Booking bookedCar = null;
		try {
			preparedStatement = connection.prepareStatement(AllQueries.IDQUERY);
			preparedStatement.setInt(1, bookingId);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				Date date = rs.getDate("date");
				Time time = rs.getTime("time");
				LocalDate date1 = date.toLocalDate();
				long phoneNo = rs.getLong("phoneNo");
				boolean isPaymentDone = rs.getBoolean("isPaymentDone");
				int noOfDays = rs.getInt("noOfDays");
				double totalCost = rs.getDouble("totalCost");
				int carNumber = rs.getInt("carNumber");
				bookedCar = new Booking(bookingId, name, gender, date1,time, phoneNo, isPaymentDone, noOfDays,
						totalCost,carNumber);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionUtil.closeConnection();
		}
		return bookedCar;
	}

	public List<Booking> findByDate(Date date) {
		connection = ConnectionUtil.openConnection();
		PreparedStatement preparedStatement = null;
		List<Booking> bookedCarsByDate = new ArrayList<Booking>();

		try {
			preparedStatement = connection.prepareStatement(AllQueries.DATEQUERY);
			preparedStatement.setDate(1, date);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				int bookingId = rs.getInt("bookingId");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				LocalDate date1 = date.toLocalDate();
				Time time = rs.getTime("time");
				long phoneNo = rs.getLong("phoneNo");
				boolean isPaymentDone = rs.getBoolean("isPaymentDone");
				int noOfDays = rs.getInt("noOfDays");
				double totalCost = rs.getDouble("totalCost");
				int carNumber = rs.getInt("carNumber");
				Booking bookedCar = new Booking(bookingId, name, gender, date1,time, phoneNo, isPaymentDone, noOfDays,
						totalCost,carNumber);
				bookedCarsByDate.add(bookedCar);
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionUtil.closeConnection();
		}
		return bookedCarsByDate;
	}

	public List<Booking> findByIsPaymentDone(boolean isPaymentDone) {
		connection = ConnectionUtil.openConnection();
		PreparedStatement preparedStatement = null;
		List<Booking> bookedCarsByPayment = new ArrayList<Booking>();
		try {
			preparedStatement = connection.prepareStatement(AllQueries.PAYMENTQUERY);
			preparedStatement.setBoolean(1, isPaymentDone);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int bookingId = rs.getInt("bookingId");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				Date date = rs.getDate("date");
				LocalDate date1 = date.toLocalDate();
				Time time = rs.getTime("time");
				long phoneNo = rs.getLong("phoneNo");
				int noOfDays = rs.getInt("noOfDays");
				double totalCost = rs.getDouble("totalCost");
				int carNumber = rs.getInt("carNumber");
				Booking bookedCar = new Booking(bookingId, name, gender, date1,time, phoneNo, isPaymentDone, noOfDays, totalCost,carNumber);
				bookedCarsByPayment.add(bookedCar);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionUtil.closeConnection();
		}
		return bookedCarsByPayment;
	}

}
