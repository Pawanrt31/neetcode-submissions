-- Write your query below
SELECT
    expression.left_operand, expression.operator, expression.right_operand,
    CASE
        WHEN expression.operator = '>' AND lv.value > rv.value THEN 'true'
        WHEN expression.operator = '<' AND lv.value < rv.value THEN 'true'
        WHEN expression.operator = '=' AND lv.value = rv.value THEN 'true'
        ELSE 'false'
    END AS value
FROM expressions expression
JOIN variables lv 
ON expression.left_operand = lv.name
JOIN variables rv
ON expression.right_operand = rv.name;

