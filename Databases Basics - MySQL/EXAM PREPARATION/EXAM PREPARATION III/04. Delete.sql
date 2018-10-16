DELETE repositories
FROM repositories
LEFT JOIN issues
ON repositories.id = issues.repository_id
WHERE issues.repository_id IS NULL;