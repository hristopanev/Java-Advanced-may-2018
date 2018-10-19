SELECT 
	CONCAT_WS(' ', e.first_name, e.last_name) AS 'name',
    COUNT(r.user_id) AS 'user_count'
FROM employees AS e
JOIN reports AS r
ON e.id = r.employee_id
GROUP BY e.id
ORDER BY user_count DESC, name;