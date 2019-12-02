/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.gui;

import core.bis.Book;
import core.bis.Repository;
import core.bis.Session;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig(maxFileSize = 16177215)
public class Display_image extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         if (request.getSession().getAttribute("someUser") == null){
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
           }
            
        
        try {
            if (request.getSession().getAttribute("someUser") == null) {
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
            int myId = Integer.parseInt(request.getParameter("id"));
            Book myBook = Repository.getInstance(getServletContext()).infoById((Session) request.getSession().getAttribute("someUser"), myId);
            response.setContentType(myBook.getCover().toString());
            OutputStream display = response.getOutputStream();
            display.write(myBook.getCoverImageData());
            display.flush();
            display.close();
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
