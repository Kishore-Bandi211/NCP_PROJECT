package net.javaguides.ncp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.javaguides.ncp.model.todo;
import net.javaguides.ncp.model.upload_paper;

public class todoDao {
	

	 public int registerEmployee(todo td) throws ClassNotFoundException {
			

	    	String INSERT_paper_SQL = "INSERT INTO todo" +
	                "  (value,todo_id) VALUES " +
	                " (?,?);";
	        int result = 0;
	        
	        String value = td.getTd();
	        
	        String email = td.getEmailId();


	        Class.forName("com.mysql.jdbc.Driver");

	        try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/sys?allowPublicKeyRetrieval=true&useSSL=false","root","root");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_paper_SQL)) {
	           
	            preparedStatement.setString(1, value);
	            preparedStatement.setString(2, email);
	            


	            
	            System.out.println(preparedStatement);
	            
	            result = preparedStatement.executeUpdate();
	            
	            
	        } catch (SQLException e) {
	 
	            printSQLException(e);
	        }
	        return result;
	 }

	    private void printSQLException(SQLException ex) {
	        for (Throwable e: ex) {
	            if (e instanceof SQLException) {
	                e.printStackTrace(System.err);
	                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	                System.err.println("Message: " + e.getMessage());
	                Throwable t = ex.getCause();
	                while (t != null) {
	                    System.out.println("Cause: " + t);
	                    t = t.getCause();
	                }
	            }}}}
	        


