package net.javaguides.ncp.dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

import net.javaguides.ncp.model.reset_password;

public class reset_passwordDao {

    public int registerEmployee(reset_password employee) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/sys?useSSL=false", "root", "root")){

            // Step 2:Create a statement using connection object
        		java.sql.Statement st = connection.createStatement();
        		String em = employee.getPassword();
        		String vv = employee.getReset();
        		String emm = employee.getEmail();
        		
        		
        		System.out.println(emm);
        		
        		if (em=="" | vv=="" | emm=="") {
        			return 1;
        		}
        		else {
//        			System.out.println(em);
        			System.out.println(emm);
        			System.out.println(vv);

        			
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