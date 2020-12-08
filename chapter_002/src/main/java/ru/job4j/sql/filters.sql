
select * from product
where type_id = (
	select id from type where name = 'СЫР');

insert into type(name)  values('мороженное');
insert into product(name, type_id, expired_date, price)
values('натуральное', (select id from type where name like 'мороженное'),
	   '2020-09-01', 30.1);

select * from product
where type_id = (
	select id from type where name like '%мороженное%');

select * from product
where expired_date > ( select current_date + interval '1 month');

select * from product order by price desc limit 1;
select max (price) from product;

select count (name) AS "Number of name"
from product
where type_id = (
	select id from type where name like '%мороженное%');

select * from product
where type_id =
	(select id from type where name = 'мороженное')
	or
	type_id =
	(select id from type where name = 'СЫР')
	;

select name,type_id, count (type_id) AS "total"
from product
group by name , type_id
having count (type_id) < 10;

select name, type_id
from product
union
select name, id
from type;

