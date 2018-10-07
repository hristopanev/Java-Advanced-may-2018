SELECT 
    t.town_id, t.name, a.address_text
FROM
    towns AS t
        INNER JOIN
    addresses AS a ON a.town_id = t.town_id
WHERE
    t.name = 'San Francisco'
        OR t.name = 'Sofia'
        OR t.name = 'Carnation' 
ORDER BY town_id , address_id;
