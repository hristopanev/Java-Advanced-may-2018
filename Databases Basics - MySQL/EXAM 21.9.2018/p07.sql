SELECT 
	c.id,
    concat_ws(' ', c.first_name, c.last_name) AS 'full_name'
FROM colonists AS c
JOIN travel_cards AS tc
ON c.id = tc.colonist_id
AND tc.job_during_journey = 'Pilot'
ORDER BY c.id;