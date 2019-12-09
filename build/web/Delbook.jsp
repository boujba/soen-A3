<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
 <!DOCTYPE html>
<html>
    
   <head>
       <style>
img {
  border: 1px solid #ddd;
  border-radius: 2px;
  padding: 3px;
  width: 75px;
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
            body {background-color: whitesmoke;}
            h1   {color: black;}
            a    {color: blue;}
</style>
      <title>SELECT Operation</title>
      
   </head>
      <body>

<ul>
             <li><a href="Home.jsp">Home</a></li>
             <li><a href="Delbook.jsp">Book cathalog</a></li>
             <li><a href="BookForm.jsp">Book Update/New</a></li>
        
             <li><a href="Logout.jsp">logout</a></li>
        
       </ul>
      <sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost:3306/books?zeroDateTimeBehavior=convertToNull"
         user = "root"  password = ""/>
 
      <sql:query dataSource = "${snapshot}" var = "result">
         SELECT * from book;
      </sql:query>
 
      <table border = "1" width = "100%">
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
         
         <c:forEach var = "row" items = "${result.rows}">
             <tr>
                    <td><c:out value="${row.id}" /></td>
                    <td><c:out value="${row.title}" /></td>
                    <td><c:out value="${row.descrption}" /></td>
                    <td><c:out value="${row.isbn}" /></td>
                    <td><c:out value="${row.authorname}${' '}${row.authorlastname}" /></td>
                    <td><c:out value="${row.publishername}" /></td>
                    <td><c:out value="${row.publisheraddr}" /></td>
                    <td><img src= "<c:out value='${row.id}' />" ></td>
                    <td>
                        <a href="Display_view_page?id=<c:out value='${row.id}' />">Details</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="Display_update_page?id=<c:out value='${row.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="Delete_1_book?id=<c:out value='${row.id}' />" onclick="return confirm(' you want to delete this book?');">Delete</a>                     
                    </td>
                    
                    
                </tr>
         </c:forEach>
      </table>
 
   </body>
</html>