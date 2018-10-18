CREATE PROCEDURE usp_calculate_future_value_for_account(
    acc_id INT(11),
    rate DECIMAL(19,4))
BEGIN
    DECLARE value DECIMAL(19,4);
    DECLARE balance DECIMAL(19,4);
    SET balance := (SELECT a.balance FROM accounts AS a WHERE a.id = acc_id);
    SET value := balance * (pow(1 + rate, 5));
    SELECT
        a.id AS 'account_id',
        ah.first_name,
        ah.last_name,
        balance AS 'current_balance',
        value AS 'balance_in_5_years'
    FROM accounts AS a
        JOIN account_holders AS ah
        ON a.account_holder_id = ah.id
        AND
        a.id = acc_id;
END