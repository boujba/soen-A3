
<%@page import="java.util.ArrayList"%>
<%@page import="core.bis.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
         <style>
             
            body {background-color: whitesmoke;}
            h1   {color: black;}
            a    {color: blue;}
            
#customers {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}
 td,  th {
  border: 1px solid #ddd;
  padding: 8px;
}
tr:nth-child(even){background-color: #f2f2f2;}
tr:hover {background-color: #ddd;}

 th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
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
        <title>BookStore Cathalog</title>
     
    </head>
    
    <body>
        
         <ul>
             <li><a href="Home.jsp">Home</a></li>
             <li><a href="Delbook.jsp">Book cathalog</a></li>
             <li><a href="BookForm.jsp">Book Update/New</a></li>
        
             <li><a href="Logout.jsp">logout</a></li>
        
       </ul>
        <h1>List of books</h1><br>
        <a href="Delete_all_books">Delete All Books</a>
        
        
        
        <br>
        
        ${books}
          <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Books</h2></caption>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Description</th>
                <th>Isbn</th>
                <th>Author</th>
                <th>Publisher Company</th>
                <th>Publisher Address</th>
                
                <th>Cover</th>
            </tr>
            <c:forEach var="book" items="${booksList}">
                <tr>
                    <td><c:out value="${book.id}" /></td>
                    <td><c:out value="${book.title}" /></td>
                    <td><c:out value="${book.description}" /></td>
                    <td><c:out value="${book.isbn}" /></td>
                    <td><c:out value="${book.myAuthor.firstName}${' '}${book.myAuthor.lastName}" /></td>
                    <td><c:out value="${book.publisherCompany}" /></td>
                    <td><c:out value="${book.publisherAddress}" /></td>
                    <td>
                        <a href="Display_update_page?id=<c:out value='${book.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="Delete_1_book?id=<c:out value='${book.id}' />" onclick="return confirm(' you want to delete this book?');">Delete</a>                     
                    </td>
                    <td><img src="Display_image?id=<c:out value='${book.id}' />"></td>
                    
                </tr>
            </c:forEach>
       
        
    </body>
</html>
