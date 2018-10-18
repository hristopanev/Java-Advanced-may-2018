SELECT 
	c.id,
    c.name
FROM categories AS c
LEFT JOIN categories AS cat
ON c.id = cat.parent_id
WHERE cat.id IS NULL
ORDER BY c.name, cat.id;