CREATE table product (
 id serial primary key,
	price int,
	name varchar(255)
);
CREATE table costumer (
 id serial primary key,
	phone int,
	email VARCHAR (255),
	product_id int references product(id)
);
insert into product (price, name) values ('11', 'razor');
insert into costumer (phone, email, product_id) values ('7123', 'blabla@bla.bla', 1);
SELECT * FROM product;
SELECT * FROM costumer;