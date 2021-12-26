<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
    <meta charset="utf-8">
    <title>forgot password</title>
    <style>
        form{
            max-width: 500px;
  margin: auto;
  background-color: rgb(148, 112, 182);
  height:400px

        }
        .forget h3{
            padding-left: 200px;
            padding-top: 10px;
        }
        .forget h2{
            padding-left: 100px;
        }
        .field{
            padding-left: 100px;
        }
        input{
            border-radius: 4px;
            width:300px;
            height:20px;
            padding: 4px;
            border-color: aliceblue;
            color: green;
        }
        .fa-envelope{
            height:20px;

        }
        #submit{
            margin-left: 120px;
            margin-top:20px;
            height:30px;
            width:320px;
            font-size: 25px;
            padding: 2px;
        }
        #ans{
            padding-left: 10px;
            margin-left: 15px;
        }
    </style>
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
</head>

<body>
    <div class="login-form">
        <div class="text">
            <h1 style="padding: 10px;align-items: center;background-color: rgb(192, 229, 229);padding-left: 550px;color: red;text-decoration: solid;">
                FORGOT PASSWORD?
            </h1>
            
        </div>
        <form method="post">
            <div class="forget">
                <h3 style="color:white"><i class="fa fa-lock fa-4x"></i></h3>
                <!-- <br> -->
               <h2 style="color:white">
                   You can reset your Password.
               </h2>
               <br>
            </div>
            <div class="field">
                <div class="fas fa-envelope"></div>
                 <input type="text" placeholder="Email" name="email">
<%--                  <% request.setAttribute("email",email);%> 
 --%>                 
<!--  HttpSession sess = request.getSession(); 
 sess.setAttribute("email", email); -->
                <br>
                <br>
                
                <input type="text" placeholder="What is your first school name?" id="ans" style="position:'relative',top:100px" name="value">
            </div>
            
            <input type="submit" id="submit" value="SUBMIT">
            
            <br>
            
        </form>
    </div>
</body>

</html>