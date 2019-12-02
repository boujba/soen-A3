/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core.database;

import core.bis.Author;
import core.bis.Book;
import core.bis.Repository;
import core.bis.CoverImage;
import core.bis.Session;
import java.io.InputStream;
import static java.lang.Integer.parseInt;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class Table_Data_Gateway {
    
    
    private Connection conn = null;

    private String user = "root";
    private String pass = "";
    private String host = "jdbc:mysql://localhost:3306/books?zeroDateTimeBehavior=convertToNull";
    
    //****************************************************************************************************
    //****************************************************************************************************
    public Table_Data_Gateway() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        this.conn = DriverManager.getConnection(host, user, pass);
        
    }
    
    public List<Book> ListOfBooks(){
       List<Book> booksList = new ArrayList<>();
            try (Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery("SELECT * FROM book");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String title = rs.getString("title");
                    String description = rs.getString("descriptions");
                    String isbn = rs.getString("isbn");
                    Author myAuthor = new Author(rs.getString("author_first_name"), rs.getString("author_last_name"));
                    String publisherCompany = rs.getString("publisher_company");
                    String publisherAddress = rs.getString("publisher_address");
                    String mimeType = rs.getString("mimeType");

                    Book myBook = null;
                    Blob picture = rs.getBlob("cover");
                    if (picture == null) {
                        myBook = new Book(id, title, description, isbn, myAuthor, publisherCompany, publisherAddress, null);
                    } else {
                        byte[] pictureData = picture.getBytes(1, (int) picture.length());
                        CoverImage myCover = new CoverImage(mimeType, pictureData);
                        myBook = new Book(id, title, description, isbn, myAuthor, publisherCompany, publisherAddress, myCover);
                    }
                    booksList.add(myBook);
                }
                return booksList;
            } catch (SQLException e) {
                return null;
            } 
        
    }
    
    
    public Book getInfoById(int id){
                   Book Book = new Book();
            try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM book WHERE id=?")) {
                stmt.setInt(1, id);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        Book.setId(parseInt(rs.getString("id")));
                        Book.setTitle(rs.getString("title"));
                        Book.setDescription(rs.getString("descriptions"));
                        Book.setIsbn(rs.getString("isbn"));
                        String author_first_name = rs.getString("author");
                        String author_last_name = rs.getString("author_last_name");
                        Author myAuthor = new Author(author_first_name, author_last_name);
                        Book.setAuthor(myAuthor);
                        Book.setPubName(rs.getString("publisher_company"));
                        Book.setPubAddress(rs.getString("publisher_address"));
                        String mimeType = rs.getString("mimeType");
                        Blob picture = rs.getBlob("cover");

                        if (picture == null) {
                            Book.setCover(null);
                        } else {
                            byte[] pictureData = picture.getBytes(1, (int) picture.length());
                            CoverImage myCover = new CoverImage(mimeType, pictureData);
                            Book.setCover(myCover);
                        }
                    }
                    return Book;
                }
            } catch (SQLException e) {
                return null;
            }
        
        
        
        
    }

    public Book getInfoByIsbn(String isbn)
   {
                    Book Book = new Book();
            try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM book WHERE isbn=?")) {
                stmt.setString(1, isbn);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        Book.setId(parseInt(rs.getString("id")));
                        Book.setTitle(rs.getString("title"));
                        Book.setDescription(rs.getString("descriptions"));
                        Book.setIsbn(rs.getString("isbn"));
                        String author_first_name = rs.getString("author_first_name");
                        String author_last_name = rs.getString("author_last_name");
                        Author myAuthor = new Author(author_first_name, author_last_name);
                        Book.setAuthor(myAuthor);
                        Book.setPubName(rs.getString("publisher_company"));
                        Book.setPubAddress(rs.getString("publisher_address"));
                        String mimeType = rs.getString("mimeType");
                        Blob picture = rs.getBlob("cover");

                        if (picture == null) {
                            Book.setCover(null);
                        } else {
                            byte[] pictureData = picture.getBytes(1, (int) picture.length());
                            CoverImage myCover = new CoverImage(mimeType, pictureData);
                            Book.setCover(myCover);
                        }
                    }
                    return Book;
                }
            } catch (SQLException e) {
                return null;
            }
        
        
        
    }
    
    public int InsertNewBook(Book Book) {
                try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO book (id, title, descriptions, isbn, author_first_name, author_last_name, publisher_company, publisher_address) Values(?, ?, ?, ?, ?, ?, ?, ?)")) {
                stmt.setInt(1, Book.getId());
                stmt.setString(2, Book.getTitle());
                stmt.setString(3, Book.getDescription());
                stmt.setString(4, Book.getIsbn());
                stmt.setString(5, Book.getAuthorname());
                stmt.setString(6, Book.getAuthorlastname());
                stmt.setString(7, Book.getPubName());
                stmt.setString(8, Book.getPubAddress());
                stmt.executeUpdate();
                return Book.getId();
            } catch (SQLException e) {
                return -1;
            }
        }
    
    
    
     public boolean updateBook(int id, Book Book){

            try (PreparedStatement stmt = conn.prepareStatement("UPDATE book SET title=?, descriptions=?, isbn=?, author_first_name=?, author_last_name=?, publisher_company=?, publisher_address=? WHERE id=?")) {
                 stmt.setInt(1, Book.getId());
                stmt.setString(2, Book.getTitle());
                stmt.setString(3, Book.getDescription());
                stmt.setString(4, Book.getIsbn());
                stmt.setString(5, Book.getAuthorname());
                stmt.setString(6, Book.getAuthorlastname());
                stmt.setString(7, Book.getPubName());
                stmt.setString(8, Book.getPubAddress());
                stmt.executeUpdate();
                return true;
            } catch (SQLException e) {
                return false;
            }
        }
     

     
     public boolean setImage(int myId, String mimeType, InputStream inputStream){
         try (PreparedStatement stmt = conn.prepareStatement("UPDATE book SET mimeType=?, cover=? WHERE id=?")) {
                stmt.setString(1, mimeType);
                stmt.setBlob(2, inputStream);
                stmt.setInt(3, myId);
                stmt.executeUpdate();
                return true;
            } catch (SQLException e) {
                return false;
            }
     }
     
     
     public boolean deleteBook(int id){
          try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM book WHERE id=?")) {
                stmt.setInt(1, id);
                stmt.executeUpdate();
                return true;
            } catch (SQLException e) {
                return false;
            }
         
     } 
     
      public boolean deleteAll(){
            try (Statement stmt = conn.createStatement()) {
                stmt.executeUpdate("DELETE FROM book");
                return true;
            } catch (SQLException e) {
                return false;
            }
      }
     
     
     
     
}
    
    
    
    






    
    
    

