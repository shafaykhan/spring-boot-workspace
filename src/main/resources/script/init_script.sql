drop database local_database;
create database local_database;
use local_database;

drop table if exists user;
create table user
(
    id        int primary key auto_increment,
    name      varchar(55)                null,
    city      varchar(55)                null,
    mobile_no varchar(20)                null,
    status    enum ('ACTIVE','INACTIVE') not null default 'ACTIVE'
);