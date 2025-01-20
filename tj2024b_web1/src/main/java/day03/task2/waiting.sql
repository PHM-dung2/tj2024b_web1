drop database if exists waitingDB;
create database waitingDB;
use waitingDB;

create table waiting(
	wno int auto_increment,
    constraint primary key ( wno ),
    phone varchar(13) not null,
    count int not null
);

select * from waiting;