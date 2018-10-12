SELECT 
    a.airline_id, a.airline_name, a.nationality, a.rating
FROM
    airlines AS a,
    flights AS f
WHERE
    a.airline_id IN (f.airline_id)
GROUP BY a.airline_id
ORDER BY a.rating DESC
LIMIT 5;