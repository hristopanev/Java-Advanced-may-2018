SELECT u.id, u.username, cq1.caption
FROM users AS u
JOIN(
SELECT cq.id, cq.user_id, cq.caption
FROM 
(SELECT 
		p.id,
		p.user_id,
		p.caption,
		COUNT(c.id) `comments_count`
	FROM posts AS p
	LEFT JOIN comments AS c
	ON c.post_id = p.id
	GROUP BY p.id
	ORDER BY comments_count DESC, p.id) AS `cq`
    
GROUP BY cq.user_id
ORDER BY cq.user_id
) `cq1`
ON u.id = cq1.user_id