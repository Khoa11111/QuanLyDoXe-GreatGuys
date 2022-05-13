create database QuanLyDoXe
go

use QuanLyDoXe
go

create table Account(
	userName varchar(100) not null primary key,
	pass varchar(100) not null
)	
go

insert into Account
values ('Quanlydoxe','maths2002'),
	   ('khoa334','khoa4431'),
	   ('khoa977','khoa1')

create table NhanVien(
	maNV varchar(100) not null primary key,
	tenNV varchar(100) not null,
	ngaysinh Date not null ,
	gioitinh varchar(3) not null,
	loaiNV varchar(100) not null,
	diachi varchar(100)  null,
	SDT varchar(11) not null,
	matkhauNV varchar(100) not null
)
go

insert into NhanVien(maNV,tenNV,ngaysinh,gioitinh,loaiNV,diachi,SDT,matkhauNV)
values ('205131','Hoang Thi Phi','2002/10/1','nu','Nhan Vien thuong','k81 ngo diem','0968845331','chubemocoi'),
	   ('205123','Thai Thi nhi','1988/4/10','nu','Nhan Vien thuong','k44 hoang dieu','0899431732','chubehienlanh'),
	   ('205177','Tran Hung Dung','1995/10/13','nam','Nhan Vien quan ly ve','45 ngo dinh diem','0981445678','chubengungo')
go

create table QuanLyVe_va_Xe(
	bienso varchar(100) not null primary key,
	masove varchar(100) not null,
	loaixe varchar(100) null,
	tenxe varchar(100) null,
	mauxe varchar(100) null,
	ngayraben varchar(50) not null,
	nayvaoben varchar(50) null
)
go

insert into QuanLyVe_va_Xe
values ('Ck101','K2309','Xe may','Honda','Den','10/3/2002','2022/5/4'),
	   ('Ck123','K2311','Xe oto',null,null,'11/9/2003','2022/5/4')