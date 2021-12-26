<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
    * {
  box-sizing: border-box;
}

body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.topnav {
  overflow: hidden;
  background-color: #e9e9e9;
}

.topnav a {
  float: left;
  display: block;
  color: black;
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
  background-color: #2196f3;
  color: white;
}

.topnav .search-container {
  float: right;
}

.topnav input[type="text"] {
  padding: 6px;
  margin-top: 8px;
  font-size: 17px;
  border: none;
}

.topnav .search-container button {
  float: right;
  padding: 6px 10px;
  margin-top: 8px;
  margin-right: 16px;
  background: #ddd;
  font-size: 17px;
  border: none;
  cursor: pointer;
}

.topnav .search-container button:hover {
  background: #ccc;
}

@media screen and (max-width: 600px) {
  .topnav .search-container {
    float: none;
  }

  .topnav a,
  .topnav input[type="text"],
  .topnav .search-container button {
    float: none;
    display: block;
    text-align: left;
    width: 100%;
    margin: 0;
    padding: 14px;
  }

  .topnav input[type="text"] {
    border: 1px solid #ccc;
  }
}

.container {
  margin: 5px;
  padding: 5px;
  width: 100%;
  display: inline-flex;
  background-color: aqua;
}

.search {
  width: 50%;
  padding: 5px;
}
.search2 {
  width: 50%;
  padding: 5px;
  margin-top: 70px;
}
.recent {
  margin: 5px;
  padding: 5px;
  width: 100%;

  background-color: aquamarine;
  align-items: center;
}
.login {
  margin: 5px;
  padding: 5px;
  width: 100%;
  background-color: white;
  display: inline-flex;
}
.student {
  width: 50%;

  height: 400px;
  margin: 5px;
  padding: 5px;
}
.faculty {
  width: 50%;

  height: 400px;
  margin: 5px;
  padding: 5px;
}
.student img {
  width: 100%;
  height: 400px;
}
.student button {
  background-color: #4caf50; /* Green */
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 20px;
  width: 100%;
}
.faculty img {
  width: 100%;
  height: 400px;
}
.faculty button {
  background-color: #4caf50; /* Green */
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 20px;
  width: 100%;
}
    </style>
</head>

<body>

    <div class="topnav">
        
      <h1 style="text-align: center;text-decoration: solid;color:brown">PAPER PUBLICATION TRACKING PORTAL</h1>
    </div>
    <div class="container">

        <div class="search">
            <h2 style="color:black">
                SEARCH PUBLICATION PAPER
            </h2>
            <form action="">
<label for="cars">Search by Year:</label>

<select id="year">
    <option value="2021">2021</option>
    <option value="2020">2020</option>
    <option value="2019">2019</option>
    <option value="2018">2018</option>
</select>
<input type="submit" value="Search">
            </form>

        </div>

        <div class="search2">
            
            <form action="">
                <label for="names">Search by Name:</label>
        
                <input type="text" placeholder="Search.." name="search">
                <button type="submit"><i class="fa fa-search"></i></button>
            </form>
        
        </div>

        

    </div>

    <div class="recent">

            <h2 style="color:black">RECENT PUBLICATIONS</h2>
            <ul>
                <li>
                    <a href="">Tight bounds for Katona's shadow intersection theorem </a><span>(with X. Liu) European Journal of Combinatorics (20 pages)</span>
                </li>
                <br>
                <li>
                    <a href="">A hypergraph Turan problem with no stability </a><span>(with X. Liu) Combinatorica (22 pages)</span>
                </li>
                <br>
                <li>
                    <a href="">Cliques with many colors in triple systems </a><span>(with A. Suk) Journal of Combinatorics (5 pages)</span>
                </li>
                
            </ul>

    </div>

    <div class="login">
        
        <div class="student">
            <img src="student.jpg" alt="">
            <button type="button"> Student Login</button>
        </div>

        <div class="faculty">
<img src="faculty.jfif" alt="">

<button type="button"> Faculty Login</button>
        </div>
    </div>
    
   

</body>

</html>