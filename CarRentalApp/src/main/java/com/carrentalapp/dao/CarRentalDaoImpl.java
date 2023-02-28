package com.carrentalapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.carrentalapp.exceptions.CarNotFoundException;
import com.carrentalapp.model.Car;
import com.carrentalapp.util.AllQueries;

public class CarRentalDaoImpl implements ICarRentalDao {
	
	private static Connection connection = null;

	public void addCar(Car car) {
		connection = ConnectionUtil.openConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(AllQueries.ADDCARQUERY);
			preparedStatement.setInt(1, car.getCarNumber());
			preparedStatement.setString(2, car.getBrand());
			preparedStatement.setString(3, car.getModel());
			preparedStatement.setInt(4, car.getMileage());
			preparedStatement.setInt(5, car.getNoOfSeats());
			preparedStatement.setDouble(6, car.getPricePerHour());
			
			boolean val = preparedStatement.execute();
			if(!val)
				System.out.println("Inserted successfully..");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(preparedStatement != null)
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			ConnectionUtil.closeConnection();
		}
		
	}

	public boolean deleteCar(int carNumber) {
		connection = ConnectionUtil.openConnection();
		PreparedStatement preparedStatement = null;
		int val = 0;
		try {
			preparedStatement = connection.prepareStatement(AllQueries.DELETECARQUERY);
			preparedStatement.setInt(1, carNumber);
			 val = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			finally {
				
					try {
						if(preparedStatement!=null)
						preparedStatement.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					ConnectionUtil.closeConnection();
			}
		if(val==1)
			return true;
		else
			return false;
				
	}

	public boolean updateCar(int carNumber, double pricePerHour) {
		connection = ConnectionUtil.openConnection();
		PreparedStatement preparedStatement = null;
		int val = 0;
		try {
			preparedStatement = connection.prepareStatement(AllQueries.UPDATECARQUERY);
			preparedStatement.setDouble(1, pricePerHour);
			preparedStatement.setInt(2, carNumber);
			 val = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			finally {
				
					try {
						if(preparedStatement!=null)
						preparedStatement.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					ConnectionUtil.closeConnection();
			}
		if(val==1)
			return true;
		else
			return false;
	}

	public List<Car> findAllCars() {
		connection = ConnectionUtil.openConnection();
		PreparedStatement preparedStatement = null;
		List<Car> carList = new ArrayList<Car>();
		try {
			preparedStatement = connection.prepareStatement(AllQueries.ALLCARSQUERY);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				Integer carNumber = rs.getInt("carNumber");
				String brand = rs.getString("brand");
				String model = rs.getString("model");
				int mileage = rs.getInt("mileage");
				int noOfSeats = rs.getInt("noOfSeats");
				double pricePerHour = rs.getDouble("pricePerHour");
				
				Car car = new Car(carNumber,brand,model,mileage,noOfSeats,pricePerHour);
				carList.add(car);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			finally {
				
					try {
						if(preparedStatement!=null)
						preparedStatement.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					ConnectionUtil.closeConnection();
			}		
		return  carList ;
		
	}

	public List<Car> findByBrandAndSeats(String brand, int noOfSeats) {
		connection = ConnectionUtil.openConnection();
		PreparedStatement preparedStatement = null;
		List<Car> carsByBrandAndSeats = new ArrayList<Car>();
		try {
			preparedStatement = connection.prepareStatement(AllQueries.BRANDANDSEATSQUERY);
			preparedStatement.setString(1,brand);
			preparedStatement.setInt(2,noOfSeats);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				Integer carNumber = rs.getInt("carNumber");
				String model = rs.getString("model");
				int mileage = rs.getInt("mileage");
				double pricePerHour = rs.getDouble("pricePerHour");
				
				Car car = new Car(carNumber,brand,model,mileage,noOfSeats,pricePerHour);
				carsByBrandAndSeats.add(car);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			finally {
				
					try {
						if(preparedStatement!=null)
						preparedStatement.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					ConnectionUtil.closeConnection();
			}		
		return carsByBrandAndSeats;
		
	}

	public List<Car> findByMileage(int mileage) {
		connection = ConnectionUtil.openConnection();
		PreparedStatement preparedStatement = null;
		List<Car> carsByMileage = new ArrayList<Car>();
		try {
			preparedStatement = connection.prepareStatement(AllQueries.MILEAGEQUERY);
			preparedStatement.setInt(1,mileage);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				int carNumber = rs.getInt("carNumber");
				String brand = rs.getString("brand");
				String model = rs.getString("model");
				int noOfSeats = rs.getInt("noOfSeats");
				double pricePerHour = rs.getDouble("pricePerHour");
				
				Car car = new Car(carNumber,brand,model,mileage,noOfSeats,pricePerHour);
				carsByMileage.add(car);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			finally {
				
					try {
						if(preparedStatement!=null)
						preparedStatement.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					ConnectionUtil.closeConnection();
			}		
		return carsByMileage;
		
	}

	public List<Car> findByPricePerHour(double pricePerHour) {
		
		connection = ConnectionUtil.openConnection();
		PreparedStatement preparedStatement = null;
		List<Car> carsByPrice = new ArrayList<Car>();
		try {
			preparedStatement = connection.prepareStatement(AllQueries.PRICEQUERY);
			preparedStatement.setDouble(1, pricePerHour);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				int carNumber = rs.getInt("carNumber");
				String brand = rs.getString("brand");
				String model = rs.getString("model");
				int mileage = rs.getInt("mileage");
				int noOfSeats = rs.getInt("noOfSeats");
				double pricePerHour1 = rs.getDouble("pricePerHour");
				
				Car car = new Car(carNumber,brand,model,mileage,noOfSeats,pricePerHour1);
				carsByPrice.add(car);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			finally {
				
					try {
						if(preparedStatement!=null)
						preparedStatement.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					ConnectionUtil.closeConnection();
			}		
		return carsByPrice;
		
	}

}
