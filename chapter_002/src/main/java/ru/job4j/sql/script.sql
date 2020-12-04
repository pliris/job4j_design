create database sport;
create table sports(
                       id serial primary key,
                       team varchar,
                       birth date,
                       roster json
);
insert into sports(team, birth, roster)
values ('Oklahoma', '01-01-2008', '{"SF": "Kevin Durant"}');
update sports set roster='{"PF":"Kevin Durant"}';
delete from sports;
select * from sports;

