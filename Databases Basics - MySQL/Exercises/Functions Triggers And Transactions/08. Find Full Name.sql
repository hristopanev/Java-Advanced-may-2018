DELIMITER $$
CREATE PROCEDURE usp_get_holders_full_name()
BEGIN 
	SELECT
		concat_ws(' ', ac_h.first_name, ac_h.last_name) AS 'full_name'
		FROM account_holders AS ac_h
        ORDER BY full_name;
END $$

DELIMITER ;