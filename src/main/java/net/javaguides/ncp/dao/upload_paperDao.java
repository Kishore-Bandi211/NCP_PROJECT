package net.javaguides.ncp.dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import net.javaguides.ncp.model.upload_paper;

public class upload_paperDao {

    public int registerEmployee(upload_paper paper) throws ClassNotFoundException {
    	String INSERT_paper_SQL = "INSERT INTO publication_details" +
                "  (publication_id,student_name,roll_number,faculty_name,title_paper,conference_details,submission_date,acceptance_date,link_publication,email) VALUES " +
                " (?,?,?,?,?,?,?,?,?,?);";
        int result = 0;
        String publication_id = paper.getPublicationId();
        String student_name = paper.getStudent_name();
        String roll_number = paper.getRoll_number();
        String faculty_name = paper.getFaculty_name();
        String title_paper = paper.getTitle();
        String conference_details = paper.getJournal();
        String submission_date = paper.getSubmission();
        String acceptance_date = paper.getAcceptance();
        String link_publication = paper.getLink();
        String email = paper.getEmail();
        
        


        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/sys?allowPublicKeyRetrieval=true&useSSL=false","root","root");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_paper_SQL)) {
           
            preparedStatement.setString(1, publication_id);
            preparedStatement.setString(2, student_name);
            preparedStatement.setString(3, roll_number);
            preparedStatement.setString(4, faculty_name);
            preparedStatement.setString(5, title_paper);
            preparedStatement.setString(6, conference_details);
            preparedStatement.setString(7, submission_date);
            preparedStatement.setString(8, acceptance_date);
            preparedStatement.setString(9, link_publication);
            preparedStatement.setString(10,email);


            
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
            }
        }
    }
}