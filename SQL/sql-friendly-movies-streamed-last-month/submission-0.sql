-- Write your query below
SELECT
    DISTINCT(c.title)
FROM
    content c
JOIN tv_program tv
ON 
    tv.content_id = c.content_id
WHERE
    c.kids_content = 'Y' AND c.content_type = 'Movies' AND tv.program_date LIKE '2020-06-%';

