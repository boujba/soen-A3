DROP DATABASE IF EXISTS books;

CREATE DATABASE books;

USE books;

CREATE TABLE book (
	id INTEGER NOT NULL,
	title VARCHAR(100),
	descrption VARCHAR(100),
	isbn VARCHAR(13) UNIQUE,
	authorname VARCHAR(50),
	authorlastname VARCHAR(50),
	publishername VARCHAR(50),
	publisheraddr VARCHAR(100),
    
	cover BLOB,
	PRIMARY KEY(id)
);
