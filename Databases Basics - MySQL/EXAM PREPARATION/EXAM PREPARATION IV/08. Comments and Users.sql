SELECT 
	c.id,
    CONCAT_WS(' ', u.username, ':', c.content) AS 'full_comment'
FROM comments AS c
JOIN users AS u
ON u.id = c.user_id
ORDER BY c.id DESC;