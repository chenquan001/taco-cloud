create table if not exists Ingredient (
 id varchar(4) not null,
 name varchar(25) not null,
 type varchar(10) not null
);

create table if not exists Taco (
 id identity,
 name varchar(50) not null,
 createdAt timestamp not null
);

create table if not exists Taco_Ingredient (
 taco_id bigint not null,
 ingredients_id varchar(4) not null
);

alter table Taco_Ingredient
 add foreign key (taco_id) references Taco(id);
alter table Taco_Ingredient
 add foreign key (ingredients_id) references Ingredient(id);

create table if not exists Taco_Order (
 id identity,
 name varchar(50) not null,
 street varchar(50) not null,
 city varchar(50) not null,
 state varchar(50) not null,
 zip varchar(50) not null,
 ccNumber varchar(16) not null,
 ccExpiration varchar(5) not null,
 ccCVV varchar(3) not null,
 placedAt timestamp not null
);

create table if not exists Taco_Order_Taco (
 taco_Order_id bigint not null,
 tacos_id bigint not null
);

alter table Taco_Order_Taco
 add foreign key (taco_Order_id) references Taco_Order(id);
alter table Taco_Order_Taco
 add foreign key (tacos_id) references Taco(id);

 CREATE SEQUENCE if not exists HIBERNATE_SEQUENCE START WITH 1 INCREMENT BY 1;