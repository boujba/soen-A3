package core.gui;

import core.bis.Repository;
import core.bis.Session;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "Delete_1_book", urlPatterns = {"/Delete_1_book"})

public class Delete_1_book extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         if (request.getSession().getAttribute("someUser") == null){
                RequestDispatcher dispatcher = request.getRequestDispatcher("login .jsp");
                dispatcher.forward(request, response);
           }
            
        
        try {
            int id = Integer.parseInt(request.getParameter("id"));
             Repository.getInstance(getServletContext()).deleteBook((Session) request.getSession().getAttribute("someUser"), id);
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
