package core.services;




import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import  core.services.LoginBean ; 
import core.bis.Session;


@WebServlet(name = "loginController", urlPatterns = {"/login"})
public class loginController extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet loginController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet loginController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        
        response.setContentType("text/html"); 
        PrintWriter out=response.getWriter();

        String name=request.getParameter("name");  
        String password=request.getParameter("password");  

        LoginBean loginBean = new LoginBean();

        loginBean.setName(name);
        loginBean.setPassword(password);

        Session session = new Session();

        String login = session.login(name, password);
        
//        if(login.equals("SUCCESS")){
//            RequestDispatcher disp = request.getRequestDispatcher("/registration-success");
//            disp.forward(request, response);
//        }
//        else{
//            RequestDispatcher disp = request.getRequestDispatcher("/registration-fail");
//            disp.forward(request, response);
//        }
        

//        if(login.equals("SUCCESS")){  
//            request.setAttribute("Name", name);
            RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");  
            rd.forward(request, response);  
//        }  
//        else{  
//            request.setAttribute("errMessage", login);
//            RequestDispatcher rd=request.getRequestDispatcher("/registration-fail.jsp");  
//            rd.forward(request, response);  
//        }  
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
