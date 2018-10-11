DELIMITER $$
CREATE FUNCTION ufn_get_salary_level (salary DECIMAL (19,4))
RETURNS VARCHAR(10)
READS SQL DATA
DETERMINISTIC
BEGIN
	DECLARE result VARCHAR(50);
    IF(salary < 30000) THEN
    SET result  := 'Low';
    ELSEIF (salary <= 50000) THEN
    SET result := 'Average';
    ELSE 
    SET result := 'High';
    END IF;
    RETURN result;
END $$
DELIMITER ;

SELECT
	e.salary,
    ufn_get_salary_level(e.salary) AS salary_level
FROM employees AS e;