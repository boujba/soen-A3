package core.bis;
import static com.oracle.nio.BufferSecrets.instance;
import core.database.Table_Data_Gateway;

import java.io.InputStream;
import static java.lang.Integer.parseInt;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import static org.jboss.weld.Container.instance;

//****************************************************************************************************
//****************************************************************************************************
public class  Repository implements IBookRepository {

    public static synchronized  Repository getInstance(ServletContext context) throws SQLException, ClassNotFoundException {
        if (context == null) {
         return null;
        } else
            if (repo == null) {
            
            repo = new  Repository();
        }
        return repo;
    }

    Table_Data_Gateway gateway = null;
    
     
 
    private static  Repository repo = null;
 
    public  Repository() throws SQLException, ClassNotFoundException{
        gateway= new Table_Data_Gateway();
    }
    
    

     
    @Override
    public List<Book> listBooks(Session mySession) {
        if (mySession.isUserLoggedIn()) {
           return gateway.ListOfBooks();
    
        } else {
            try {
                throw new RepositoryException();
            } catch (RepositoryException ex) {
                Logger.getLogger( Repository.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
    }
     @Override
    public List<Book> listBooks() {
   return gateway.ListOfBooks();
    }
    @Override
    public Book infoById( int id) {
        
          return gateway.getInfoById(id);
        
        }
    
        

       @Override
    public Book infoByIsbn(Session mySession, String isbn) {
        if (mySession.isUserLoggedIn()) {
            return gateway.getInfoByIsbn(isbn);
        } else {
            try {
                throw new RepositoryException();
            } catch (RepositoryException ex) {
                Logger.getLogger( Repository.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
    }

     @Override
    public int addBook( Book myBook) {
        
             return gateway.InsertNewBook(myBook);
       
    }
        

     @Override
    public boolean updateBook(int id, Book myBook) {
        
     return gateway.updateBook(id, myBook);
        
    }

     @Override
    public boolean setImage(Session mySession, int myId, String mimeType, InputStream inputStream) {
        if (mySession.isUserLoggedIn()) {
            return gateway.setImage(myId, mimeType, inputStream);
        } else {
            try {
                throw new RepositoryException();
            } catch (RepositoryException ex) {
                Logger.getLogger( Repository.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        }
    }

      @Override
    public boolean deleteBook( int id) {
        
           return gateway.deleteBook(id);
       
    }

     
    @Override
    public boolean deleteAll(Session mySession) {
        if (mySession.isUserLoggedIn()) {
          return gateway.deleteAll();
        } else {
            try {
                throw new RepositoryException();
            } catch (RepositoryException ex) {
                Logger.getLogger( Repository.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        }
    }

}

 
