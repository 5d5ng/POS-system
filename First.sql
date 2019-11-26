create table product(
    barcode varchar2(14) primary key,
    pname varchar2(14) unique,
    ptype varchar2(14),
    pamount varchar2(14),
    expiration DATE,
    price int

);

create table customer(
    cname varchar2(140),
    phone varchar2(140) Primary key,
    grade varchar2(100),
    saving int,
    age int
    

);

create table books(
    barcode varchar2(14),
    amount int,
    pname varchar(14),
    method varchar2(14),  
    price int

);

create table administrator(
   password varchar2(15)

);

drop table customer;
drop table books;
drop table product;
commit;
select * from customer;
select * from books;
select * from product;
select * from administrator;

insert into customer values ('백다영','0104423','A',300,22);
insert into customer values ('오동의','0108524','S',300,22);
insert into customer values ('황영준','0104442','A',300,22);
insert into customer values ('이소연','0104426','A',300,22);
insert into customer values ('이소연','0104422','A',300,22);
insert into customer values ('제희수','0103422','B',300,22);
in
insert into product values ('a05',	'w카스'	,'주류',	'500'	,'2012.12.1',	'2300');
insert into product values ('a02',	'테라'	,'주류',	'500'	,'2019.12.21',	'2400');
insert into product values ('a03',	'화이트'	,'주류',	'500'	,'2019.12.25',	'2300');
insert into product values ('a04',	'좋은데이'	,'주류',	'230'	,'2019.11.22',	'2300');

insert into books values('d01',2,'코카콜라','card',3000);
insert into books values('d02',4,'펩시','card',3000);
insert into administrator values('1234');

update product set pamount = pamount + 3 where barcode = 'a01';
update customer set grade = 'A' , saving = 100 where phone = '0104423';
commit;