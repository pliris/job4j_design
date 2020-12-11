
select * from product
where type_id = (
	select id from type where name = 'СЫР');

insert into type(name)  values('мороженное');
insert into product(name, type_id, expired_date, price)
values('натуральное', (select id from type where name like 'мороженное'),
	   '2020-09-01', 30.1);

select * from product
where name like '%мороженное%';

select *
from product
where expired_date = current_date + interval '1 month';

select * from product order by price desc limit 1;
select max (price) from product;

select type_id, count (name) AS "Number of name"
from product
group by type_id;

select *
from product
where type_id =
	(select id
	 from type
	 where name = 'молоко' or name = 'СЫР');

select type_id, count (type_id) AS "total"
from product
group by type_id
having count (type_id) < 10;


select product.name, product.price, type.name
from product
join type ON type.id = product.type_id;

