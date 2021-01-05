create table roles(
                      id serial primary key,
                      roles varchar(200)
);
create table category(
                         id serial primary key,
                         category varchar(200)
);
create table rules(
                      id serial  primary key,
                      rules varchar(200)
);
create table states(
                       id serial  primary key,
                       state varchar(200)
);
create table users(
                      id serial  primary key,
                      name varchar(200),
                      role_id int references roles(id)
);
create table role_rules(
                           id serial primary key,
                           role_id int references rules(id),
                           rules_id int references roles(id)
);
create table item(
                     id serial  primary key,
                     item varchar(200),
                     user_id int references users(id),
                     category_id int references category(id),
                     state_id int references states(id)
);
create table comments(
                         id serial  primary key,
                         comments varchar(2000),
                         item_id int references item(id)
);
create table attachs(
                        id serial  primary key,
                        attachs json,
                        item_id int references item(id)
);
