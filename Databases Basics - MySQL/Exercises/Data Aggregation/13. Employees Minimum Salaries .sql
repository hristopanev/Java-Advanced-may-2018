SELECT 
    e.department_id, MIN(salary) AS 'minimum_salary'
FROM
    employees AS e
WHERE
    e.department_id IN (2 , 5, 7)
        AND hire_date > 01 / 01 / 2000
GROUP BY e.department_id
ORDER BY e.department_id ASC;
