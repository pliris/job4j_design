SELECT company.name, person.name
FROM person
         LEFT JOIN company
                   ON company.id = person.company_id
WHERE company.id != 5;

SELECT name, MAX (total) as maximum
FROM (SELECT company_id, COUNT(*) as total
      FROM person
      GROUP BY company_id) as total
         JOIN company
              ON total.company_id = company.id
GROUP BY name
ORDER BY maximum desc
limit 1;