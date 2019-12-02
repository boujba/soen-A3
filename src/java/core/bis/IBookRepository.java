package core.bis;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.InputStream;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;


public interface IBookRepository {       
   
    List<Book> listBooks(Session id);
    
    Book infoById(Session mySession, int id);
   Book infoByIsbn(Session mySession, String isbn);
    
    int addBook(Session mySession, Book myBook);
    boolean updateBook(Session id, int bookID, Book updateInfo);
   boolean setImage(Session mySession, int myId, String mimeType, InputStream inputStream);
    boolean deleteBook(Session id, int bookid);
   boolean deleteAll(Session id);
    
}
