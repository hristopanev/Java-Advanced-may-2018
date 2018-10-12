DELIMITER $$
CREATE FUNCTION ufn_calculate_future_value (initial_sum DECIMAL(19,4), 
interest_rate DOUBLE, years INT)
RETURNS DOUBLE
BEGIN
	DECLARE output DOUBLE;
    SET output := initial_sum * POW((1 + interest_rate), years);
    
    RETURN output;
END $$

DELIMITER ; 

