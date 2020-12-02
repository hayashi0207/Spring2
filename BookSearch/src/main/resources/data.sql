INSERT INTO book
    (book_id,book_name,book_publication_year)
VALUES
    (1, 'Spring解体新書', 2019),
    (2, 'Spring Security解体新書', 2020),
    (3, 'Java デザインパターン', 2017);

INSERT INTO m_user
    (user_id,password,user_name,birthday,age,role)
VALUES('hayashi@xxx.co.jp', 'password', '林太郎', '1990-01-01', 28, 'ROLE_ADMIN');