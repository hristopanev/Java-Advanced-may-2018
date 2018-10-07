SELECT 
    e.employee_id, e.first_name, p.name AS 'project_name'
FROM
    employees AS e
JOIN
    employees_projects AS emp 
ON e.employee_id = emp.employee_id
JOIN
    projects AS p 
ON emp.project_id = p.project_id
AND DATE(p.start_date) > '2002/08/13'
AND p.end_date IS NULL
ORDER BY e.first_name , p.name
LIMIT 5;