SELECT 
    c.customer_id,
    CONCAT_WS(' ', c.first_name, last_name) AS 'full_name',
    c.gender
FROM
    customers AS c
ORDER BY CONCAT_WS(' ', c.first_name, last_name) , customer_id;