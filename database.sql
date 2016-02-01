CREATE DATABASE IF NOT EXISTS corpo_warehouse;

USE corpo_warehouse;

CREATE TABLE positions(
   id int not null auto_increment primary key,
   name varchar(255) not null
) ENGINE=InnoDB;

CREATE TABLE employees(
   id int not null auto_increment primary key,
   name varchar(255) not null,
   last_name varchar(255) not null,
   position_id int,
   FOREIGN KEY fk_position(position_id)
   REFERENCES positions(id)
   ON UPDATE CASCADE
   ON DELETE SET NULL
) ENGINE=InnoDB;

CREATE TABLE item_categories(
   id int not null auto_increment primary key,
   name varchar(255) not null,
) ENGINE=InnoDB;

CREATE TABLE items(
   id int not null auto_increment primary key,
   name varchar(355) not null,
   quantity int not null default 0,
   category_id int not null,
   FOREIGN KEY fk_category(category_id)
   REFERENCES item_categories(id)
   ON UPDATE CASCADE
   ON DELETE RESTRICT
)ENGINE=InnoDB;

CREATE TABLE possessions(
   id int not null auto_increment primary key,
   employee_id int not null,
   item_id int not null,
   FOREIGN KEY fk_employee(employee_id)
   REFERENCES employees(id)
   ON UPDATE CASCADE
   ON DELETE CASCADE,
   FOREIGN KEY fk_item(item_id)
   REFERENCES items(id)
   ON UPDATE CASCADE
   ON DELETE CASCADE
);


