

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="  core.bis.Book "%>
<%@page import="java.io.OutputStream"%>
<%@page import="core.bis.*"%>
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
        <title>Book Detail</title>
        
    </head>
    
    
    
    <body>
        <% Book book = (Book) request.getAttribute("book") ;%>
         <ul>
             <li><a href="Home.jsp">Home</a></li>
             <li><a href="Delbook.jsp">Book cathalog</a></li>
             <li><a href="BookForm.jsp">Book Update/New</a></li>
        
             <li><a href="Logout.jsp">logout</a></li>
        
       </ul>
        <h1>Details of the book:</h1>
        
      
           <c:if test="${book != null}">
            <form action="Delbook.jsp" method="post" enctype="multipart/form-data">
            </c:if>
                  <table>
                      <tr>
                        <th>id: </th>
                        <td>
                           <c:out value='${book.id}' />
                                   
                        </td>
                    </tr>
             <tr>
                        <th>Title: </th>
                        <td>
                            <c:out value='${book.title}' />
                                   
                        </td>
                    </tr>
                    <tr>
                        <th>Description: </th>
                        <td>
                            <c:out value='${book.description}' />
                                  
                        </td>
                    </tr>
                    <tr>
                        <th>Isbn: </th>
                        <td>
                            <c:out value='${book.isbn}' />
                                   
                        </td>
                    </tr>
                    <tr>
                        <th>Author (first name): </th>
                        <td>
                            <c:out value='${book.authorlastname}' />
                                   
                        </td>
                    </tr>
                    <tr>
                        <th>Author (last name): </th>
                        <td>
                            <c:out value='${book.authorname}' />
                                   
                        </td>
                    </tr>
                    <tr>
                        <th>Publisher Company: </th>
                        <td>
                          <c:out value='${book.pubName}' />
                                   
                        </td>
                    </tr>
                    <tr>
                        <th>Publisher Address: </th>
                        <td>
                            <c:out value='${book.pubAddress}' />
                                   
                        </td>
                    </tr>
                    <tr>
                        <th>cover </th>
                        <td>
                            <img src="<c:out value='${book.cover}' />" width="300" height="200">
                                   
                        </td>
                    </tr>
            
            <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="Back to cathalog" />
                        </td>
                    </tr>
                </table>
            </form>
    </body>
</html>
