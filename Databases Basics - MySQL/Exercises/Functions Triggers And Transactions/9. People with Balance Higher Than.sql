DROP PROCEDURE usp_get_holders_full_name;

DELIMITER $$
CREATE PROCEDURE usp_get_holders_full_name(min_balance DECIMAL(19,4))
BEGIN 
	SELECT
		ac_h.first_name,
		ac_h.last_name
		FROM account_holders AS ac_h
		JOIN accounts AS ac
        ON ac_h.id = ac.account_holder_id
        GROUP BY first_name, last_name
        HAVING SUM(ac.balance) > min_balance
        ORDER BY ac_h.first_name, ac_h.last_name, ac.id;
END $$

DELIMITER ;

CALL usp_get_holders_full_name(7000)

