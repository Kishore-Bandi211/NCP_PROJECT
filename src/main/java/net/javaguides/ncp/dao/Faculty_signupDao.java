package net.javaguides.ncp.dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

import net.javaguides.ncp.model.Faculty_signup;

public class Faculty_signupDao {

    public int registerEmployee(Faculty_signup employee) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO user" +
            "  (email_id,password,name,security_ans) VALUES " +
            " (?,?,?,?);";
        String INSERT_faculty_SQL = "INSERT INTO faculty" +
                "  (email) VALUES " +
                " (?);";
        int result = 0;
        String email= employee.getEmail();
        String name=employee.getName();
        String password = employee.getPassword();
        String security = employee.getSecurity();
        String reenter = employee.getReenter();
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
           
            Connection connection = DriverManager
                  .getConnection("jdbc:mysql://localhost:3306/sys?allowPublicKeyRetrieval=true&useSSL=false","root","root");
            java.sql.Statement stmt = connection.createStatement();
            String em = employee.getEmail();
       	String sql = ("SELECT * FROM user WHERE user.email_id = ?");
   		PreparedStatement pp = connection.prepareStatement(sql);
    		pp.setString(1,em);
    		
    	ResultSet rs = pp.executeQuery();
            if(password.equals(reenter) ) {
            	if(! rs.first()) {
                stmt.executeUpdate("insert into user (name,password,email_id,security_ans,Faculty)values('"+name+"','"+password+"','"+email+"','"+security+"',1) ");
            }
            	else {
            		return 10;
            	}
            }
            else {
            	return 11;
            }
                stmt.executeUpdate("insert into faculty (email)values('"+email+"') ");
                
               
                
                
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