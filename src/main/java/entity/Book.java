package entity;

public class Book {
    private int book_id;
    private String book_title;
    private String author;
    private String genre;
    private boolean book_availability;

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isBook_availability() {
        return book_availability;
    }

    public void setBook_availability(boolean book_availability) {
        this.book_availability = book_availability;
    }
}
