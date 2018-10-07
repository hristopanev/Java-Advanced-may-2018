SELECT 
    e.employee_id,
    e.first_name,
    CASE
        WHEN DATE(p.start_date) >= 2005 THEN NULL
    END AS 'project_name'
FROM
    employees AS e
JOIN
    employees_projects AS emp 
ON e.employee_id = emp.employee_id
JOIN
    projects AS p 
ON emp.project_id = p.project_id
AND e.employee_id = 24
