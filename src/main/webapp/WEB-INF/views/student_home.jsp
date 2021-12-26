<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>

html { 
    background: url(main-header-image.jpg) no-repeat center center fixed; 
    -webkit-background-size: cover;
    -moz-background-size: cover;
    -o-background-size: cover;
    background-size: cover;
  }
body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  display: block;
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
  background-color: #04AA6D;
  color: white;
}

.topnav .icon {
  display: none;
}

@media screen and (max-width: 600px) {
  .topnav a:not(:first-child) {display: none;}
  .topnav a.icon {
    float: right;
    display: block;
  }
}

@media screen and (max-width: 600px) {
  .topnav.responsive {position: relative;}
  .topnav.responsive .icon {
    position: absolute;
    right: 0;
    top: 0;
  }
  .topnav.responsive a {
    float: none;
    display: block;
    text-align: left;
  }
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
    left: 1200px;
  }
  * {
    box-sizing: border-box;
  }
  
  .row {
    display: flex;
  }
  
  /* Create two equal columns that sits next to each other */
  .column {
      margin: 35px;
      margin-top: 30px;
    flex: 30%;
    padding: 20px;
    background-color: rgba(0, 0, 0, 0.2);
    
     /* Should be removed. Only for demonstration */
  }</style>

</head>
<!-- <body background="images.jpeg"> -->
<body></body>
<div class="topnav" id="myTopnav">
  <a href="#home" class="active">Student Home</a>
  <a href="uploadpaper">Add publication</a>
  <a href="prev_publicationcopy">Previous publications</a>
  <a href="filterpublication2">Filtering publication</a>
  <a href="connect">Connect with a faculty</a>
  
  <a href="student_profile">Student profile</a>
  
  <a href="todo">TO-DO list</a>
  <a href="reset_password">Update password</a>
  <a href="home" style="left: 60px; position: relative;">   Logout</a>
  <a href="javascript:void(0);" class="icon" onclick="myFunction()">
    <i class="fa fa-bars"></i>
  </a>
</div>
<img src="images/october-2021-calendar-printable.png" alt="calender" style="top:20px;height: 350px;width: 600px;position: relative;left: 830px;">
<div class="row">
    <div class="column" style="top:0px;position: relative;text-align: center;text-shadow: 0.7px 0.7px;">
      <h2>Success is the sum of small efforsts repeated day in and day out</h2>
    </div>
    <div class="column" style="top:30px;width: 10px; position: relative; margin-left: 10px;text-align: center;">
      
    </div>
  </div>
<script>
function myFunction() {
  var x = document.getElementById("myTopnav");
  if (x.className === "topnav") {
    x.className += " responsive";
  } else {
    x.className = "topnav";
  }
}
</script>

</body>
</html>
