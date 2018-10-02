SELECT 
    w.deposit_group, SUM(w.deposit_amount) AS 'total_sum'
FROM
    wizzard_deposits AS w
WHERE
    w.magic_wand_creator LIKE ('Ollivander family')
GROUP BY deposit_group
HAVING SUM(w.deposit_amount) < 150000
ORDER BY SUM(w.deposit_amount) DESC;
