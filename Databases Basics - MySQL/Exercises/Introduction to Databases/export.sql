-- 4
SELECT * FROM minions;

-- 4.2
SELECT m.name FROM minions AS m
ORDER BY  m.NAME ASC;

-- 6
UPDATE minions 
	SET minions.age = minions.age + 1;