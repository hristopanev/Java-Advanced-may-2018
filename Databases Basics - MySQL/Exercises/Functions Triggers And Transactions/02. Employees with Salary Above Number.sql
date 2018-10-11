DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above(input_salary DECIMAL(19,4))
BEGIN
	SELECT
		e.first_name,
        e.last_name
	FROM employees AS e
    WHERE e.salary >= input_salary
    ORDER BY first_name, last_name, employee_id;
END $$
DELIMITER ;