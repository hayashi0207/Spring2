CREATE TABLE
IF NOT EXISTS book
(
    book_id INT PRIMARY KEY,
    book_name VARCHAR
(50),
    book_publication_year INT
);

CREATE TABLE
IF NOT EXISTS m_user
(
    user_id VARCHAR
(50) PRIMARY KEY,
    password VARCHAR
(100),
    user_name VARCHAR
(50),
    birthday DATE,
    age INT,
    role VARCHAR
(50)
);