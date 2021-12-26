<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@page import="net.javaguides.ncp.model.*"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
    
    
    body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}
#filter {
  text-align: center;
  text-transform: uppercase;
  color: #4caf50;
  letter-spacing: 3px;
  background-color: #ccc;
  padding: 20px;
  font-size: 30px;
}

.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: #04aa6d;
  color: white;
}

.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  max-width: 500px;
  margin: auto;
  text-align: center;
  font-family: arial;
  width: 500px;
  height: auto;
}

.price {
  color: grey;
  font-size: 22px;
}

.card button {
  border: none;
  outline: 0;
  padding: 12px;
  color: white;
  background-color: #000;
  text-align: center;
  cursor: pointer;
  width: 100%;
  font-size: 18px;
}
input[type="submit"]{
 border: none;
  outline: 0;
  padding: 12px;
  color: white;
  background-color: #000;
  text-align: center;
  cursor: pointer;
  width: 100%;
  font-size: 18px;}

.card button:hover {
  opacity: 0.7;
}

input[type="number"] {
  border-radius: 2px;
  border-color: #ddd;
}
    
    </style>
</head>
<body>
    <div class="topnav">
        <a class="active" href="#home">Home</a>
        <a href="#news">News</a>
        <a href="#contact">Contact</a>
        <a href="#about">About</a>
    </div>
    
    <h2 id="filter"> GRACE MARKS ALLOCATION</h2>


    <div class="card">
    
      <% 
      upload_paper pdts = (upload_paper) request.getSession().getAttribute("student");
      System.out.println(pdts);

      if (request.getSession().getAttribute("student") != null) { %>
              
                    <form action="marks_formServlet" method="post">
                    
                   
                    <h1 name="student_name" ><%=pdts.getStudent_name() %></h1>
        <p class="title" name="roll_number"><%=pdts.getRoll_number() %></p>
        <p name="title_paper" id="title_paper"> <%=pdts.getTitle() %></p>
        <h3>Marks Alloted: <span id="marks"><%=pdts.getGrace_marks() %></span></h3>
        <label for="Marks"> Assign marks: </label>
        <input type="number" name="grace-marks" id="grace-marks" >
                <input type="hidden" value=<%=pdts.getTitle() %> name="title_paper" id="title_paper" >
        <hr>
        
        <input type="submit" style="letter-spacing: 2px;font-weight: bold;" value="ASSIGN MARK">
    
                   
                </form>
                <% } %>
       
    </div>
</body>
</html>


 


