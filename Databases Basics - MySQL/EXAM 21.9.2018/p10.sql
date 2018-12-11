SELECT DISTINCT
	sp.name,
    sp.manufacturer
FROM spaceships AS sp
JOIN journeys AS j
ON sp.id = j.spaceship_id
JOIN travel_cards AS tc
ON tc.journey_id = j.id
AND job_during_journey LIKE ('Pilot')
JOIN colonists AS c
ON c.id = tc.colonist_id 
WHERE (DATEDIFF('2019/01/01', STR_TO_DATE(c.birth_date, '%Y-%m-%d'))/365.25) < 30
#WHERE 2019 - YEAR(c.birth_date) < 30
ORDER BY sp.name;
