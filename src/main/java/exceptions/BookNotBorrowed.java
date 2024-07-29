package exceptions;

public class BookNotBorrowed extends Exception {
    public BookNotBorrowed(String str) {
        super(str);
    }
}
