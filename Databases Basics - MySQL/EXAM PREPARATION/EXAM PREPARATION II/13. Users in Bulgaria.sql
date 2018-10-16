SELECT
	u.nickname,
    c.title,
    l.latitude,
    l.longitude
FROM chats AS c
JOIN users_chats AS uc
ON uc.chat_id = c.id
JOIN users AS u
ON u.id = uc.user_id
JOIN locations AS l
ON l.id = u.location_id
WHERE l.latitude BETWEEN 41.139999 AND 44.129999
AND l.longitude BETWEEN 22.209999 AND 28.359999
ORDER BY c.title;
