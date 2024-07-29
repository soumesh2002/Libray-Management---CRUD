package main;

import java.sql.SQLException;

import dao.LibraryCRUD;
import entity.Book;
import exceptions.BookNotBorrowed;

public class LibraryMain {
    public static void main(String[] args) throws SQLException, BookNotBorrowed {
        LibraryCRUD libcrud = new LibraryCRUD();
        Book books = new Book();
        books.setBook_title("The Great Gatsby");

        libcrud.viewTable();
        libcrud.borrowBook(books);
        books.setBook_availability(false);

        libcrud.viewTable();
    }
}
