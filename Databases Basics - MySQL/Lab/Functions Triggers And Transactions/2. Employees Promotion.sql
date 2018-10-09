use soft_uni;
DELIMITER $$
CREATE PROCEDURE usp_raise_salaries(department_name VARCHAR(50))
BEGIN
UPDATE employees AS e
JOIN department AS d
ON e.department_id = d.department_id
SET e.salary = e.salary * 1.05
WHERE d.name = department_name;
END $$
DELIMITER ;

SELECT first_name, salary FROM employees
ORDER BY first_name, salary;
CALL usp_raise_salaries('Finance');

