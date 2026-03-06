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
 
 create table Employees  (
	ID int primary key auto_increment,
    EmpName varchar (30),
    Dept varchar(20),
    Salary double 
 );
 
 alter table employees add column location varchar (20);
 select * from employees;
 create database customerManagement;
 use customerManagement;
 
 create table customers(
	CustID int primary key auto_increment,
    name varchar(30) not null,
    email varchar(30) unique,
    password varchar(20) not null
 );
 
 INSERT INTO Employees (EmpName, Dept, Salary) VALUES 
('Guru Prasad', 'Development', 75000.00),
('Anjali Rao', 'Design', 68000.00),
('Rahul Sharma', 'Marketing', 55000.00),
('Sneha Kapoor', 'Development', 72000.00),
('Vikram Singh', 'HR', 60000.00);

UPDATE Employees SET Location = 'Bengaluru' WHERE ID = 1;
UPDATE Employees SET Location = 'Mumbai' WHERE ID = 2;
UPDATE Employees SET Location = 'Delhi' WHERE ID = 3;
UPDATE Employees SET Location = 'Chennai' WHERE ID = 4;
UPDATE Employees SET Location = 'Hyderabad' WHERE ID = 5;
 
 insert into customers(name,email,password) values('Jack','jack@gmail.com','Jack@123'),
	('John','john@gmail.com','John@123');
    
select * from customers;
 
 create table accounts(
	Acc_NO int primary key auto_increment,
    Cust_ID int,
    Acc_Type varchar(20), -- ex, 'Savings','Current'
    Balance double default 0.0,
    foreign key(Cust_ID)references customers(CustID)
 );
 
 select * from accounts;
 
 CREATE TABLE Transactions(
	TransID int primary key auto_increment,
    ACC_No int,
    TransType varchar(20), -- 'Deposit', 'Withdrawl','Transfer'
    Amount double,
    TransDate timestamp default current_timestamp,
    foreign key(ACC_No) references accounts(Acc_NO)
 );
 
 select * from transactions;
 
 create database AdminDatabase;
 
 create table AdminDetails(
 AdminID INT PRIMARY KEY auto_increment,
 Name varchar(30) not null,
 Email varchar(30),
 Password varchar(20) not null);
 
 
 
 