package net.javaguides.ncp.dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

import net.javaguides.ncp.model.fp_support;

public class fp_supportDao {

    public int registerEmployee(fp_support employee) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/sys?allowPublicKeyRetrieval=true&useSSL=false","root","root")){

            // Step 2:Create a statement using connection object
        		java.sql.Statement st = connection.createStatement();
        		String em = employee.getPassword();
        		String vv = employee.getReenter();
        		String emm = employee.getEmail();
        		
        		
        		System.out.println(emm);
        		
        		if (em=="" | vv=="") {
        			return 1;
        		}
        		else {
        				if (em.equals(vv)) {
        					
        					String sql = ("UPDATE user set password = ? WHERE email_id = ?");
        					PreparedStatement pp = connection.prepareStatement(sql);
        					pp.setString(1,em);
        					pp.setString(2, emm);
        					int rs = pp.executeUpdate();
        					return 0; 
        				}
        				else {
        					return 1;
        				}
        		}	
        	
        }
         catch (SQLException e) {
 
            printSQLException(e);
        }
       return 1;  
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