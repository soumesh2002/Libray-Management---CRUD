-- CREATE DATABASE librarymanagementdb;
-- use librarymanagementdb;

CREATE TABLE Books (
    book_id INT AUTO_INCREMENT,
    book_title VARCHAR (255) NOT NULL,
    author VARCHAR (255) NOT NULL,
    genre VARCHAR (255) NOT NULL,
    book_availability BOOLEAN DEFAULT TRUE,
    PRIMARY KEY (book_id)
);

CREATE TABLE Users (
    user_id INT AUTO_INCREMENT,
    user_name VARCHAR (255)NOT NULL,
    user_email VARCHAR (255)NOT NULL,
    PRIMARY KEY (user_id)
);

CREATE TABLE Transactions (
    transaction_id INT AUTO_INCREMENT,
    user_id INT,
    book_id INT,
    transaction_date DATE,
    return_date DATE,
    FOREIGN KEY (user_id) REFERENCES Users (user_id),
    FOREIGN KEY (book_id) REFERENCES Books (book_id),
    PRIMARY KEY (transaction_id)
);

INSERT INTO Books (book_title, author, genre, book_availability)
VALUES
('The Great Gatsby', 'F. Scott Fitzgerald', 'Classic', TRUE),
('To Kill a Mockingbird', 'Harper Lee', 'Classic', TRUE),
('1984', 'George Orwell', 'Dystopian', TRUE),
('Pride and Prejudice', 'Jane Austen', 'Romance', TRUE),
('The Catcher in the Rye', 'J.D. Salinger', 'Classic', TRUE),
('The Hobbit', 'J.R.R. Tolkien', 'Fantasy', TRUE),
('Moby-Dick', 'Herman Melville', 'Adventure', TRUE),
('War and Peace', 'Leo and Tolstoy', 'Historical', TRUE),
('The Odyssey', 'Homer', 'Epic', TRUE),
('Crime and Punishment', 'Fyodor Dostoevsky', 'Philosophical', TRUE);

INSERT INTO Users (user_name, user_email) 
VALUES
('John Doe', 'John.doe@example.com'),
('Jane Smith', 'jane.smith@example.com'),
('Alice Johnson', 'alice.johnson@example.com'),
('Bob Brown', 'bob.brown@example.com'),
('Charlie Davis', 'charlie.davis@example.com'),
('Daisy Clark', 'daisy.clark@example.com'),
('Edward Wilson', 'edward.wilson@example.com'),
('Fiona Harris', 'fiona.harris@example.com'),
('George Thompson', 'george.thompson@example.com'),
('Helen Martinez', 'helen.martinez@example.com');

INSERT INTO Transactions (user_id, book_id, transaction_date, return_date)
VALUES
(1, 1,   '2024-07-01',   '2024-07-10'),
(2, 2,   '2024-07-02',   '2024-07-12'),
(3, 3,   '2024-07-03',   '2024-07-15'),
(4, 4,   '2024-07-04',   '2024-07-14'),
(5, 5,   '2024-07-05',   '2024-07-20'),
(6, 6,   '2024-07-06',   '2024-07-18'),
(7, 7,   '2024-07-07',   '2024-07-17'),
(8, 8,   '2024-07-08',   '2024-07-19'),
(9, 9,   '2024-07-09',   '2024-07-22'),
(10, 10, '2024-07-10',   '2024-07-25');

