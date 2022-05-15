INSERT into role (name) value ('admin');
INSERT into users (name, password, role_id) value ('admin', 'admin', 1);
INSERT into rules (name) value ('rwd');
INSERT into roleANDrules (name, rule_id, role_id) value ('main_rule', 1, 1);
INSERT into category (name) value ('admin_category');
INSERT into items (name, user_id, category_id, state_id) value ('0. Show all items', 1,1,1);
INSERT into attachs (name, item_id) value ('Show',1);
INSERT into comments (comm, item_id) value ('comment is ', 1);
