CREATE PROCEDURE udp_post(username VARCHAR(30), password VARCHAR(30), caption VARCHAR(255), path VARCHAR(255))
BEGIN
    DECLARE user_id INT(11);
    DECLARE picture_id INT(11);
 
    IF (SELECT COUNT(u.id)
        FROM  users AS u
        WHERE u.username = username AND u.password = password) <> 1
    THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Password is incorrect!';
    END IF;
   
    IF (SELECT COUNT(p.id)
        FROM pictures AS p
        WHERE p.path = path) <> 1
    THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'The picture does not exist!';
    END IF;
   
    SET user_id := (SELECT u.id
                    FROM  users AS u
                    WHERE u.username = username);
    SET picture_id := (SELECT p.id
                       FROM pictures AS p
                       WHERE p.path = path);
                       
    INSERT INTO posts(caption, user_id, picture_id)
    VALUES (caption, user_id, picture_id);
   
END;