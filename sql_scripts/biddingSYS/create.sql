
CREATE table role (
id serial primary key,
role_type VARCHAR(1)
);
CREATE table users (
id serial primary key,
name VARCHAR(255),
password VARCHAR(255),
role_id int references role(id)  
);

CREATE table rules (
id serial primary key,
name text
);
CREATE table roleANDrules (
id serial primary key,
name text,
rule_id int references rules(id),
role_id int references role(id)
);

CREATE table state (
id serial primary key,
status VARCHAR(255)
);

CREATE table category (
id serial primary key,
name VARCHAR(255)
);

CREATE table items (
id serial primary key,
name text,
user_id int references users(id),
category_id int references category(id),
state_id int references state(id)	
);

CREATE table attachs (
id serial primary key,
img bytea,
item_id int references items(id)	
);

CREATE table comments (
id serial primary key,
comm text,
item_id int references items(id)
);