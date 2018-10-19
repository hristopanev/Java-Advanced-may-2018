SELECT 
    r.open_date, r.description, u.email AS 'reporter_email'
FROM
    reports AS r
        JOIN
    users AS u ON r.user_id = u.id
        JOIN
    categories AS c ON r.category_id = c.id
        JOIN
    departments AS d ON c.department_id = d.id
WHERE
    r.close_date IS NULL
        AND LENGTH(r.description) > 20
        AND r.description LIKE ('%str%')
        AND d.name IN ('Infrastructure' , 'Emergency', 'Roads Maintenance')
ORDER BY r.open_date , reporter_email , r.id;
