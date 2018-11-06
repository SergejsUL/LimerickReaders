package ie.ul.serge.limerickreaders;

public class Book {
    private	String	BookID;
    private	String	UserID;
    private	String	Title;
    private	String	Author;
    private	String	Picture;
    private	String	Status;
    private	boolean	Reading_now;
    private int pages;

    public Book() {

    }

    public Book(String bookID, String userID, String title, String author) {
        BookID = bookID;
        UserID = userID;
        Title = title;
        Author = author;
        Reading_now=true;
        Status = "reading";
        pages = 0;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setBookID(String bookID) {
        BookID = bookID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public void setPicture(String picture) {
        Picture = picture;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public void setReading_now(boolean reading_now) {
        Reading_now = reading_now;
    }

    public String getBookID() {
        return BookID;
    }

    public String getUserID() {
        return UserID;
    }

    public String getTitle() {
        return Title;
    }

    public String getAuthor() {
        return Author;
    }

    public String getPicture() {
        return Picture;
    }

    public String getStatus() {
        return Status;
    }

    public boolean isReading_now() {
        return Reading_now;
    }
}
