SELECT 
	j.id,
    j.journey_start,
    j.journey_end
FROM journeys AS j
WHERE j.purpose LIKE ('Military')
ORDER BY j.journey_start;