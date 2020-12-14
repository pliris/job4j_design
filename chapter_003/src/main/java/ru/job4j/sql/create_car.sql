create table bodys(
	id serial primary key,
	body varchar(50)
);
create table engines(
	id serial primary key,
	type varchar(50),
	power int
);
create table transmissions(
	id serial primary key,
	type varchar (50)
);
create table vehicle(
	id serial primary key,
	model varchar(75),
	body_id int references bodys(id),
	engine_id int references engines(id),
	transmission_id int references transmissions(id)
);


insert into bodys(body)
values('sedan'),('universal'),('hatchback'), ('telega');
insert into engines(type, power)
values('gas', '170'),
		('gas', '110'),
		('gas', '148'),
		('gas', '245'),
		('diesel', '150'),
		('diesel', '123'),
		('diesel', '201'),
		('hybrid', '113'),
		('hybrid', '78');
insert into transmissions(type)
values('manual'),
		('automatic'),
		('variator'),
		('robot');

insert into vehicle(model, body_id, engine_id, transmission_id)
values ('chevrolet lacetti', '1', '1', '1'),
		('chevrolet cruze', '1', '2', '2'),
		('ford focus', '2', '1', '3'),
		('ford fiesta', '3', '2', '1'),
		('ford mustang', '1', '4', '1'),
		('opel zafira', '2', '1', '3'),
		('opel vectra', '1', '3', '2'),
		('opel astra', '3', '3', '3');

select v.model, b.body, e.type, e.power, t.type
from vehicle as v
         join engines as e on v.engine_id = e.id
         join bodys as b on v.body_id = b.id
         join transmissions as t on v.transmission_id = t.id;


select *
from bodys as b
         left join vehicle on b.id = vehicle.body_id
where vehicle.body_id is null;
select *
from engines as e
         left join vehicle on e.id = vehicle.engine_id
where vehicle.engine_id is null;

select *
from transmissions as t
         left join vehicle as v on v.transmission_id = t.id
where v.transmission_id is null;