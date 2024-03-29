package core.gui;

import core.bis.Author;
import core.bis.Book;
import core.bis.Repository;
import core.bis.CoverImage;
import core.bis.Session;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(maxFileSize = 16177215)
@WebServlet(name = "Update_1_book", urlPatterns = {"/Update_1_book"})
public class Update_1_book extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        
       
           int id = Integer.parseInt(request.getParameter("id"));
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            String isbn = request.getParameter("isbn");
            String author_first_name = request.getParameter("author_first_name");
            String author_last_name = request.getParameter("author_last_name");
            Author myAuthor = new Author(author_first_name, author_last_name);
            String publisherCompany = request.getParameter("publisherCompany");
            String publisherAddress = request.getParameter("publisherAddress");
            
            CoverImage myCoverImage = new CoverImage();
            Book book = new Book(id, title, description, isbn, myAuthor, publisherCompany, publisherAddress, myCoverImage);
            Repository.getInstance(getServletContext()).updateBook( id, book);

           response.sendRedirect("Delbook.jsp");
        
   
        
        
        
        
        
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Update_1_book.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Update_1_book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Update_1_book.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Update_1_book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
