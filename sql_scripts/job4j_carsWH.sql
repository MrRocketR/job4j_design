CREATE table body(
id serial primary key,
name varchar(255)
);
CREATE table engine(
id serial primary key,
name varchar(255)

);
CREATE table gearbox(
id serial primary key,
name varchar(255)
);

CREATE table car(
id serial primary key,
name varchar(255),
body_id int references body(id),
engine_id int references engine(id),
gearbox_id int references gearbox(id)
);

INSERT into engine (name) values ('L6');
INSERT into engine (name) values ('V6');
INSERT into body (name) values ('small');
INSERT into body (name) values ('medium');
INSERT into body (name) values ('big');
INSERT into gearbox (name) values ('Auto');
INSERT into gearbox (name) values ('Manual');

INSERT into car (name, body_id, engine_id, gearbox_id) values ('BMW',2,1,1);
INSERT into car (name, body_id, engine_id, gearbox_id) values ('Land Rover',3,1,1);
INSERT into car (name, body_id, engine_id, gearbox_id) values ('Toyota Supra',1,1,2);
INSERT into car (name, body_id, engine_id, gearbox_id) values ('Ferrari ',1,2,1);
INSERT into car (name, body_id, engine_id, gearbox_id) values ('Buick',2,1,2);
INSERT into car (name, body_id, engine_id, gearbox_id) values ('Old Granny car',1,1,null);
INSERT into car (name, body_id, engine_id, gearbox_id) values ('pure car',null,null,2);

INSERT into engine (name) values ('old stange engine');
INSERT into body (name) values ('old strange body');
INSERT into gearbox (name) values ('old strange gearbox');

 /*
1) Вывести список всех машин и все привязанные к ним детали. Нужно учесть, что каких-то деталей машина может и не содержать.
 */
Select c.name, b.name
from car as c
full join body b
on c.body_id = b.id
union
select c.name, e.name
from car as c
full join engine as e
on c.engine_id = e.id
union
select c.name, g.name
from car as c
full join gearbox as g
on c.gearbox_id = g.id
 /*
2) Вывести отдельно детали (1 деталь - 1 запрос), которые не используются НИ в одной машине, кузова, двигатели, коробки передач.
 */
Select c.name, b.name
from car as c
full join body b
on c.body_id = b.id
where c.name is null
union
select c.name, e.name
from car as c
full join engine as e
on c.engine_id = e.id
where c.name is null
union
select c.name, g.name
from car as c
full join gearbox as g
on c.gearbox_id = g.id
where c.name is null