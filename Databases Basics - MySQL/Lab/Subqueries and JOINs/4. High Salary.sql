SELECT 
    COUNT(e.salary) AS 'Count'
FROM
    employees AS e
WHERE
    e.salary > (SELECT 
            AVG(a.salary) AS 'avg'
        FROM
            employees AS a);
