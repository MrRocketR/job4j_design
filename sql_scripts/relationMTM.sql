CREATE table animals (
 id serial primary key,
	name varchar(255)
);

CREATE table aviary (
 id serial primary key,
	type VARCHAR(255)
);

CREATE table zoo (
 id serial primary key,
	name varchar(255),
	animal_id int references animals(id),
	aviary_id int references aviary(id)
);

insert into animals (name) values ('Lion');
insert into animals (name) values ('Pengiun');
insert into aviary (type) values ('savanna');
insert into animals (name) values ('Arctic');
insert into zoo (name, animal_id, aviary_id) values ('NY_ZOO',1, 1);
insert into zoo (name, animal_id, aviary_id) values ('NY_ZOO',2, 1);
SELECT * FROM zoo;
