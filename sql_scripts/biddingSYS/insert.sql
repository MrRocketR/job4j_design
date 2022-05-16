INSERT into role (name) values ('admin');
INSERT into users (name, password, role_id) values ('admin', 'admin', 1);
INSERT into rules (name) values ('rwd');
INSERT into roleANDrules (name, rule_id, role_id) values ('main_rule', 1, 1);
INSERT into category (name) values ('admin_category');
INSERT into items (name, user_id, category_id, state_id) values ('0. Show all items', 1,1,1);
INSERT into attachs (name, item_id) values ('Show',1);
INSERT into comments (comm, item_id) values ('comment is ', 1);
