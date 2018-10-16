SELECT
	c.title,
    m.content
FROM chats AS c
LEFT JOIN messages AS m
ON c.id = m.chat_id
WHERE c.start_date = (select MAX(c.start_date) FROM chats AS c)
ORDER BY m.sent_on, m.id;

