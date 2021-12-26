<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>    
<html>
<body style="background-color: rgba(43, 226, 217, 0.822);">
<head>    
<meta name="viewport" content="width=device-width, initial-scale=1">    
<style>    
* {    
  box-sizing: border-box;    
}    
    
input[type=text], select, textarea {    
  width: 100%;    
  padding: 12px;    
  border: 5px solid rgb(49, 231, 32);    
  border-radius: 4px;    
  resize: vertical;    
}    
    
label {    
  padding: 12px 12px 12px 0;    
  display: inline-block;    
}    



input[type=submit] {    
  background-color: rgb(30, 94, 214);    
  color: white;    
  padding: 12px 20px;    
  border: none;    
  border-radius: 4px;    
  cursor: pointer;    
  float: right;    
}    
    
</style>    
</head>    
<body>    
<h2>FEED BACK FORM</h2>    
<div class="container">    
  <form method="post">    
    <div class="row">    
      <div class="col-25">
        <div style="background-color: #cfc ; padding: 10px; border: 1px solid green;">
        <label for="feed_back">Enter your feedback in the below box:</label>    
      </div>    
      <div class="col-75">    
        <textarea id="subject" name="subject" placeholder="Input Your feedback here ..." style="height:200px"></textarea>    
      </div>    
    </div>    
    <div class="row">    
      <input type="submit" value="Submit">
    </div>   
    </div>    
  </form>    
</div>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%
String id = request.getParameter("userId");
String driverName = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String dbName = "sys";
String userId = "root";
String password = "root";

try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<h1 align="center"><font><strong>PREVIOUS FEEDBACK</strong></font></h1>
<table align="center" cellpadding="5" width="50%" cellspacing="5" border="1">
<tr>

</tr>
<tr bgcolor="green" color="white">
<td><b>id</b></td>

<td><b>feedback</b></td>
</tr>
<%
try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();
String sql ="SELECT * FROM feedback";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr bgcolor="#DEB887">

<td color="white"><%=resultSet.getString("feed_id") %></td>
<td><%=resultSet.getString("feed") %></td>



</tr>

<% 
}

} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
    
</body>    
</html>