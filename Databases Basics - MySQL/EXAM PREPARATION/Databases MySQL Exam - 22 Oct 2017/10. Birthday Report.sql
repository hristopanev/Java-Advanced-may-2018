SELECT DISTINCT
c.name
FROM categories AS c
JOIN reports AS r
ON r.category_id = c.id
JOIN users AS u
ON u.id = r.user_id
WHERE
DAY(r.open_date) = DAY(u.birthdate)
AND MONTH(r.open_date) = MONTH(u.birthdate)
ORDER BY c.name ASC;