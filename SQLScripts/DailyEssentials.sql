create database db_example; -- Creates the new database
create user 'springuser'@'%' identified by 'ThePassword'; -- Creates the user
grant all on db_example.* to 'springuser'@'%'; -- Gives all privileges to the new user on the newly created database

CREATE TABLE db_example.user (
  `id` int NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

use db_example;
insert into db_example.user (id, email, name, password) values (1, 'someemail@someemailprovider.com', 'First', 'mypassword');
insert into db_example.user (id, email, name, password) values (2, 'someemail@someemailprovider.com', 'Second', 'mypassword2');
insert into db_example.user (id, email, name, password) values (6, 'admin@admin.com', 'admin', 'admin');

select * from user;