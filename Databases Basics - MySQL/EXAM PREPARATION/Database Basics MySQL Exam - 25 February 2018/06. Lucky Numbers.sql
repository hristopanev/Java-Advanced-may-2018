SELECT DISTINCT
	rc.repository_id,
    cr.contributor_id
FROM repositories_contributors AS rc
JOIN repositories_contributors AS cr
ON rc.repository_id = cr.contributor_id
ORDER BY repository_id;

SELECT 
    *
FROM
    `repositories_contributors` AS rc
WHERE
    rc.contributor_id = rc.repository_id
ORDER BY rc.repository_id;