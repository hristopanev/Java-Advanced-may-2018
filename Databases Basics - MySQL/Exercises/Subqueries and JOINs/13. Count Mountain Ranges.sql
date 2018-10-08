SELECT 
	mc.country_code,
    COUNT(mc.country_code) AS 'mountrain_range'
FROM mountains_countries AS mc
JOIN mountains AS m
ON mc.mountain_id = m.id
WHERE mc.country_code IN ('BG', 'RU', 'US')
GROUP BY mc.country_code
ORDER BY 'mountrain_range'
