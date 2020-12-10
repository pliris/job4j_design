select *
from emploees e
left join departments d on e.depart_id = d.id
where e.depart_id is null;

select *
from departments d
left join emploees e on e.depart_id = d.id
where e.depart_id is not null;

"задание 3"
select *
from emploees e
right join departments d on e.depart_id = d.id
where e.depart_id is not null;

"задание 4"
select e.id, e.name, e.depart_id, d.id, d.department
from departments d
left join emploees e  on e.depart_id = d.id
where e.depart_id is not null;

select e.id, e.name, e.depart_id, d.id, d.department
from departments d
right join emploees e  on e.depart_id = d.id
where e.depart_id is not null;

"задание 5"
create table teens (
	id serial primary key,
	name varchar(50),
	gender char(1)
);
insert into teens(name, gender)
values('Linda', 'f'),
		('Tom', 'm'),
		('Marry', 'f'),
		('Bill', 'm'),
		('Nicole', 'f'),
		('Frank', 'm'),
		('John', 'm'),
		('Serena', 'f');

select tM.name, tM.gender,  tF.name, tF.gender
from teens tM cross join teens tF
where tM.gender = 'm' and tF.gender = 'f';