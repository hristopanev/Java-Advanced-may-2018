SELECT 
	u.id,
    u.username,
    u.password
FROM users AS u
WHERE (SELECT COUNT(*) 
		FROM users AS us 
		WHERE u.password = us.password) > 1
ORDER BY u.username, u.id,