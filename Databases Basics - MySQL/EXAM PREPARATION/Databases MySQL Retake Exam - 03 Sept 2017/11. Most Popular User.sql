SELECT 
	u.id,
    u.username,
    COUNT(p.user_id) AS 'posts',
    followers_count AS 'followers'
FROM users AS u
JOIN posts AS p
ON p.user_id = u.id
JOIN (SELECT uf.user_id, count(uf.follower_id) AS `followers_count` FROM  users_followers AS uf
        GROUP BY uf.user_id
        ORDER BY uf.user_id) AS `followers`
        ON u.id = `followers`.user_id
GROUP BY p.user_id
ORDER BY  followers_count DESC
LIMIT 1;