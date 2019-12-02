/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import core.bis.Repository;
import core.bis.IBookRepository;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static jdk.nashorn.internal.runtime.Debug.id;
import org.json.simple.*;

/**
 *
 * @author 
 */
public class Book extends HttpServlet {
private IBookRepository singleton = null;
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
            throws ServletException, IOException, SQLException, ClassNotFoundException {
         
    singleton = Repository.getInstance(getServletContext());
    
      if (request.getSession().getAttribute("someUser") == null){
                RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
                dispatcher.forward(request, response);
           }
         
    
    
    
    
    
    
    
    JSONArray jarray= new JSONArray();
    
    
   // reading book objects and putting to json objects
    for(core.bis.Book b :singleton.listBooks() ){
       JSONObject book = new JSONObject(); 
       book.put("FirstName",b.getAuthorname());
       book.put("LastName",b.getAuthorlastname());
       book.put("Title", b.getTitle());
       book.put("BookId",b.getId());
       book.put("Description",b.getDescription());
       book.put("ISBN",b.getIsbn());
       book.put("PublisherAdress", b.getPubAddress());
       book.put("publisherCompany",b.getPubName());
       
       jarray.add(book);
    }
    String path = getServletContext().getRealPath("WEB-INF/books.json");
    try (FileWriter file = new FileWriter(path)){
        file.write(jarray.toJSONString());
        file.flush();
    }catch (IOException e){
        e.printStackTrace();
    }
    
     response.setContentType("application/json");
            try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet task1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>");
           out.println(jarray.toJSONString());
           out.println("-------------------------------------------------------------------------------------");
           
           
           out.println(jarray.toString());
            
            
            
            out.println("</h1>");
         
          
           
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
    try {
        processRequest(request, response);
    } catch (SQLException ex) {
        Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
    }
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
    try {
        processRequest(request, response);
    } catch (SQLException ex) {
        Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
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
