CREATE database hospital;
use hospital;
drop table doctor;
create table doctor
(
    id        int primary key auto_increment,
    name      varchar(255),
    specialty varchar(255)
);
insert into doctor(name,specialty)
values ('duong','ngoai'),
       ('lan','noi'),
       ('hoa','ngoai');
select specialty,COUNT(specialty) as count from doctor group by specialty;
create table Medicine
(
    id            int primary key auto_increment,
    medicine_name varchar(255),
    stock         int
);
INSERT INTO Medicine (medicine_name, stock)
VALUES ('Aspirin', 50),
       ('Ibuprofen', 75),
       ('Amoxicillin', 30);
create table bed
(
    id         int auto_increment primary key,
    bed_status boolean
);
INSERT INTO bed (bed_status)
VALUES (true),
       (false),
       (true),
       (false);
select *
from bed;
create table patient
(
    id   int auto_increment primary key,
    name varchar(255)
);
INSERT INTO patient (name)
VALUES ('Tran Thi B'),
       ('Le Van C'),
       ('Pham Van D');