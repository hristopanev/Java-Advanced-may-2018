SELECT
	c.id,
    COUNT(m.chat_id) AS 'total_messages'
FROM chats AS c
LEFT JOIN messages AS m
ON c.id = m.chat_id
WHERE m.id < 90
GROUP BY c.id
ORDER BY total_messages DESC, c.id ASC
LIMIT 5;