<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}

input[type=submit] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover {
  background-color: #111;
}
</style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Book To BookStore</title>
    </head>
    <body>
        
         <ul>
             <li><a href="Home.jsp">Home</a></li>
             <li><a href="Delbook.jsp">Book cathalog</a></li>
             <li><a href="BookForm.jsp">Book Update/New</a></li>
        
             <li><a href="Logout.jsp">logout</a></li>
        
       </ul>
        <h1>Add a book here</h1>
        
        <form action="add_1_book" method="post" enctype="multipart/form-data">
            Isbn <input type="text" name="isbn"><br> 
            Title <input type="text" name="title"><br>
            Description <input type="text" name="description"><br>
            Author First Name <input type="text" name="fname"><br>
            Author Last Name <input type="text" name="lname"><br>
            Publisher Name <input type="text" name="pubname"><br>
            Publisher Address <input type="text" name="pubaddress"><br>
            Cover Image <input type="file" name="image"><br>
            <input type="submit" value="Add Book"/>
        </form>
    </body>
</html>