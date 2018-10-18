SELECT 
	u.id,
    u.username
FROM users AS u
JOIN users_followers AS uf
ON u.id = follower_id
WHERE user_id = follower_id
ORDER BY u.id;