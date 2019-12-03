

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="  core.bis.Book "%>
<%@page import="java.io.OutputStream"%>
<%@page import="core.bis.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <h1>Details</h1>
        
      
           <c:if test="${book != null}">
            <form action="Update_1_book" method="post" enctype="multipart/form-data">
            </c:if>
                  <table>
                      <tr>
                        <th>id: </th>
                        <td>
                            <input type="text" name="id" size="45"
                                   value="<c:out value='${book.id}' />"
                                   />
                        </td>
                    </tr>
             <tr>
                        <th>Title: </th>
                        <td>
                            <input type="text" name="title" size="45"
                                   value="<c:out value='${book.title}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Description: </th>
                        <td>
                            <input type="text" name="description" size="45"
                                   value="<c:out value='${book.description}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Isbn: </th>
                        <td>
                            <input type="text" name="isbn" size="45"
                                   value="<c:out value='${book.isbn}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Author (first name): </th>
                        <td>
                            <input type="text" name="author_first_name" size="45"
                                   value="<c:out value='${book.authorlastname}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Author (last name): </th>
                        <td>
                            <input type="text" name="author_last_name" size="45"
                                   value="<c:out value='${book.authorname}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Publisher Company: </th>
                        <td>
                            <input type="text" name="publisherCompany" size="45"
                                   value="<c:out value='${book.pubName}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Publisher Address: </th>
                        <td>
                            <input type="text" name="publisherAddress" size="45"
                                   value="<c:out value='${book.pubAddress}' />"
                                   />
                        </td>
                    </tr>
            
            <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="Save" />
                        </td>
                    </tr>
                </table>
            </form>
    </body>
</html>
