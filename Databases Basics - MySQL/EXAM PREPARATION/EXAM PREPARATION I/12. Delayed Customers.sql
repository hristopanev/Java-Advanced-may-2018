SELECT 
    c.customer_id,
    CONCAT_WS(' ', first_name, last_name) AS 'full_name',
    t.price AS 'ticket_price',
    a.airport_name
FROM
    customers AS c
        JOIN
    tickets AS t ON c.customer_id = t.customer_id
        JOIN
    flights AS f ON f.flight_id = t.flight_id
        AND f.status LIKE ('Delayed')
        JOIN
    airports AS a ON a.airport_id = f.destination_airport_id
ORDER BY ticket_price DESC
LIMIT 3;