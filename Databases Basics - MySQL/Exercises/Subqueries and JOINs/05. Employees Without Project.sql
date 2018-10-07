SELECT 
    e.employee_id, e.first_name
FROM
    employees AS e
LEFT JOIN
    employees_projects AS emp 
ON e.employee_id = emp.employee_id
WHERE
    emp.employee_id IS NULL
ORDER BY employee_id DESC
LIMIT 3;