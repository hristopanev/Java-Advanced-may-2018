SELECT 
    m.id, m.chat_id, m.user_id
FROM
    messages AS m
        LEFT JOIN
    users_chats AS uc ON m.chat_id = uc.chat_id
        AND m.user_id = uc.user_id
WHERE
    uc.user_id IS NULL AND m.chat_id = 17
ORDER BY m.id DESC;