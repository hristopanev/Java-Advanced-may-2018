SELECT
	f.id,
    f.name,
    CONCAT(f.size,'KB') AS 'size'
FROM files AS f
LEFT JOIN files AS fs
ON f.id = fs.parent_id
WHERE fs.id IS NULL
ORDER BY f.id;