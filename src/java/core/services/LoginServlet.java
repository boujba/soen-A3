/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.services;
import core.bis.Session;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

                  
       doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         HttpSession session = request.getSession();
            
        if(session.getAttribute("theSession") == null)
        {
            System.out.println("NUll");
            //Does not exist must be created
            Session theSession = new Session();
            session.setAttribute("theSession", theSession);
            RequestDispatcher disp = request.getRequestDispatcher("/login.jsp");
            disp.forward(request, response);
        }
        else 
        {
            if(request.getMethod().equals("POST"))
            {
                String name = request.getParameter("name");
                String password = request.getParameter("password");

                // Session
                Session currentSession = (Session)session.getAttribute("theSession"); 

                if(currentSession.isUserLoggedIn())
                {
                    // Logged in 
                    RequestDispatcher disp = request.getRequestDispatcher("/Home.jsp");
                    disp.forward(request, response);
                }
                else
                {
                    String login = currentSession.login(name, password);

                    // Not Logged In
                    if(login.equals("SUCCESS")){
                        response.sendRedirect("read");
                    }
                    else{
                        RequestDispatcher disp = request.getRequestDispatcher("/Logout.jsp");
                        disp.forward(request, response);
                    }
                }
            }
            
            if(request.getMethod().equals("GET"))
            {
                Session currentSession = (Session)session.getAttribute("theSession");

                if(currentSession.isUserLoggedIn() == true)
                {
                   response.sendRedirect("read");
                }
                else
                {
                   session.setAttribute("theSession", null);
                   response.sendRedirect("loginServlet");
                  
                }
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
