package core.gui;

import core.bis.Author;
import core.bis.Book;
import core.bis.Repository;
import core.bis.CoverImage;
import core.bis.Session;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import static java.sql.JDBCType.BLOB;
import java.sql.SQLException;
import static java.sql.Types.BLOB;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;

import javafx.scene.control.Alert.AlertType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;

@MultipartConfig(maxFileSize = 16177215)
@WebServlet(name = "Add_1_book", urlPatterns = {"/Add_1_book"})
public class Add_1_book extends HttpServlet {

    private int generateId(HttpServletRequest request) {
        try {
            List<Book> booksList =  Repository.getInstance(getServletContext()).listBooks((Session) request.getSession().getAttribute("someUser"));
            if (booksList.isEmpty()) {
                return 0;
            } else {
                Book lastBook = booksList.get(booksList.size() - 1);
                return 1 + lastBook.getId();
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Add_1_book.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        //try {
           //if (request.getSession().getAttribute("someUser") == null){
           //     RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
          //      dispatcher.forward(request, response);
          // }
            
            
            
            
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            String isbn = request.getParameter("isbn");
            String author_first_name = request.getParameter("author_first_name");
            String author_last_name = request.getParameter("author_last_name");
            Author myAuthor = new Author(author_first_name, author_last_name);
            String publisherCompany = request.getParameter("publisherCompany");
            String publisherAddress = request.getParameter("publisherAddress");
            //Part image = request.getPart("image");
           // String fileName = Paths.get(image.getSubmittedFileName()).getFileName().toString();
            CoverImage myCoverImage = new CoverImage();
            
            Book book = new Book(2, title, description, isbn, myAuthor, publisherCompany, publisherAddress,myCoverImage);
            //Repository.getInstance(getServletContext()).setImage((BLOB)image);
            Repository.getInstance(getServletContext()).addBook(book);
            
           System.out.print(book);
          
//generateId(request)
         

            response.sendRedirect("Delbook.jsp");
     
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Add_1_book.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Add_1_book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Add_1_book.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Add_1_book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
