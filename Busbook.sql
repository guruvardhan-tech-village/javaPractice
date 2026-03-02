create database BusBookingSystem;
use BusBookingSystem;

create table BusAdmin (
Name varchar(30),
Email varchar(30) unique not null,
Password varchar(30) not null);

alter table BusAdmin
add column AdminID int primary key auto_increment first;

select * from BusAdmin;

INSERT INTO BusAdmin (Name,Email,Password) values('Guru','guru@gmail.com','Guru@123');

create table BusCostomers(
Name varchar(30),
Email varchar(30) unique,
PhoneNo varchar(18),
Password varchar(20) not null);

ALTER table BusCostomers 
ADD column CustID int primary key auto_increment first;

select * from BusCostomers;

create table BusDetails(
	BusID int primary key auto_increment,
	BusNo varchar(20) unique,
	BusName varchar(20) not null
);

SELECT * FROM Busdetails;

create table Bookings(
	CustID int,
    Name varchar(30),
    SourcePlace varchar(30),
    Destination varchar(30),
    Fare double,
    PayStatus varchar(15), -- ex 'Paid', 'NotPaid'
    foreign key (CustID) references BusCostomers(CustID)
	);

ALTER TABLE Bookings
ADD column BusID int,
add foreign key (BusID)
references BusDetails(BusID);


