
create database JAVA5NHANSU


create table Users(
	username nvarchar(50) not null primary key,
	password nvarchar(50) not null,
	fullname nvarchar(50) not null,
	role bit
)

create table Departs  (
	id int identity(1,1) not null primary key,
	nameDepart nvarchar(50) not null
)

CREATE TABLE Staffs(
	id int IDENTITY(1,1) primary key,
	name nvarchar(50) NOT NULL,
	gender bit NOT NULL,
	birthday date NOT NULL,
	photo nvarchar(50) NULL,
	email nvarchar(50) NOT NULL,
	phone nvarchar(25) NOT NULL,
	salary float NOT NULL,
	note nvarchar(500) NULL,
	departId int NULL,
	FOREIGN KEY(departId) REFERENCES Departs(id) ON DELETE SET NULL ON UPDATE CASCADE,
)
GO
insert into Staffs values (N'Vu Minh Hieu', 1, N'11/28/2000', N'tep.jpg',N'hieuvm@gmail.com', N'0944572000', 15000, N'Ko co ghi chu', 2)
create table Records (
	id int identity(1,1) not null primary key,
	type nvarchar(50) not null,
	reason nvarchar(200),
	date datetime,
	staffId int,
	FOREIGN KEY(staffId) REFERENCES Staffs(id) ON DELETE CASCADE ON UPDATE CASCADE,
)
insert into Records values (N'Tốt', N'Nhân viên suất xắc', GETDATE(), 1)
insert into Departs values (N'IT')
insert into Departs values (N'Nhân Sự')
insert into Departs values (N'Kế Toán')
insert into Departs values (N'Maketing')
insert into Departs values (N'Hành Chính')


select * from Departs
select * from Staffs where name like '%tùng%'

delete from Users where username = N''

select * from Users

select * from Staffs
select * from Records
SELECT Staffs.id, SUM(case when Records.type= 'Good' then 1 else 0 end), SUM(case when Records.type= 'Not Good' then 1 else 0 end) FROM Records join Staffs on Staffs.id = Records.staffId GROUP BY Staffs.id

drop table Departs
drop table Records
drop table Staffs
