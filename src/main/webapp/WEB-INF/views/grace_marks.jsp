<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="java.util.List"%>
<%@page import="net.javaguides.ncp.model.*"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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

#searchbar {
  background-color: #ddd;
}

.select-items div:hover,
.same-as-selected {
  background-color: rgba(0, 0, 0, 0.1);
}

input[type="text"] {
  width: 50%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-left: 200px;
  border-color: #ddd;
}
button[type="submit"] {
  width: 10%;
  background-color: #4caf50;
  color: white;
  padding: 14px 20px;
  margin: 8px 10px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: medium;
}

.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  max-width: 600px;
  margin: auto;
  text-align: center;
  font-family: arial;
}

.card .title {
  color: grey;
  font-size: 18px;
}

.card button {
  border: none;
  outline: 0;
  display: inline-block;
  padding: 8px;
  color: white;
  background-color: #000;
  text-align: center;
  cursor: pointer;
  width: 100%;
  font-size: 18px;
}

.card a {
  text-decoration: none;
  font-size: 22px;
  color: black;
}

.card button:hover,
.card a:hover {
  opacity: 0.7;
}

* {
  box-sizing: border-box;
}

body {
  font-family: Arial, Helvetica, sans-serif;
}

/* Float four columns side by side */
.column {
  float: left;
  width: 50%;
  padding: 0 10px;
}

/* Remove extra left and right margins, due to padding */
.row {
  margin: 0 -5px;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

/* Responsive columns */
@media screen and (max-width: 600px) {
  .column {
    width: 100%;
    display: block;
    margin-bottom: 20px;
  }
}

/* Style the counter cards */
.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  padding: 16px;
  text-align: center;
  background-color: #f1f1f1;
  margin: 15px;
}

#papers {
  margin-top: 20px;
  margin-bottom: 20px;
}
.button {
  background-color: #555555; /* Green */
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  top:10px;
  position: relative;
  left: 1300px;
}</style>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>


    <!-- <div class="topnav">
        <a class="active" href="#home">Home</a>
        <a href="#news">News</a>
        <a href="#contact">Contact</a>
        <a href="#about">About</a>
    </div> -->
    <a href="faculty_home"><button type="button" class="button">Home</button>
    <h2 id="filter"> GRACE MARKS ALLOCATION</h2>
    <div id="searchbar">


        
       


        <hr>


        <div id="papers">
            <div class="row">
                

                <%
  List<grace_marks_list> pdts = (List<grace_marks_list>) request.getAttribute("list");
  if(pdts!=null){
    for(grace_marks_list prod: pdts){
       %>
       <div class="column">
                    <div class="card">
                        
                        <h2>Student Name: <%= prod.getStudent_name() %></h2>
                        <p class="title">Roll Number: <%= prod.getRoll_number() %></p>
                        <p>Title of the paper: <%= prod.getTitle_paper() %></p>
                        <% 
                        if(prod.getGrace_marks()!=0){
                        	%>
                        	 <h3>Marks Alloted: <span id="marks"> <%= prod.getGrace_marks() %></span></h3>
                        	 <%
                        	 String k = "edit";
                        }
                        	 else{
                        		 %>
                        		 <h3>Marks Alloted: <span id="marks">N/A </span></h3>
                        		 <a href="grace_marks?id=<%=prod.getTitle_paper()%>&key=1" >Evaluate </a>
                        		 <br><br>
           
                        		 <%
                        	 }
                        	
                        	 
                        
                        %>
                        
                        <a href=<%= prod.getLink_publication() %> ><button>View Paper </button></a>
                        
                    </div>
                </div>
       
       <%
     }
  }
%>
                
               

               
            </div>


        </div>
    </div>
    <script src="./menu.js">

    </script>

</body>

</html>