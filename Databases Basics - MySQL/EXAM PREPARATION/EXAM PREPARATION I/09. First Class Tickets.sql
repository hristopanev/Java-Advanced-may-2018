SELECT
	t.ticket_id,
    a.airport_name,
    CONCAT_WS(' ', first_name, last_name) AS 'full_name'
FROM customers AS c
INNER JOIN tickets AS t
ON c.customer_id = t.customer_id
AND t.price < 5000
AND t.class = 'First'
INNER JOIN flights AS f
ON t.flight_id = f.flight_id
INNER JOIN airports AS a
ON f.destination_airport_id = a.airport_id
ORDER BY ticket_id;