CREATE TABLE meeting(
                        id serial primary key,
                        name varchar(50)
);

CREATE TABLE users(
                      id serial primary key,
                      name varchar(50)
);

CREATE TABLE status(
                       id serial primary key,
                       status boolean,
                       meeting_id int references meeting (id),
                       user_id int references users (id)
);


INSERT INTO meeting(name)
values('jpoint'),
      ('joker'),
      ('hackdays'),
      ('dom 2');
INSERT INTO users(name)
values('Nikita'),
      ('Alexey'),
      ('Bill'),
      ('Tina'),
      ('Linda'),
      ('Pete');

INSERT INTO status(status, meeting_id, user_id)
values(true, '1', '1'),
      (true, '2', '1'),
      (false, '3', '1'),
      (false, '4', '1'),
      (true, '1', '2'),
      (false, '2', '2'),
      (false, '3', '2'),
      (false, '4', '2');

select status.status, meeting.name, COUNT(*) as total
from status
         INNER JOIN meeting
                    ON status.meeting_id = meeting.id
         JOIN users
              ON status.user_id = users.id
GROUP BY  status.status, meeting.name
HAVING status = true;

select meeting.name, COUNT (status.status)
from status
         RIGHT OUTER JOIN meeting
                          ON status.meeting_id = meeting.id
WHERE  status.status is null or status.status is false
GROUP BY meeting.name
HAVING COUNT (status.status) = 0;
