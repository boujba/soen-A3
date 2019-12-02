<%@page import="  core.bis.Book "%>
<%@page import="java.io.OutputStream"%>
<%@page import="core.bis.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Detail</title>
        
    </head>
    
    <% Book book = (Book) request.getAttribute("book"); 
     OutputStream o = (OutputStream) request.getAttribute("output");
    %>
    
    <body>
        <h1>Details</h1>
        
        <table>
            <tr>
                <th>ID</th>
                <th>ISBN</th>
                <th>Title</th>
                <th>Description</th>
                <th>Author First Name</th>
                <th>Author Last Name</th>
                <th>Publisher Name</th>
                <th>Publisher Address</th>
                <th>Book Cover</th>
            </tr>
            <tr>
                <td><%= book.getId() %></td>
                <td><%= book.getIsbn() %></td>
                <td><%= book.getTitle() %></td>
                <td><%= book.getDescription() %></td>
                <td><%= book.getAuthor().getFirstname() %></td>
                <td><%= book.getAuthor().getLastname() %></td>
                <td><%= book.getPubName() %></td>
                <td><%= book.getPubAddress() %></td>
                <td><%= book.getCover() %></td>
            </tr>
            
            
        </table>
    </body>
</html>
