<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!doctype html>
    <html>
    <title>upload page</title>

    <head lang='en'>
        <meta charset="utf-8">
        <style>
            body {
                background-image: url("http://laaj.org.au/wp-content/uploads/2017/01/Letter.jpg");
            }

            h1 {
                color: rgb(211, 211, 211);
                text-align: Center;
            }

            #student {
                float: left;
                padding: 0px 50px 0px 50px;
                background-color: rgba(0, 0, 0, 0.4);
                color: white;
            }

            #submission {
                float: left;
                padding: 0px 50px 0px 50px;
                background-color: rgba(0, 0, 0, 0.4);
                color: white;
            }

            #proof {
                float: left;
                padding: 0px 50px 0px 50px;
                background-color: rgba(0, 0, 0, 0.4);
                color: white;
            }

            input[type="text"],input[type="email"],
            select {
                /* width: 100%; */
                padding: 8px 15px;
                margin: 8px 0;
                display: inline-block;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
            }

            input[type="submit"] {
                width: 100%;
                background-color: #4caf50;
                color: white;
                padding: 14px 20px;
                margin: 8px 0;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }

            input[type="submit"]:hover {
                background-color: #45a049;
            }

            h3 {
                font-family: Arial, Helvetica, sans-serif;
            }

            input[type="date"],
            select {
                /* width: 100%; */
                padding: 8px 15px;
                margin: 8px 0;
                display: inline-block;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
            }

            input[type="file"],
            select {
                /* width: 100%; */
                padding: 8px 15px;
                margin: 8px 0;
                display: inline-block;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
            }
        </style>

    </head>

    <body>
        <marquee behavior="scroll" direction="left">
            <H1>PAPER PUBLICATION TRACKING PORTAL </H1>
        </marquee>
        <hr background-color:white>
        <div id="student">
            <h2>STUDENT DETAILS</h2>
            <form method="post">
                <h3>Name of the student author:</h3>
                <select>
                    <option value="Mr.">Mr.</option>
                    <option value="Mrs.">Mrs.</option>
                    <option value="Ms.">Ms.</option>
                    <option value="Dr.">Dr.</option>
                </select>
                <input type="text" name="student_name" placeholder="Type Here">
                <br>
                <h3>Roll number of the student:</h3>
                <input type="text" name="roll_number" placeholder="Type Here">
                <br>
                <h3>Email-id of the student:</h3>
                <input type="email" name="student_email" placeholder="Type Here">
                <br>
                <h3>Email-id of the faculty author</h3>
        
                
                <input type="email" name="faculty_name" placeholder="Type Here">
                <br>
        
                <h2>PAPER DETAILS</h2>
                <h3>Title of the paper:</h3>
                <input type="text" name="title_paper" placeholder="Type Here">
                <br>
                <h3>Jornal/Conference details:</h3>
                <input type="text" name="conference_details" placeholder="Type Here">
        
        
                <br><br>
                
                <br><br>
        
                <h2>PAPER SUBMISSION DETAILS</h2>
                <h3>Date of submission</h3>
                Date:
                <input type="date" name="submission_date">
                <br><br>
        
        
        
        
        
                <h3>Date of acceptance</h3>
                Date:
                <input type="date" name="acceptance_date">
        
                <br><br>
                <h3>Link of published paper:</h3>
                <input type="text" placeholder="Type Here" name="link_publication">
                <br>
                <br>
        
                <!-- <input type="submit"> -->
                <br><br><br>
        
                <h2>PROOF OF PAPER APPROVAL</h2>
                Proof of approval from department(Can be collected from faculty author)<br><br>
                <input type="file" name="proof_approval" value="Upload file"><br>
        
        
                <br><input type="submit" value="SUBMIT">
                <br><br>
        
            </form>
    </body>

    </html>