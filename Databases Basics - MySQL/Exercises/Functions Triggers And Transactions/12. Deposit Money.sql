CREATE PROCEDURE usp_deposit_money (account_id INT, money_amount DECIMAL)
BEGIN
    START TRANSACTION;
    UPDATE accounts AS ac
    SET ac.balance = ac.balance + money_amount
    WHERE ac.id = account_id;
    IF (
    SELECT a.balance
    FROM accounts as a
    WHERE a.id = account_id
    ) >= 0 THEN
    COMMIT;
    ELSE
    rollback;
    END IF;
END