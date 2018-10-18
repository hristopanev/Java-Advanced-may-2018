SELECT * FROM
(SELECT c.id,
c.name,
COUNT(uc.user_id) AS 'contestants'
FROM contests AS c
LEFT JOIN users_contests AS uc
ON c.id = uc.contest_id
GROUP BY c.id, c.name
ORDER BY 'contestants' DESC , 'contestants' ASC,  c.id
LIMIT 5) AS top_five
ORDER BY top_five.contestants ASC, top_five.id ASC;