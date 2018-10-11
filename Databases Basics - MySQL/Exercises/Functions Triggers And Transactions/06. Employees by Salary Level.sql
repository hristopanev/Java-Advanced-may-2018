CREATE FUNCTION ufn_get_salary_level (salary DECIMAL (19,4))
RETURNS VARCHAR(10)
BEGIN
	DECLARE result VARCHAR(10);
    IF(salary < 30000) THEN
    SET result  := 'Low';
    ELSEIF (salary <= 50000) THEN
    SET result := 'Average';
    ELSE 
    SET result := 'High';
    END IF;
    RETURN result;
END;

CREATE PROCEDURE usp_get_employees_by_salary_level(salary_level VARCHAR(10))
BEGIN
	SELECT
	e.first_name,
    e.last_name
FROM employees AS e
WHERE ufn_get_salary_level(e.salary) = salary_level
ORDER by first_name DESC, last_name DESC;
END