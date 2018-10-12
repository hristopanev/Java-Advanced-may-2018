SELECT DISTINCT
    c.customer_id,
    CONCAT_WS(' ', c.first_name, c.last_name) AS 'full_name',
    t.town_name AS 'home_town'
FROM
    customers AS c
        INNER JOIN
    towns AS t ON c.home_town_id = t.town_id
        INNER JOIN
    tickets AS tk ON c.customer_id = tk.customer_id
        INNER JOIN
    flights AS f ON tk.flight_id = f.flight_id
        AND f.status LIKE ('Departing')
        INNER JOIN
    airports AS a ON f.origin_airport_id = a.airport_id
        AND c.home_town_id = a.town_id
ORDER BY customer_id;
