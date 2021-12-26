package net.javaguides.ncp.dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

import net.javaguides.ncp.model.user;

public class userDao {

    public int registerEmployee(user employee) throws ClassNotFoundException {
        

        

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/sys?allowPublicKeyRetrieval=true&useSSL=false","root","root")){

            // Step 2:Create a statement using connection object
        		java.sql.Statement st = connection.createStatement();
        		String em = employee.getEmail();
        		String ps = employee.getPassword();
        		if (em=="" | ps=="") {
        			return 1;
        		}
        		else {
        		String sql = ("SELECT * FROM user WHERE user.email_id = ? AND user.password = ?");
        		PreparedStatement pp = connection.prepareStatement(sql);
        		pp.setString(1,em);
        		pp.setString(2, ps);
        	ResultSet rs = pp.executeQuery();
        	
            // Step 3: Execute the query or update query\
        		
        		
        		//System.out.println(employee.getPassword());
        		//System.out.println(rs.next());
        		
        		if (rs.next()) {
        			//alert
        			rs.first();
                	Integer h=rs.getInt("Faculty");
                	System.out.println(h);
        			if(h==1) return 0;
        			else return 1;
        		}
        		else {
        			//redirect 
        			System.out.print(false);
        			return 1;
        		}
            
        }}
         catch (SQLException e) {
 
            printSQLException(e);
        }
       return 0;  
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
            }
        }
    }
}