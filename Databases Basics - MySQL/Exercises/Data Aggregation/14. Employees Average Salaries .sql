SELECT 
    *
INTO `new_employees`
FROM employees
WHERE
    salary > 30000;

DELETE FROM new_employees
WHERE new_employees.manager_id = 42;

UPDATE new_employees
SET salary = salary + 5000
WHERE new_employees.department_id = 1;

SELECT 
    n.department_id, AVG(n.salary) AS 'avg_salary'
FROM
    new_employees AS n
GROUP BY n.department_id;
