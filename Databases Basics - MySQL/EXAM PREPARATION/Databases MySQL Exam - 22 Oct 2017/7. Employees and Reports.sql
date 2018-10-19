SELECT 
	e.first_name,
    e.last_name,
    r.description,
    DATE_FORMAT(r.open_date, '%Y-%m-%d') AS 'open_date'
FROM employees AS e
JOIN reports AS r
ON r.employee_id = e.id
WHERE r.employee_id IS NOT NULL
ORDER BY r.employee_id ASC, DATE_FORMAT(r.open_date, '%Y-%m-%d') ASC, r.id ASC;