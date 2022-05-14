CREATE table type(
id serial primary key,
name varchar(255)
);

CREATE table product(
id serial primary key,
name VARCHAR(255),
type_id int references type(id),
expired_date timestamp,
price int
);

INSERT into type (name) values ('СЫР');
INSERT into type (name) values ('МОЛОКО');
INSERT into type (name) values ('АЛКОГОЛЬ');
INSERT into type (name) values ('ХЛЕБ');


INSERT into type (name) values ('СЫР');
INSERT into type (name) values ('МОЛОКО');
INSERT into type (name) values ('АЛКОГОЛЬ');
INSERT into type (name) values ('ХЛЕБ');

INSERT into product (name, type_id, expired_date, price) values ('Сыр плавленный',1, '2022-06-12', '50');
INSERT into product (name, type_id, expired_date, price) values ('Сыр Java',1, '2022-09-15', '88');
INSERT into product (name, type_id, expired_date, price) values ('Сыр дружба',1, '2022-05-20', '5');
INSERT into product (name, type_id, expired_date, price) values ('Сыр моцарелла"',1, '2022-10-26', '250');
INSERT into product (name, type_id, expired_date, price) values ('Сыр мороженое',1, '2022-08-01', '20');
INSERT into product (name, type_id, expired_date, price) values ('Молоко мороженое',2, '2022-11-04', '80');
INSERT into product (name, type_id, expired_date, price) values ('Молоко Германия',2, '2022-11-12', '200');
INSERT into product (name, type_id, expired_date, price) values ('Молоко Россия',2, '2022-10-12', '10');
INSERT into product (name, type_id, expired_date, price) values ('Молоко Средиземья Ширское',2, '2023-1-13', '500');
INSERT into product (name, type_id, expired_date, price) values ('Пиво',3, '2025-11-11', '66');
INSERT into product (name, type_id, expired_date, price) values ('Водка мечта DevopsА',3 ,'2030-01-01', '101');
INSERT into product (name, type_id, expired_date, price) values ('Вино такое себе',3, '2022-05-01', '29');
INSERT into product (name, type_id, expired_date, price) values ('Алкоголь мороженое',3, '2022-04-03', '60');
INSERT into product (name, type_id, expired_date, price) values ('Хлеб свежий',4, '2022-07-10', '120');
INSERT into product (name, type_id, expired_date, price) values ('Хлеб не очень свежий',4, '2022-05-20', '60');
INSERT into product (name, type_id, expired_date, price) values ('Хлеб совсем несвежий',4, '2022-05-02', '30');
INSERT into product (name, type_id, expired_date, price) values ('Хлеб мороженое',4, '2022-09-02', '40');



/*1. Написать запрос получение всех продуктов с типом "СЫР" */

SELECT p.name, p.expired_date, p.price
from product as p
inner join type as t
on p.type_id = t.id
where t.name = 'СЫР';

/* 2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженое" */
SELECT p.name, p.expired_date, p.price
from product as p
inner join type as t
on p.type_id = t.id
where p.name like '%мороженое%';

/* 3. Написать запрос, который выводит все продукты, срок годности которых уже истек */
SELECT p.name, p.expired_date, p.price
from product as p
inner join type as t
on p.type_id = t.id
where p.expired_date < CURRENT_DATE;

/* 4. Написать запрос, который выводит самый дорогой продукт.  */
SELECT * from product
where price = (select max(price) from product)

/* 5. Написать запрос, который выводит для каждого типа количество продуктов к нему принадлежащих. В виде имя_типа, количество   */

SELECT count(p.type_id) as количество, t.name as имя_типа
from type as t
inner join product as p
on type_id = t.id
group by t.name;


/* 6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО" */

SELECT p.name as имя_продукта, t.name as тип, p.expired_date,  p.price
from product as p
join type as t
on p.type_id = t.id
where t.name = 'СЫР' or t.name = 'МОЛОКО'
ORDER BY тип asc;


/*
7. Написать запрос, который выводит тип продуктов, которых осталось меньше 5 штук.
Под количеством подразумевается количество продуктов определенного типа.
Например, если есть тип "СЫР" и продукты "Сыр плавленный" и "Сыр моцарелла",
которые ему принадлежат, то количество продуктов типа "СЫР" будет 2.  */

SELECT count(p.type_id) as количество, t.name as имя_типа
from type as t
inner join product as p
on type_id = t.id
group by t.name
having count(p.type_id) < 5;


/* 8. Вывести все продукты и их тип. */
SELECT p.name as имя_продукта, t.name as тип, p.expired_date,  p.price
from product as p
join type as t
on p.type_id = t.id
ORDER BY тип asc;