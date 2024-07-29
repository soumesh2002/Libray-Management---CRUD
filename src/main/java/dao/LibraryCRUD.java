package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.GetConnection;
import entity.Book;
import exceptions.BookNotBorrowed;
import exceptions.BookNotReturned;

public class LibraryCRUD implements Transactions {
    Connection connection;
    Statement statement;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    public LibraryCRUD() throws SQLException {
        connection = GetConnection.getDatabaseConnection();
        statement = connection.createStatement();
    }

    @Override
    public void borrowBook(Book book) throws BookNotBorrowed, SQLException {
        String checkAvailabilityQuery = "SELECT book_availability FROM Books WHERE book_title = ?";
        String updateLibrary = "UDPATE SET book_availability = ? WHERE book_title = ?";

        preparedStatement = connection.prepareStatement(checkAvailabilityQuery);
        preparedStatement.setString(1, book.getBook_title());
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            boolean isAvailable = resultSet.getBoolean("book_availability");

            if (isAvailable) {
                preparedStatement = connection.prepareStatement(updateLibrary);
                preparedStatement.setBoolean(1, false);
                preparedStatement.setString(2, book.getBook_title());
                int updateRows = preparedStatement.executeUpdate();
                if (updateRows > 0) {
                    System.out.println("Book borrowed successfully");
                    book.setBook_availability(false);
                } else {
                    throw new BookNotBorrowed("Book cannot be borrowed, wait for the borrower to return it.");
                }
            } else {
                System.out.println("Book not found");
                return;
            }
        } else {
            System.out.println("Book not found");
        }
    }

    @Override
    public void returnBook(Book book) throws BookNotReturned, SQLException {
    }

    public void viewTable() throws SQLException {
        String viewQuery = "SELECT * FROM Books;";
        preparedStatement = connection.prepareStatement(viewQuery);
        ResultSet readData = preparedStatement.executeQuery();
        while (readData.next()) {
            Book books = new Book();
            books.setBook_id(readData.getInt("book_id"));
            books.setBook_title(readData.getString("book_title"));
            books.setAuthor(readData.getString("author"));
            books.setGenre(readData.getString("genre"));
            System.out.println(books.getBook_id() + " " + books.getBook_title() + " " + books.getAuthor() + " "
                    + books.getGenre());
        }
    }
}
