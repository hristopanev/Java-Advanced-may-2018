DELETE FROM users
WHERE id NOT IN (
	SELECT follower_id
    FROM users_followers)