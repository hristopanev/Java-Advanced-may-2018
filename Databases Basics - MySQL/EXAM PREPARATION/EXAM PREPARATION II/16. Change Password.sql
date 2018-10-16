DELIMITER $$
CREATE PROCEDURE udp_change_password (IN email_in varchar(30), IN password_in varchar(20))
BEGIN
	DECLARE credential_id INT DEFAULT -1;
    SET credential_id = (SELECT COUNT(c.id) FROM credentials AS c WHERE c.email = email_in);
    IF credential_id < 1
    THEN 
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'The email does\'t exist!';
        END IF;
	UPDATE credentials SET password = password_in WHERE email = email_in;
END $$