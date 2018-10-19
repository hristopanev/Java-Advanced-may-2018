SELECT DISTINCT
	c.name,
    COUNT(r.category_id) AS 'reports_number'
FROM categories AS c
JOIN reports AS r
ON r.category_id = c.id
GROUP BY c.name
ORDER BY reports_number ASC, c.name;