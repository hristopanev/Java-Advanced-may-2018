DELIMITER $$
CREATE PROCEDURE usp_get_towns_starting_with(input_alph VARCHAR(10))
BEGIN
	SELECT
		t.name
	FROM towns AS t
    WHERE LEFT(name, 1) LIKE (input_alph)
    ORDER BY t.name;
END $$
DELIMITER ;

CALL usp_get_towns_starting_with('b');