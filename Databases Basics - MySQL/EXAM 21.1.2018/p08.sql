SELECT  
	COUNT(*) AS 'count'
FROM colonists AS c
JOIN travel_cards AS tc
ON c.id = colonist_id
JOIN journeys AS j
ON j.id = tc.journey_id
WHERE j.purpose LIKE ('Technical');