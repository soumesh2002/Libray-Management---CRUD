package dao;

import java.sql.SQLException;

import entity.Book;
import exceptions.BookNotBorrowed;
import exceptions.BookNotReturned;

public interface Transactions {
    void borrowBook(Book book) throws BookNotBorrowed, SQLException;

    void returnBook(Book book) throws BookNotReturned, SQLException;
}
