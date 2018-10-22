SELECT 
	p.name AS 'planet_name',
    s.name AS 'spaceport_name'
FROM planets AS p
JOIN spaceports AS s
ON p.id = s.planet_id
JOIN journeys AS j
ON j.destination_spaceport_id = s.id
AND j.purpose LIKE ('Educational')
ORDER BY spaceport_name DESC;
