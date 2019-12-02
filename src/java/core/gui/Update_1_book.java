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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(maxFileSize = 16177215)
public class Update_1_book extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         if (request.getSession().getAttribute("someUser") == null){
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
           }
            
        
        
        try {
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
            Repository.getInstance(getServletContext()).updateBook((Session) request.getSession().getAttribute("someUser"), id, book);

            Part cover = request.getPart("cover");
            String mimeType = cover.getContentType();

            InputStream input = cover.getInputStream();

            if (mimeType.contains("image/")) {
                 Repository.getInstance(getServletContext()).setImage((Session) request.getSession().getAttribute("someUser"), id, mimeType, input);
            }

            response.sendRedirect("List_all_books");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Delete_1_book.class.getName()).log(Level.SEVERE, null, ex);
        }
        
   
        
        
        
        
        
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
