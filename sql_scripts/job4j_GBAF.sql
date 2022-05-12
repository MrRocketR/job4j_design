
create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);


insert into devices (name, price) values ('Iphone','56.2');
insert into devices (name, price) values ('Ipad','38.12');
insert into devices (name, price) values ('Nokia','9.99');
insert into devices (name, price) values ('Samsung','50.0');
insert into people (name) values ('Oleg');
insert into people (name) values ('Masha');
insert into people (name) values ('Dasha');
insert into people (name) values ('Vasya');

insert into devices_people (device_id, people_id) values (1,3);
insert into devices_people (device_id, people_id) values (2,1);
insert into devices_people (device_id, people_id) values (2,1);
insert into devices_people (device_id, people_id) values (3,4);
insert into devices_people (device_id, people_id) values (4,2);
insert into devices_people (device_id, people_id) values (2,2);
insert into devices_people (device_id, people_id) values (1,2);

select avg(price)
from devices;

select avg(devices.price), people.name
from devices_people as dp
inner join devices
on dp.device_id = devices.id
inner join people
on dp.people_id = people.id
group by people.name;

select avg(devices.price), people.name
from devices_people as dp
inner join devices
on dp.device_id = devices.id
inner join people
on dp.people_id = people.id
group by people.name
having avg(devices.price) > '40';