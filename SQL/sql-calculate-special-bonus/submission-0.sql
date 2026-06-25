-- Write your query below
SELECT
    employee.employee_id,
    CASE 
        WHEN employee.employee_id % 2 = 1 AND employee.name NOT LIKE 'M%' THEN employee.salary
        ELSE 0
    END AS bonus
FROM 
    employees employee
ORDER BY 
    employee.employee_id