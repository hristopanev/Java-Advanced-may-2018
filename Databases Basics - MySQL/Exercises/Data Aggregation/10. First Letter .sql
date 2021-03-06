SELECT 
    LEFT(w.first_name, 1) AS 'fist_letter'
FROM
    wizzard_deposits AS w
WHERE
    deposit_group = 'Troll Chest'
GROUP BY LEFT(first_name, 1)
ORDER BY LEFT(first_name, 1);
