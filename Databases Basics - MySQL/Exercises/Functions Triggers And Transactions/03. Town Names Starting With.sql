DELIMITER $$
CREATE PROCEDURE usp_get_towns_starting_with(input_alph VARCHAR(20))
BEGIN
	SELECT
		t.name
	FROM towns AS t
    WHERE LEFT(name, LENGTH(input_alph)) LIKE (input_alph)
    ORDER BY t.name;
END $$
DELIMITER ;

DROP PROCEDURE usp_get_towns_starting_with;

CALL usp_get_towns_starting_with('b');