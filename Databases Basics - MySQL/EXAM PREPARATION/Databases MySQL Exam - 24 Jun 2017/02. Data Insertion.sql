INSERT INTO submissions(passed_tests, problem_id, user_id)
SELECT
	CEIL(SQRT(POW(length(p.name), 3)) - length(p.name)),
    p.id AS `problem_id`,
    CEIL((p.id * 3) / 2)
FROM problems AS p
WHERE p.id BETWEEN 1 AND 10;