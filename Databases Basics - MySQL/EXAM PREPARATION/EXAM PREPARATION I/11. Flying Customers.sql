SELECT DISTINCT
    c.customer_id,
    CONCAT_WS(' ', first_name, last_name) AS 'full_name',
    (2016 - YEAR(c.date_of_birth)) AS age
FROM
    customers AS c
        INNER JOIN
    tickets AS t ON c.customer_id = t.customer_id
        INNER JOIN
    flights AS f ON f.flight_id = t.flight_id
        AND f.status = 'Departing'
ORDER BY age , c.customer_id;
