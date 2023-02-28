package com.bookapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookapp.model.Book;
import com.bookapp.util.AllQueries;
import org.springframework.stereotype.Component;

@Component
public class BookDaoImpl implements IBookDao {

	private static Connection connection;
	@Override
	public void addBook(Book book) {
		connection = ConnectionUtil.openConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(AllQueries.INSERTQUERY);
			preparedStatement.setInt(1, book.getBookId());
			preparedStatement.setString(2, book.getTitle());
			preparedStatement.setString(3, book.getAuthor());
			preparedStatement.setString(4, book.getCategory());
			preparedStatement.setDouble(5, book.getPrice());
			preparedStatement.execute();
			System.out.println("Added successfully");
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
	}

	@Override
	public void updateBook(int bookId, double price) {
		connection = ConnectionUtil.openConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(AllQueries.UPDATEQUERY);
			preparedStatement.setDouble(1, price);
			preparedStatement.setDouble(2, bookId);
			preparedStatement.executeUpdate();
			System.out.println("Updated successfully");
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
				
	}

	@Override
	public void deleteBook(int bookId) {
		connection = ConnectionUtil.openConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(AllQueries.DELETEQUERY);
			preparedStatement.setDouble(1, bookId);
			preparedStatement.execute();
			System.out.println("Deleted successfully");
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
	}

	@Override
	public Book findById(int bookId) {
		connection = ConnectionUtil.openConnection();
		PreparedStatement preparedStatement = null;
		Book book = null;
		try {
			preparedStatement = connection.prepareStatement(AllQueries.IDQUERY);
			preparedStatement.setInt(1, bookId);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				String title = rs.getString("title");
				String author = rs.getString("author");
				String category = rs.getString("category");
				double price = rs.getDouble("price");
				book = new Book(bookId,title,author,category,price);
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
		return book;
	}

	@Override
	public List<Book> findAll() {
		connection = ConnectionUtil.openConnection();
		PreparedStatement preparedStatement = null;
		List<Book> bookList = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(AllQueries.SELECTQUERY);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				String title = rs.getString("title");
				String author = rs.getString("author");
				String category = rs.getString("category");
				Double price = rs.getDouble("price");
				int bookId = rs.getInt("bookId");
				Book book = new Book(bookId,title,author,category,price);
				bookList.add(book);
				
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
		return bookList;
	}

	@Override
	public List<Book> findByAuthor(String author) {
		connection = ConnectionUtil.openConnection();
		PreparedStatement preparedStatement = null;
		List<Book> bookListByAuthor = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(AllQueries.AUHTORQUERY);
			preparedStatement.setString(1, author);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				String title = rs.getString("title");
				String category = rs.getString("category");
				Double price = rs.getDouble("price");
				int bookId = rs.getInt("bookId");
				Book book = new Book(bookId,title,author,category,price);
				 bookListByAuthor.add(book);
				
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
		return  bookListByAuthor ;
	}

	@Override
	public List<Book> findByCategory(String category) {
		connection = ConnectionUtil.openConnection();
		PreparedStatement preparedStatement = null;
		List<Book> bookListByCategory= new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(AllQueries.CATEGORYQUERY);
			preparedStatement.setString(1, category);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				String title = rs.getString("title");
				String author = rs.getString("author");
				Double price = rs.getDouble("price");
				int bookId = rs.getInt("bookId");
				Book book = new Book(bookId,title,author,category,price);
				bookListByCategory.add(book);
				
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
		return  bookListByCategory ;
	}

	@Override
	public List<Book> findByLesserPrice(double price) {
		connection = ConnectionUtil.openConnection();
		PreparedStatement preparedStatement = null;
		List<Book> bookListByPrice= new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(AllQueries.PRICEQUERY);
			preparedStatement.setDouble(1,price);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				String title = rs.getString("title");
				String author = rs.getString("author");
				String category = rs.getString("category");
				int bookId = rs.getInt("bookId");
				Double nprice = rs.getDouble("price");
				Book book = new Book(bookId,title,author,category,nprice);
				bookListByPrice.add(book);
				
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
		return  bookListByPrice ;
	}

}
