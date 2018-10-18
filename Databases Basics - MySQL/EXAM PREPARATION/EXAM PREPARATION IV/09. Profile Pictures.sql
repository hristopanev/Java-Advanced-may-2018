SELECT 
	u.id,
    u.username,
    CONCAT(p.size,'KB') AS 'size'
FROM users AS u
JOIN pictures AS p
ON u.profile_picture_id = p.id
WHERE u.profile_picture_id IN (SELECT u.profile_picture_id
								FROM users AS u 
								GROUP BY u.profile_picture_id 
								HAVING COUNT(*) > 1)
ORDER BY u.id;