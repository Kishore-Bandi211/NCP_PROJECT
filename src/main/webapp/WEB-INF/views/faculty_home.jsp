<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<style>
			html { 
    			background: url(images/ranger-4df6c1b6.png) no-repeat center center fixed; 
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
 			.column {
      			margin: 35px;
      			margin-top: 30px;
    			flex: 30%;
    			padding: 20px;
    			background-color: rgba(0, 0, 0, 0.2);    
  			}
  		</style>
	</head>
	<body>
		<div class="topnav" id="myTopnav">
  			<a href="#" class="active">Faculty Home</a>
  			<a href="form">Student progress</a>
  			<a href="prev_publication">Previous publications</a>
  			<a href="filterpublication3">Filtering publication</a>
  			<a href="grace_marks">Grace marks allocation</a>
  			<a href="faculty_profile">Faculty profile</a>
  			<a href="todo3">TO-DO list</a>
  			<a href="update_password">Update password</a>
  			<a href="home" style="left: 60px; position: relative;">   Logout</a>
  			<a href="javascript:void(0);" class="icon" onclick="myFunction()"><i class="fa fa-bars"></i></a>
		</div>
		<!-- <img src="images/october-2021-calendar-printable.png" alt="calender" style="top:20px;height: 350px;width: 600px;position: relative;left: 830px;">
		 --><div class="row">
    		<div class="column" style="top:0px;position: relative;text-align: center;text-shadow: 0.7px 0.7px;">
      			<h2>Teacher encourage minds to think, hands to create and hearts to love</h2>
    		</div>
    		<!-- <div class="column" style="top:30px;width: 10px; position: relative; margin-left: 10px;text-align: center;">
      			<h2 style="text-shadow: 0.5px 0.5px;;">Pending task list</h2>
      			<p>ML concepts </p>
      			<p>XXXX</p>
    		</div> -->
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
