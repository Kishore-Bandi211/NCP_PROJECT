package net.javaguides.ncp.dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import net.javaguides.ncp.model.*;

public class publication_update {
    private String jdbcURL = "jdbc:mysql://localhost:3306/sys";
    private String jdbcUsername = "root";
    private String jdbcPassword = "root";
    
    
    private static final String SELECT_STUDENT_ID = "SELECT student_name,roll_number,title_paper,grace_marks FROM publication_details WHERE title_paper =?";

    protected Connection getConnection() {
    
            Connection connection = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            }catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            } 
            return connection;
        }

    public upload_paper selectStudent(String id) {
        upload_paper student = new upload_paper();
        try {
            Connection connection = getConnection();
            PreparedStatement prepStatement = connection.prepareStatement(SELECT_STUDENT_ID);
            prepStatement.setString(1, id);
            ResultSet rSet = prepStatement.executeQuery();
            while(rSet.next()) {
                String name = rSet.getString("student_name");
                String roll_number = rSet.getString("roll_number");
                String title_paper = rSet.getString("title_paper");
                int grace_marks = rSet.getInt("grace_marks");
                System.out.println("hello"+name); 
                student.setStudent_name(name);
                student.setRoll_number(roll_number);
                student.setTitle(title_paper);
                student.setGrace_marks(grace_marks);
                System.out.println("hello"+name);                
            }
        } catch (SQLException e) {
            e.printStackTrace();
            }
        return student;
    }
}