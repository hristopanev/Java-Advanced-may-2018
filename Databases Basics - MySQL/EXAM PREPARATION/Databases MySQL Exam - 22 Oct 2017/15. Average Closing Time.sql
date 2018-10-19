SELECT 
    d.name,
    IF(COUNT(r.close_date) = 0,
        'no info',
        CAST(FLOOR(AVG(DATEDIFF(r.close_date, r.open_date)))
            AS CHAR)) AS 'average_duration'
FROM
    departments AS d
        JOIN
    categories AS c ON d.id = c.department_id
        JOIN
    reports AS r ON r.category_id = c.id
GROUP BY d.id
ORDER BY d.name;
