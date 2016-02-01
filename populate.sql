insert into positions (name) values ('programista');
insert into positions (name) values ('grafik');
insert into positions (name) values ('marketingowiec');
insert into positions (name) values ('analityk');

insert into employees (name, last_name, position_id) values ('Jan', 'Kowalski', (SELECT id from positions WHERE name='programista'));
insert into employees (name, last_name, position_id) values ('Adam', 'Nowak', (SELECT id from positions WHERE name='grafik'));
insert into employees (name, last_name, position_id) values ('Ktos', 'Tam', (SELECT id from positions WHERE name='marketingowiec'));
insert into employees (name, last_name, position_id) values ('Krzysztof', 'Ibisz', (SELECT id from positions WHERE name='analityk'));

insert into item_categories (name) values ('myszki');
insert into item_categories (name) values ('klawiatury');
insert into item_categories (name) values ('monitory');
insert into item_categories (name) values ('tablety');
insert into item_categories (name) values ('krzesla');
insert into item_categories (name) values ('biurka');

insert into items (name, quantity, category_id) values ('Myszka1', 10, (SELECT id from item_categories WHERE name='myszki'));
insert into items (name, quantity, category_id) values ('Myszka2', 10, (SELECT id from item_categories WHERE name='myszki'));
insert into items (name, quantity, category_id) values ('Klawiatura1', 10, (SELECT id from item_categories WHERE name='klawiatury'));
insert into items (name, quantity, category_id) values ('Klawiatura2', 10, (SELECT id from item_categories WHERE name='klawiatury'));
insert into items (name, quantity, category_id) values ('Monitor1', 10, (SELECT id from item_categories WHERE name='monitory'));
insert into items (name, quantity, category_id) values ('Tablet1', 10, (SELECT id from item_categories WHERE name='tablety'));
insert into items (name, quantity, category_id) values ('Biurko1', 10, (SELECT id from item_categories WHERE name='biurka'));

insert into possessions (employee_id, item_id) values (1, (SELECT id from items WHERE name='Myszka1'));
insert into possessions (employee_id, item_id) values (1, (SELECT id from items WHERE name='Klawiatura1'));
insert into possessions (employee_id, item_id) values (2, (SELECT id from items WHERE name='Myszka2'));
insert into possessions (employee_id, item_id) values (2, (SELECT id from items WHERE name='Klawiatura2'));

