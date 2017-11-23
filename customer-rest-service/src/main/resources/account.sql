create type enum_role as ENUM (
'USER', 'ADMIN');

create table account (
id integer not null primary key,
username varchar(30) not null unique,
password varchar(60) not null,
role enum_role not null
);