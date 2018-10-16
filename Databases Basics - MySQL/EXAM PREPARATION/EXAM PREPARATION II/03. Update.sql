UPDATE chats AS c
INNER JOIN (
		SELECT c.id,
		MIN(m.sent_on) AS min_date
		FROM chats AS c
		INNER JOIN messages AS m
		ON c.id = m.chat_id
		WHERE c.start_date > m.sent_on
		GROUP BY c.id) AS wrong_chats
        ON c.id = wrong_chats.id
SET c.start_date = wrong_chats.min_date;