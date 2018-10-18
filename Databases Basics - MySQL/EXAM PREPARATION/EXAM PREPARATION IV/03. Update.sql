UPDATE users AS u
JOIN  users_followers AS uf
ON u.id = uf.user_id
    JOIN
        (SELECT uf.user_id, count(uf.follower_id) AS `folowers_count` FROM  users_followers AS uf
        GROUP BY uf.user_id
        ORDER BY uf.user_id) AS `folowers`
        ON u.id = `folowers`.user_id
    SET u.profile_picture_id = CASE WHEN `folowers`.`folowers_count`= 0 THEN u.id
    ELSE `folowers`.`folowers_count`
    END
WHERE u.profile_picture_id IS NULL

