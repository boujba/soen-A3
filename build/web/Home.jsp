<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="core.bis.*"%>
<%@page import="core.gui.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

    




<!DOCTYPE html>
<html>
    <head>
         <style>
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
            body {background-color: whitesmoke;}
            h1   {color: black;}
            a    {color: blue;}
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <%@page import="java.sql.*;"%>
        <title>BookStore</title>
    </head>
    
         <ul>
             <li><a href="Home.jsp">Home</a></li>
             <li><a href="Delbook.jsp">Book cathalog</a></li>
             <li><a href="BookForm.jsp">Book Update/New</a></li>
        
             <li><a href="Logout.jsp">logout</a></li>
        
       </ul>
    <h3><a href="Delete_all_books" onclick="return confirm(' You want to delete all books?');">Delete All Books</a>
            &nbsp;&nbsp;&nbsp;
    <a href="List_all_books">List All Books</a></h3>
    <body>   
        <table border="1">
    <!-- column headers -->
    <tr>
        <c:forEach var="columnName" items="${result.columnNames}">
            <th><c:out value="${columnName}"/></th>
            </c:forEach>
    </tr>
    <!-- column data -->
    <c:forEach var="row" items="${result.rowsByIndex}">
        <tr>
            <c:forEach var="column" items="${row}">
                <td><c:out value="${column}"/></td>
            </c:forEach>
        </tr>
    </c:forEach>
</table><
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
        </table>
   
    </body>
</html>