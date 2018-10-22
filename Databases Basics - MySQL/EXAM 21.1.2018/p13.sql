SELECT 
	j.id,
    p.name AS 'planet_name',
    s.name AS 'spaceport_name',
    j.purpose
FROM journeys AS j
JOIN spaceports AS s
ON j.destination_spaceport_id = s.id
JOIN planets AS p
ON p.id = s.planet_id
ORDER BY (DATEDIFF(CURRENT_DATE, journey_start)/365.25) - (DATEDIFF(CURRENT_DATE, journey_end)/365.25) ASC
LIMIT 1;