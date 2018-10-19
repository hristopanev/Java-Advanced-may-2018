SELECT 
	c.name,
    COUNT(e.id) AS 'employees_number'
FROM categories AS c
JOIN employees AS e
ON e.department_id = c.department_id
GROUP BY c.name
ORDER BY c.name;