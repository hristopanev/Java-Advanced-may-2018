SELECT DISTINCT
    *
FROM
    (SELECT 
        f.flight_id,
            f.departure_time,
            f.arrival_time,
            a1.airport_name AS 'origin',
            a2.airport_name AS 'destination'
    FROM
        flights AS f
    JOIN airports AS a1 ON f.origin_airport_id = a1.airport_id
    JOIN airports AS a2 ON f.destination_airport_id = a2.airport_id
    WHERE
        f.status LIKE ('Departing')
    ORDER BY departure_time DESC , flight_id DESC
    LIMIT 5) AS p
ORDER BY p.departure_time , p.flight_id;