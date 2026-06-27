-- Write your query below
SELECT
    usr.name, SUM(t.amount) AS balance
FROM users usr
JOIN transactions t
ON usr.account = t.account
GROUP BY usr.name 
HAVING SUM(t.amount) > 10000