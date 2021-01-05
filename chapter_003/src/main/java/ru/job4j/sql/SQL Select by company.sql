SELECT company.name, person.name
FROM person
         LEFT JOIN company
                   ON company.id = person.company_id
WHERE company.id != 5;

SELECT MAX (total) as maximum
FROM (SELECT company_id, COUNT(*) as total
      FROM person
      GROUP BY company_id) as total;