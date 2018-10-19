CREATE FUNCTION udf_get_reports_count(employee_id INT, status_id INT)
RETURNS INT
RETURN(
		SELECT
			COUNT(r.id) 
            FROM reports AS r
            WHERE r.employee_id = employee_id
            AND r.status_id = status_id);
            
            
            SELECT id, first_name, last_name, udf_get_reports_count(id, 2) AS reports_count
FROM employees AS e
ORDER BY e.id;
