SELECT 
	u.username,
    u.age
FROM users AS u
ORDER BY u.age ASC, u.username DESC;