SELECT 
	c.title,
    c.is_active
FROM chats AS c
WHERE (c.is_active = 0
AND char_length(c.title) < 5)
OR c.title LIKE '__tl%'
ORDER BY c.title DESC;