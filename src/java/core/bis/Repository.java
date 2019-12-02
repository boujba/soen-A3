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
        } else if (repo == null) {
            
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
    public Book infoById(Session mySession, int id) {
        if (mySession.isUserLoggedIn()) {
          return gateway.getInfoById(id);
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
    public int addBook(Session mySession, Book myBook) {
        if (mySession.isUserLoggedIn()) {
             return gateway.InsertNewBook(myBook);
        }
            else {
            try {
                throw new RepositoryException();
            } catch (RepositoryException ex) {
                Logger.getLogger( Repository.class.getName()).log(Level.SEVERE, null, ex);
            }
            return -1;
        }
    }
        

     @Override
    public boolean updateBook(Session mySession, int id, Book myBook) {
        if (mySession.isUserLoggedIn()) {
     return gateway.updateBook(id, myBook);
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
    public boolean deleteBook(Session mySession, int id) {
        if (mySession.isUserLoggedIn()) {
           return gateway.deleteBook(id);
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
