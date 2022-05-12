
CREATE table partner (
 id serial primary key,
	sex varchar(2),
	fname varchar(255),
	lname varchar(255)
);

CREATE table person (
 id serial primary key,
	sex varchar(2),
	fname varchar(255),
	lname varchar(255),
	partner_id int references partner(id) unique
);

insert into partner (sex, fname, lname) values ('F','Ivana','Testova');
insert into person (sex, fname, lname, partner_id) values ('M','Ivan','Testov',1);
SELECT * FROM person;
