package net.javaguides.ncp.dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

import net.javaguides.ncp.model.connect_with_faculty;

public class connect_with_facultyDao {

    public int registerEmployee(connect_with_faculty employee) throws ClassNotFoundException {
        

        

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/sys?allowPublicKeyRetrieval=true&useSSL=false","root","root")){

            // Step 2:Create a statement using connection object
        		java.sql.Statement st = connection.createStatement();
        		String em = employee.getTop();
        		String sql = ("SELECT * FROM specialization_faculty WHERE topic = ?");
        		PreparedStatement pp = connection.prepareStatement(sql);
        		pp.setString(1,em);
        		ResultSet rs = pp.executeQuery();
        		System.out.println("Contents of the table");
        	      while(rs.next()) {
        	    	  Integer in = rs.getInt("id");
        	    	  String sql2= ("Select * from faculty Where faculty_id=?");
        	    	  PreparedStatement pp2 = connection.prepareStatement(sql2);
              		pp2.setInt(1,in);
              		ResultSet rs2 = pp2.executeQuery();
              		rs2.first();
              		//System.out.print("name: "+rs2.getString("email"));
              		String in2 = rs2.getString("email");
              		String sql3= ("select * from user where email_id= ?");
              		PreparedStatement pp3 = connection.prepareStatement(sql3);
              		pp3.setString(1,in2);
              		ResultSet rs3 = pp3.executeQuery();
              		 System.out.println(rs3.first());
        	         System.out.println("name: "+rs3.getString("name"));
        	         System.out.println("");
        	      }
        	System.out.println(em);	
        		
            
        }
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