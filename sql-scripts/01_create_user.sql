-- CREATE USER 'newuser'@'localhost' IDENTIFIED BY 'password';
CREATE USER IF NOT EXISTS 'hbstudent'@'localhost' IDENTIFIED BY 'hbstudent';

GRANT SELECT, INSERT, UPDATE, DELETE, FILE ON *.* TO 'hbstudent'@'localhost';
GRANT ALL PRIVILEGES ON `hbstudent`.* TO 'hbstudent'@'localhost';
FLUSH PRIVILEGES;