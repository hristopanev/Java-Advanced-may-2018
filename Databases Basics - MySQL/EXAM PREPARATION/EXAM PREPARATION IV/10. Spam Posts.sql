SELECT 
	p.id,
    p.caption,
    COUNT(c.post_id) AS 'comments'
FROM posts AS p
JOIN comments AS c
ON p.id = c.post_id
GROUP BY p.id
ORDER BY COUNT(c.post_id) DESC, p.id ASC
LIMIT 5;