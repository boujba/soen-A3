package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import core.bis.Book;
import java.io.OutputStream;
import core.bis.*;

public final class ViewBookDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Book Detail</title>\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    ");
 Book book = (Book) request.getAttribute("book"); 
     
    
      out.write("\n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("        <h1>Details</h1>\n");
      out.write("        \n");
      out.write("        <table>\n");
      out.write("            <tr>\n");
      out.write("                <th>ID</th>\n");
      out.write("                <th>ISBN</th>\n");
      out.write("                <th>Title</th>\n");
      out.write("                <th>Description</th>\n");
      out.write("                <th>Author First Name</th>\n");
      out.write("                <th>Author Last Name</th>\n");
      out.write("                <th>Publisher Name</th>\n");
      out.write("                <th>Publisher Address</th>\n");
      out.write("                <th>Book Cover</th>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print( book.getId() );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( book.getIsbn() );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( book.getTitle() );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( book.getDescription() );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( book.getAuthorname() );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( book.getAuthorlastname() );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( book.getPubName() );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( book.getPubAddress() );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( book.getCover() );
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("        </table>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
