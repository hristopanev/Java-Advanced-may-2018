SELECT 
	u.id, 
	u.username, 
	(CASE WHEN  tb.my_comments IS NULL THEN 0 ELSE tb.my_comments END) as my_comments
FROM users u
LEFT JOIN
	(SELECT p.id, p.user_id, count(p.id) as my_comments
	FROM posts p
	JOIN comments c
	ON p.id = c.post_id
	WHERE p.user_id = c.user_id
	GROUP BY c.user_id) as tb
ON u.id = tb.user_id
ORDER BY tb.my_comments DESC, u.id;