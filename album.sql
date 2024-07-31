create database album;
use album;
create table album (
	id  int(3) NOT NULL AUTO_INCREMENT,
	album varchar(120) NOT NULL,
	artist varchar(220) NOT NULL,
	languages varchar(120),
	PRIMARY KEY (id)
);

select *
from album;

