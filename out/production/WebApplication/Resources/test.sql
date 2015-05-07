#use NewsBase;


CREATE TABLE newsbase.users
(
  idu INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name CHAR(20) NOT NULL,
  lastname CHAR(30) NOT NULL,
  password CHAR(40) NOT NULL,
  role INT
);
ALTER TABLE newsbase.users ADD CONSTRAINT unique_idu UNIQUE (idu);
ALTER TABLE newsbase.users ADD email CHAR(40) NOT NULL;

CREATE TABLE newsbase.pages
(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  parentid INT NOT NULL,
  title CHAR(70) NOT NULL,
  title4menu CHAR(50) NOT NULL,
  user INT NOT NULL,
  date DATE NOT NULL,
  maintext TEXT NOT NULL
);
ALTER TABLE newsbase.pages ADD CONSTRAINT unique_id UNIQUE (id);