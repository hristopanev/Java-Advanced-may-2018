DROP PROCEDURE usp_transfer_money;

DELIMITER $$
CREATE PROCEDURE usp_transfer_money (from_account_id INT, to_account_id INT, amount DECIMAL(19,4))
BEGIN 
	DECLARE stat INT;
	SET stat = 1;
	START TRANSACTION;
		IF (SELECT
			COUNT(*)
			FROM account_holders
			WHERE id = from_account_id OR id = to_account_id) < 2 THEN
            SET stat = 0;
		END IF;
        
        IF amount < 0 THEN
			SET stat = 0;
		END IF;
        
        IF(SELECT
				balance
			FROM accounts
            WHERE id = from_account_id) < amount THEN
            SET stat = 0;
		END IF;
        
        IF from_account_id = to_account_id THEN
        SET stat = 0;
        END IF;
        
        UPDATE accounts SET balance = balance - amount WHERE id = from_account_id;
        UPDATE accounts SET balance = balance + amount WHERE id = to_account_id;
        
        IF stat = 1 THEN
        COMMIT;
        ELSE ROLLBACK;
        END IF;
END $$

DELIMITER ; 

CALL usp_transfer_money(3, 1, 10);

