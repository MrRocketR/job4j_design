CREATE TABLE subjects (
id serial primary key,
	course int,
	subject_name VARCHAR(50),
	modules text	
);
insert into subjects (course, subject_name, modules)
values ('1', 'Physics', 
		'Mechanic, Electronic, Optic, Atomic');
update subjects  set text = 'Mechanic, Electronic, Optic';
delete from subjects;
select * from subjects;
