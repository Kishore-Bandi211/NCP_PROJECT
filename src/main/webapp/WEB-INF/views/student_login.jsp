<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en" dir="ltr">

<head>
  <meta charset="utf-8">
  <title>Glowing Inputs Login Form UI</title>
  <style>
  @import url("https://fonts.googleapis.com/css?family=Poppins&display=swap");
* {
  margin: 0;
  padding: 0;
  font-family: "Poppins", sans-serif;
}
body {
  display: flex;
  height: 100vh;
  text-align: center;
  align-items: center;
  justify-content: center;
  background: #151515;
}
.login-form {
  position: relative;
  width: 400px;
  height: auto;
  background: #1b1b1b;
  padding: 40px 35px 60px;
  box-sizing: border-box;
  border: 1px solid black;
  border-radius: 5px;
  box-shadow: inset 0 0 1px #272727;
}
.text {
  font-size: 30px;
  color: #c7c7c7;
  font-weight: 600;
  letter-spacing: 2px;
}
form {
  margin-top: 40px;
}
form .field {
  margin-top: 20px;
  display: flex;
}
.field .fas {
  height: 50px;
  width: 60px;
  color: #868686;
  font-size: 20px;
  line-height: 50px;
  border: 1px solid #444;
  border-right: none;
  border-radius: 5px 0 0 5px;
  background: linear-gradient(#333, #222);
}
.field input,
form button {
  height: 50px;
  width: 100%;
  outline: none;
  font-size: 19px;
  color: #868686;
  padding: 0 15px;
  border-radius: 0 5px 5px 0;
  border: 1px solid #444;
  caret-color: #339933;
  background: linear-gradient(#333, #222);
}
input:focus {
  color: #339933;
  box-shadow: 0 0 5px rgba(0, 255, 0, 0.2), inset 0 0 5px rgba(0, 255, 0, 0.1);
  background: linear-gradient(#333933, #222922);
  animation: glow 0.8s ease-out infinite alternate;
}
@keyframes glow {
  0% {
    border-color: #339933;
    box-shadow: 0 0 5px rgba(0, 255, 0, 0.2), inset 0 0 5px rgba(0, 0, 0, 0.1);
  }
  100% {
    border-color: #6f6;
    box-shadow: 0 0 20px rgba(0, 255, 0, 0.6),
      inset 0 0 10px rgba(0, 255, 0, 0.4);
  }
}
button {
  margin-top: 30px;
  border-radius: 5px !important;
  font-weight: 600;
  letter-spacing: 1px;
  cursor: pointer;
}
#login {
margin-top:20px;
  height: 50px;
  width: 100%;
  outline: none;
  font-size: 19px;
  color: #868686;
  padding: 0 15px;
  border-radius: 0 5px 5px 0;
  border: 1px solid #444;
  caret-color: #339933;
  background: linear-gradient(#333, #222);
}
button:hover {
  color: #339933;
  border: 1px solid #339933;
  box-shadow: 0 0 5px rgba(0, 255, 0, 0.3), 0 0 10px rgba(0, 255, 0, 0.2),
    0 0 15px rgba(0, 255, 0, 0.1), 0 2px 0 black;
}
.link {
  margin-top: 25px;
  color: #868686;
}
.link a {
  color: #339933;
  text-decoration: none;
}
.link a:hover {
  text-decoration: underline;
}

.pass {
  text-align: left;
  margin: 10px 0;
}
.pass a {
  color: white;
  text-decoration: none;
  font-family: "Poppins", sans-serif;
}
.pass:hover a {
  text-decoration: underline;
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
  top:0px;
  position: relative;
  
}</style>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
</head>

<body>
 
  <div class="login-form">
    <div class="text">
      LOGIN FORM
    </div>
    <form  method="post">
      <div class="field">
        <div class="fas fa-envelope"></div>
        <input type="text" placeholder="Email" name="email">
      </div>
      <div class="field">
        <div class="fas fa-lock"></div>
        <input type="password" placeholder="Password" name="password">
      </div>
       <input id="login" type="submit" value="Login">
      <br>
      <div class="pass">
        <a href="forget_password">Forgot Password?</a>
      </div>
      <div class="link">
        Not a member?
       
      </div>
    </form>
    <a href="student_signup"><button id="login">Sign up</button></a>
  </div>
</body>

</html>