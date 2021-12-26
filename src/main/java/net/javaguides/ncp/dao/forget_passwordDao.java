package net.javaguides.ncp.dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

import net.javaguides.ncp.model.forget_password;

public class forget_passwordDao {

    public int registerEmployee(forget_password employee) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO user" +
            "  (email_id, password) VALUES " +
            " (?, ?);";

        

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/sys?allowPublicKeyRetrieval=true&useSSL=false","root","root")){

          
        		java.sql.Statement st = connection.createStatement();
        		String em = employee.getEmail();
        		String vv = employee.getValue();
        		if (em=="" | vv=="") {
        			return 1;
        		}
        		else {
        		String sql = ("SELECT * FROM user WHERE user.email_id = ?");
        		PreparedStatement pp = connection.prepareStatement(sql);
        		pp.setString(1,em);
        	ResultSet rs = pp.executeQuery();
        	
            // Step 3: Execute the query or update query\
        		
        		System.out.println(employee.getEmail());
        		System.out.println(vv);
        		System.out.println(rs.first());
        		String vv2=rs.getString("security_ans");
        		System.out.println(vv2);
        		//System.out.println(rs.equals(vv));
        	
        		if (vv2.equals(vv)) {
        			//alert
        			//System.out.println(rs.getString(1));
        			return 0;
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