create database companydb;
use companydb;
select * from cars;
select * from student;

CREATE TABLE employee (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    department VARCHAR(50),
    salary DOUBLE
);

ALTER TABLE employee RENAME TO employees;

create database EmployeeCRUD;

use EMployeeCRUD;

 CREATE TABLE  Attendance(
	Id INT PRIMARY KEY auto_increment,
    NAME varchar(30),
    Subject varchar(20),
    Status varchar(20),
    Date DATE
 );
 
 select * from attendance;
 
 create database customerManagement;
 use customerManagement;
 
 create table customers(
	CustID int primary key auto_increment,
    name varchar(30) not null,
    email varchar(30) unique,
    password varchar(20) not null
 );
 
 insert into customers(name,email,password) values('Jack','jack@gmail.com','Jack@123'),
	('John','john@gmail.com','John@123');
 
 create table accounts(
	Acc_NO int primary key auto_increment,
    Cust_ID int,
    Acc_Type varchar(20), -- ex, 'Savings','Current'
    Balance double default 0.0,
    foreign key(Cust_ID)references customers(CustID)
 );