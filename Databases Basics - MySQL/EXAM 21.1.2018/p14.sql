SELECT DISTINCT
	les.job_during_journey
FROM journeys AS j
JOIN (SELECT 
			js.id,
			tc.job_during_journey,
			COUNT(tc.journey_id) AS 'count'
			FROM travel_cards AS tc
			JOIN journeys AS js
			ON js.id = tc.journey_id
			GROUP BY tc.job_during_journey
			ORDER BY 'count') les 
ON les.id = j.id
LIMIT 1;