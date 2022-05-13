CREATE table costumer (
id serial primary key,
name VARCHAR(255),
money int
);
CREATE table product (
id serial primary key,
name VARCHAR(255),
price int,
costumer_id int references costumer(id)
);

insert into costumer (name, money) values ('Ivan','100');
insert into costumer (name, money) values ('Andrew','0');
insert into costumer (name, money) values ('Maria','66');
insert into costumer (name, money) values ('Oleg','88');
insert into costumer (name, money) values ('Dimi','100');

insert into product (name, price, costumer_id) values ('Iphone','50',1);
insert into product (name, price, costumer_id) values ('ipad','30',1);
insert into product (name, price, costumer_id) values ('Iphone','50',3);
insert into product (name, price, costumer_id) values ('nokia','10',1);
insert into product (name, price, costumer_id) values ('nokia','10',3);
insert into product (name, price, costumer_id) values ('nokia','10',4);
insert into product (name, price, costumer_id) values ('old_potatoe_pc','0',2);
insert into product (name, price, costumer_id) values ('Iphone','50',5);
insert into product (name, price, costumer_id) values ('ipad','30',5);


select p.name, p.price, c.name, c.money
from product as p
join costumer as c
on p.costumer_id = c.id
where p.price <=30;

select p.name, p.price, c.name, c.money
from product as p
join costumer as c
on p.costumer_id = c.id
where p.name = 'ipad';

select distinct p.name, c.name
from product as p
join costumer as c
on p.costumer_id = c.id;

select distinct p.name as название_продукта, c.name as имя_клиента, p.price as цена
from product as p
join costumer as c
on p.costumer_id = c.id
order by p.price desc;

