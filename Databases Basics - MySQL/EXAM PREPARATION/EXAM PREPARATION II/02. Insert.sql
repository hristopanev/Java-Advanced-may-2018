INSERT INTO messages (content, sent_on, chat_id, user_id)
SELECT CONCAT_WS('-', u.age,u.gender, l.latitude, l.longitude) AS 'content',
		'2016-12-15' AS 'sent_on',
        CASE u.gender
		WHEN 'F' THEN CEIL(SQRT(u.age*2))
        WHEN 'M' THEN POW(u.age/18, 3)  
        END,
        u.id AS 'user_id'
FROM users AS u
INNER JOIN locations AS l
ON l.id = u.location_id
WHERE u.id BETWEEN 10 AND 20;
