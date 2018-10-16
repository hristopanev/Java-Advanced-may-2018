DELETE locations 
FROM locations
LEFT JOIN users
ON locations.id = users.location_id
WHERE users.location_id is NULL;