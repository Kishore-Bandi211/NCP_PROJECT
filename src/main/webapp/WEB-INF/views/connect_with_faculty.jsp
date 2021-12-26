<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		.custom-select {
  			position: relative;
  			font-family: Arial;
		}
		.custom-select select {
  			display: none;
		}
		.select-selected {
  			background-color: DodgerBlue;
		}
		.select-selected:after {
  			position: absolute;
  			content: "";
  			top: 14px;
  			right: 10px;
  			width: 0;
  			height: 0;
  			border: 6px solid transparent;
  			border-color: #fff transparent transparent transparent;
		}
		.select-selected.select-arrow-active:after {
  			border-color: transparent transparent #fff transparent;
  			top: 7px;
		}
		.select-items div,.select-selected {
  			color: #ffffff;
  			padding: 8px 16px;
  			border: 1px solid transparent;
  			border-color: transparent transparent rgba(0, 0, 0, 0.1) transparent;
  			cursor: pointer;
  			user-select: none;
		}
		.select-items {
  			position: absolute;
  			background-color: DodgerBlue;
  			top: 100%;
  			left: 0;
  			right: 0;
  			z-index: 99;
		}
		.select-hide {
  			display: none;
		}
		.select-items div:hover,.same-as-selected {
  			background-color: rgba(0, 0, 0, 0.1);
		}
		input[type="search"] {
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
  			max-width: 300px;
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
		.card button:hover,.card a:hover {
  			opacity: 0.7;
		}
		* {
  			box-sizing: border-box;
		}
		body {
  			font-family: Arial, Helvetica, sans-serif;
		}
		.column {
  			float: left;
  			width: 25%;
  			padding: 0 10px;
		}
		.row {
  			margin: 0 -5px;
		}
		.row:after {
  			content: "";
  			display: table;
  			clear: both;
		}
		@media screen and (max-width: 600px) {
  			.column {
    			width: 100%;
    			display: block;
    			margin-bottom: 20px;
  			}
		}
		.card {
  			box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  			padding: 16px;
  			text-align: center;
  			background-color: #f1f1f1;
  			margin: 20px;
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
		}
		</style>
    	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	</head>	
	<body>
   		<a href="student_home"><button class="button">Home</button></a>
    	<h2 id="filter">Connect with faculty</h2>
    	<div id="searchbar">
    	<form method="post">
        	<input  name="search"  placeholder= "Please type intrested topic">
        	<input type="submit" value="Submit">
        	</form>
			<hr>
        	
		</div>
    	<script >
    		var x, i, j, l, ll, selElmnt, a, b, c;
    		x = document.getElementsByClassName("custom-select");
    		l = x.length;
    		for (i = 0; i < l; i++) {
        		selElmnt = x[i].getElementsByTagName("select")[0];
        		ll = selElmnt.length;
        		a = document.createElement("DIV");
        		a.setAttribute("class", "select-selected");
        		a.innerHTML = selElmnt.options[selElmnt.selectedIndex].innerHTML;
        		x[i].appendChild(a);
        		b = document.createElement("DIV");
        		b.setAttribute("class", "select-items select-hide");
        		for (j = 1; j < ll; j++) {
            		c = document.createElement("DIV");
            		c.innerHTML = selElmnt.options[j].innerHTML;
            		c.addEventListener("click", function (e) {
                	var y, i, k, s, h, sl, yl;
                	s = this.parentNode.parentNode.getElementsByTagName("select")[0];
                	sl = s.length;
                	h = this.parentNode.previousSibling;
                	for (i = 0; i < sl; i++) {
                    	if (s.options[i].innerHTML == this.innerHTML) {
                        	s.selectedIndex = i;
                        	h.innerHTML = this.innerHTML;
                       	 	y = this.parentNode.getElementsByClassName("same-as-selected");
                        	yl = y.length;
                        	for (k = 0; k < yl; k++) {
                            	y[k].removeAttribute("class");
                        	}
                        	this.setAttribute("class", "same-as-selected");
                        	break;
                    	}
                	}
                	h.click();
            		});
            		b.appendChild(c);
        		}
        		x[i].appendChild(b);
        		a.addEventListener("click", function (e) {
            	e.stopPropagation();
            	closeAllSelect(this);
            	this.nextSibling.classList.toggle("select-hide");
            	this.classList.toggle("select-arrow-active");
        		});
    		}
    		function closeAllSelect(elmnt) {
        		var x, y, i, xl, yl, arrNo = [];
        		x = document.getElementsByClassName("select-items");
        		y = document.getElementsByClassName("select-selected");
        		xl = x.length;
        		yl = y.length;
        		for (i = 0; i < yl; i++) {
            		if (elmnt == y[i]) {
                		arrNo.push(i)
            		} else {
                		y[i].classList.remove("select-arrow-active");
            		}
        		}
        		for (i = 0; i < xl; i++) {
            		if (arrNo.indexOf(i)) {
                		x[i].classList.add("select-hide");
            		}
        		}
    		}
    		document.addEventListener("click", closeAllSelect); 
    	</script>
	</body>
</html>