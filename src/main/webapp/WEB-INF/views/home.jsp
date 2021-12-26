<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html> 
	<head>
		<title> Home Page </title>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<style>
			* {
  				margin: 0;
  				padding: 0;
  				color: white;
			}
			.topnav {
  				background-color: #333;
  				overflow: hidden;
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
			.active {
  				background-color: #04AA6D;
  				color: white;
			}
			.topnav .icon {
  				display: none;
			}
			.dropdown {
  				float: left;
  				overflow: hidden;
			}
			.dropdown .dropbtn {
  				font-size: 17px;
  				border: none;
  				outline: none;
  				color: white;
  				padding: 14px 16px;
  				background-color: inherit;
  				font-family: inherit;
  				margin: 0;
			}
			.dropdown-content {
  				display: none;
  				position: absolute;
  				background-color: #f9f9f9;
  				min-width: 160px;
  				box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  				z-index: 1;
			}
			.dropdown-content a {
  				float: none;
  				color: black;
  				padding: 12px 16px;
  				text-decoration: none;
  				display: block;
  				text-align: left;
			}
			.topnav a:hover, .dropdown:hover .dropbtn {
  				background-color: #555;
  				color: white;
			}
			.dropdown-content a:hover {
  				background-color: #ddd;
  				color: black;
			}
			.dropdown:hover .dropdown-content {
  				display: block;
			}
			@media screen and (max-width: 600px) {
  				.topnav a:not(:first-child), .dropdown .dropbtn {
    				display: none;
  				}
  				.topnav a.icon {
    			float: right;
    			display: block;
  				}
			}
			@media screen and (max-width: 600px) {
  				.topnav.responsive {position: relative;}
  				.topnav.responsive a.icon {
    				position: absolute;
    				right: 0;
    				top: 0;
  				}
  				.topnav.responsive a {
    				float: none;
    				display: block;
    				text-align: left;
  				}
  				.topnav.responsive .dropdown {float: none;}
  				.topnav.responsive .dropdown-content {position: relative;}
  				.topnav.responsive .dropdown .dropbtn {
    				display: block;
    				width: 100%;
    				text-align: left;
 				}
			}
			html { 
  				background: url("images/college-hall-spires-pacific.jpeg") no-repeat center center fixed; 
  				-webkit-background-size: cover;
  				-moz-background-size: cover;
  				-o-background-size: cover;
  				background-size: cover;
			}
			.site-footer{
  				background-color:#26272b;
  				padding:45px 0 20px;
  				font-size:15px;
  				line-height:24px;
  				color:#737373;
			}
			.site-footer hr{
  				border-top-color:#bbb;
  				opacity:0.5
			}
			.site-footer hr.small{
  				margin:20px 0
			}
			.site-footer h6{
  				color:#fff;
  				font-size:16px;
  				text-transform:uppercase;
  				margin-top:5px;
  				letter-spacing:2px
			}
			.site-footer a{
  				color:#737373;
			}
			.site-footer a:hover{
  				color:#3366cc;
  				text-decoration:none;
			}
			.footer-links{
  				padding-left:0;
  				list-style:none
			}
			.footer-links li{
  				display:block
			}
			.footer-links a{
  				color:#737373
			}
			.footer-links a:active,.footer-links a:focus,.footer-links a:hover{
  				color:#3366cc;
  				text-decoration:none;
			}
			.footer-links.inline li{
  				display:inline-block
			}
			.site-footer .social-icons{
  				text-align:right
			}
			.site-footer .social-icons a{
 	 			width:40px;
  				height:40px;
  				line-height:40px;
  				margin-left:6px;
  				margin-right:0;
  				border-radius:100%;
  				background-color:#33353d
			}
		.copyright-text{
  			margin:0
		}
		@media (max-width:991px){
  			.site-footer [class^=col-]{
    			margin-bottom:30px
  			}
		}
		@media (max-width:767px){
  			.site-footer{
    			padding-bottom:0
  			}
  			.site-footer .copyright-text,.site-footer .social-icons{
    			text-align:center
  			}
		}
		.social-icons{
  			padding-left:0;
  			margin-bottom:0;
  			list-style:none
		}
		.social-icons li{
  			display:inline-block;
  			margin-bottom:4px
		}
		.social-icons li.title{
  			margin-right:15px;
  			text-transform:uppercase;
  			color:#96a2b2;
  			font-weight:700;
  			font-size:13px
		}
		.social-icons a{
  			background-color:#eceeef;
  			color:#818a91;
  			font-size:16px;
  			display:inline-block;
  			line-height:44px;
  			width:44px;
  			height:44px;
  			text-align:center;
  			margin-right:8px;
  			border-radius:100%;
  			-webkit-transition:all .2s linear;
  			-o-transition:all .2s linear;
  			transition:all .2s linear
		}
		.social-icons a:active,.social-icons a:focus,.social-icons a:hover{
  			color:#fff;
  			background-color:#29aafe
		}
		.social-icons.size-sm a{
  			line-height:34px;
  			height:34px;
  			width:34px;
  			font-size:14px
		}
		.social-icons a.facebook:hover{
  			background-color:#3b5998
		}
		.social-icons a.twitter:hover{
  			background-color:#00aced
		}
		.social-icons a.linkedin:hover{
  		background-color:#007bb6
		}
.		social-icons a.dribbble:hover{
  			background-color:#ea4c89
		}
		@media (max-width:767px){
  			.social-icons li.title{
    			display:block;
    			margin-right:0;
    			font-weight:600
  			}
		}
		.footer {
  			position: relative;
  			padding: 8px;
  			background: #121518;
		}
		/* .container .box { 
  			width:480px; 
  			margin:10px; 
  			display:table; 
  			height: 100px;
		} 
		.container .box .box-row { 
  			display:table-row; 
		} 
		.container .box .box-cell { 
  			display:table-cell; 
  			width: 10%;
  			padding-right: 90px;
		} 
		.container .box .box-cell.box1 { 
  			width:fit-content;
		} 
		.container .box .box-cell.box2 { 
 			width: 100px;
		} 
		.container .box .box-cell.box3 { 
  			width: 100px;
		} */
		.row {
  			width: 100%;
  			margin: 0 auto;
  			background: #121518;
		}
		.block {
  			width: 410px;
  			float: left;
 			 margin:30px;
		}
		</style>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	</head>
	<body>
		<div class="topnav" id="myTopnav">
			<a class="active">Home</a>
			<a href="https://towardsdatascience.com/how-to-write-and-publish-a-research-paper-3692550a5c5d" target="_blank">About publication</a>
			<a href="filterpublication">Publication filter</a>
			<a href="feedback">Feedback</a>
			<div class="dropdown" >
				<button class="dropbtn" >Login<i class="fa fa-caret-down"></i></button>
				<div class="dropdown-content">
					<a href="register">Faculty</a>
					<a href="student_login">Student</a>
				 </div>
			</div>
			<div class="dropdown" >
				<button class="dropbtn">Signup<i class="fa fa-caret-down"></i></button>
				<div class="dropdown-content">
					<a href="Faculty_signup">Faculty</a>
					<a href="student_signup">Student</a>
				</div>
			</div>
			<a href="javascript:void(0);" class="icon" onclick="myFunction()">&#9776;</a>
					
		</div>
		<div style="position: relative;top: 50px;left: 150px;height: 800px;">
			<img src="images/c63411ae-56dd-4378-9e79-33e9b66e507f.webp" style="height: 700px;width: 1125px;">
		</div>
		<div style="margin: 30px;">
			<h1 style="position: relative;left: 610px;">About US</h1>
			<br>
			<p style="font-size: 17px;margin-left: 40px;margin-right: 40px;">Choose dark or bright colors that will speak to users against the white background. Black is a common choice for type on a white background (dark grays as well) because it is easy to see and read. The same is true of images as well. Select images that aren’t overly white in
				focus or consider using a black border around images to set them apart from the stark background.</p>				
		</div>
		
					<div class="row">
						<div class="block" style="position: relative;bottom: 10px;">
							
								<u><h3 style="position: relative;text-shadow: 0.5px;">Get In Touch</h3></u>
								<br>
								<p><i class="fa fa-map-marker"></i> 123 Street, New York, USA</p>
								<p><i class="fa fa-phone"></i> +012 345 67890</p>
								<p><i class="fa fa-envelope"></i> info@example.com</p>
							
						</div>
						<div style="position: relative;bottom: 10px;" class="block">
							<u><h3 style="position: relative;text-shadow: 0.5px;">Important links</h3></u>
								<br>
								<a href="../filter_publications/index.html">Publication filter</a><br>
								<a href="../Feedback/feedback.html">Feedback</a><br>
								<a href="#">Student signup</a><br>
								<a href="../Faculty_signup/index.html">Faculty signup</a><br>
						</div>
						<div class="block">						
							<img src="images/Screenshot 2021-10-07 at 9.12.55 AM.png" style="position: relative;width: 180px;height: 150px;">
						</div>
					</div>
			
			<script>
				function myFunction() {
					var x = document.getElementById("myTopnav");
					if (x.className === "topnav") {
						x.className += " responsive";
					} 
					else {
						x.className = "topnav";
					}
				}
			</script>
	</body>
</html>
