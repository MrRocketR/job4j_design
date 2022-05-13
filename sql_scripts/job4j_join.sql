CREATE table departments (
id serial primary key,
name VARCHAR(255)
);
CREATE table employees (
id serial primary key,
name VARCHAR(255),
department_id int references departments(id)
);

INSERT into departments (name) values ('support');
INSERT into departments (name) values ('managers');
INSERT into departments (name) values ('testers');
INSERT into departments (name) values ('programmers');
INSERT into departments (name) values ('fake departament of null affairs');
INSERT into employees (name, department_id) values ('Maria', 1);
INSERT into employees (name, department_id) values ('Anna', 1);
INSERT into employees (name, department_id) values ('AngryBoss', 2);
INSERT into employees (name, department_id) values ('GhostBoss', null);
INSERT into employees (name, department_id) values ('Bot', 3);
INSERT into employees (name, department_id) values ('Bender', 3);
INSERT into employees (name, department_id) values ('Sparky', 3);
INSERT into employees (name, department_id) values ('Kolya', 4);
INSERT into employees (name, department_id) values ('Petya', 4);
INSERT into employees (name, department_id) values ('Oleg', 4);
INSERT into employees (name, department_id) values ('GhostEmployee', null);

/* 3. Используя left join найти департаменты, у которых нет работников */

SELECT * From employees e
right join departments d
on e.department_id = d.id;

/*  4. Используя left и right join написать запросы, которые давали бы одинаковый результат
(порядок вывода колонок в эти запросах также должен быть идентичный). */

SELECT * From employees e
left join departments d
on e.department_id = d.id;

SELECT * From departments d
right join employees e
on e.department_id = d.id;

/* 5. Создать таблицу teens с атрибутами name, gender и заполнить ее.
Используя cross join составить все возможные разнополые пары */

CREATE table teens (
id serial primary key,
name varchar(255),
gender varchar(1)
);

INSERT into teens (name, gender) values ('Masha', 'F');
INSERT into teens (name, gender) values ('Misha', 'M');
INSERT into teens (name, gender) values ('Dasha', 'F');
INSERT into teens (name, gender) values ('Oleg', 'M');
INSERT into teens (name, gender) values ('Anna', 'F');

Select teens.name, teens.gender, t.name, t.gender from teens
cross join teens t
where teens.gender != t.gender;