CREATE TABLE IF NOT EXISTS book (
    id VARCHAR(256),
    title VARCHAR(256),
    author VARCHAR(256),
    book_year int
);

INSERT INTO book (id, title, author, book_year) VALUES
                                           (999, '1_TITLE', '1_AUTHOR', 1),
                                           (998, '2_TITLE', '2_AUTHOR', 2),
                                           (997, '3_TITLE', '3_AUTHOR', 3);