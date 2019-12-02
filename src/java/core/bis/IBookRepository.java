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
   public List<Book> listBooks();
    List<Book> listBooks(Session id);
    
    Book infoById(Session mySession, int id);
   Book infoByIsbn(Session mySession, String isbn);
    
    int addBook(Book Book);
    boolean updateBook(Session id, int bookID, Book updateInfo);
   boolean setImage(Session mySession, int myId, String mimeType, InputStream inputStream);
    boolean deleteBook( int bookid);
   boolean deleteAll(Session id);
    
}
