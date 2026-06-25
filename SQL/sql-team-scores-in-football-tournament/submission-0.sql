-- Write your query below
SELECT 
    team.team_id, team.team_name,
    COALESCE(SUM(
        CASE
            WHEN team.team_id = m.host_team AND m.host_goals > m.guest_goals THEN 3
            WHEN team.team_id = m.guest_team AND m.guest_goals > m.host_goals THEN 3
            WHEN m.host_goals = m.guest_goals THEN 1
            ELSE 0
        END 
    ), 0) AS num_points
FROM 
    teams team
LEFT JOIN matches m ON team.team_id = m.host_team OR team.team_id = m.guest_team
GROUP BY team.team_name, team.team_id
ORDER BY num_points DESC, team_id ASC;