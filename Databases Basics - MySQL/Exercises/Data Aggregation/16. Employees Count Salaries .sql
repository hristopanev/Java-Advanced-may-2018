SELECT 
    COUNT(e.salary) AS 'count_salary'
FROM
    employees AS e
WHERE
    e.manager_id IS NULL;
