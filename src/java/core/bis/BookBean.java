/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.bis;



import java.util.ArrayList;


public class BookBean {
    private ArrayList<Book> bookList = new ArrayList<Book>();
    
    public String getName(){
        return "Book Bean";
    }
    
    public void setBooklisk(ArrayList<Book> books) {
        for(Book book:books){
            bookList.add(book);
        }
    }

    public ArrayList<Book> getBooks() {
        return bookList;
    }
}
