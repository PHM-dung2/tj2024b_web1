drop database if exists boardservice11;
create database boardservice11;
use boardservice11;

create table board(
	bno int auto_increment,
    constraint primary key( bno ),
    btitle varchar(30) not null,
    bcontent longtext not null,
    bwriter varchar(30) not null,
    bview int default 0,
    bpwd varchar(30) not null,
    bdate datetime default now()
);

select * from board;