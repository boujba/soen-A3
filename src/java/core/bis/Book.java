package core.bis;


public class Book {
    
    private static int idCounter = 1;
    
    private int id;
    private String isbn;
    private String title;
    private String description;
    private Author author;
    private CoverImage cover;
    private String pubname;
    private String pubaddr;
    
    public Book(){
        this.id = 0;
        this.isbn = "";
        this.title = "";
        this.description = "";
        this.author = null;
        this.cover = null;
    }

    public Book(String isbn, String title, String description, Author author , String pubName, String pubAddress, CoverImage cover) {
                
        this.id = idCounter;
        idCounter++;
        
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.author = author;
        this.pubname = pubName;
        this.pubaddr = pubAddress;
        this.cover = cover;
        
    }
    
    public Book(int id, String isbn, String title, String description, Author author, String pubName, String pubAddress, CoverImage cover) {
        
        this.id = id;        
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.author = author;
        this.pubname = pubName;
        this.pubaddr = pubAddress;
        this.cover = cover;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthorname() {
        return  author.getFirstname();
    }
    public String getAuthorlastname() {
        return   author.getLastname();
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
    
    public String getPubName() {
        return pubname;
    }

    public void setPubName(String pName) {
        this.pubname = pName;
    }

    public String getPubAddress() {
        return pubaddr;
    }

    public void setPubAddress(String pAddr) {
        this.pubaddr = pAddr;
    }

    public CoverImage getCover() {
        return cover;
    }

    public void setCover(CoverImage cover) {
        this.cover = cover;
    }
    
    public void setBookIDCount(int count)
    {
        this.idCounter = count;
    }
    

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", isbn=" + isbn + ", title=" + title + ", description=" + description + ", author=" + author.toString() + ", cover=" + cover.toString() + '}';
    }
    
    public void outputBook()
    {
        System.out.println("Book: ID = " + this.id + " ISBN = " + this.isbn + " Title = " + this.title + " Description = " + this.description + " Author = " + this.author.toString() + " Cover = " + this.cover.toString());

    }

    public int getCoverImageData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}