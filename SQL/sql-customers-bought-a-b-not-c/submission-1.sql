-- Write your query below
SELECT 
    customer.customer_id, customer.customer_name
FROM 
    customers customer
WHERE customer.customer_id IN
( SELECT o.customer_id FROM orders o WHERE o.product_name = 'A')
AND customer.customer_id IN
( SELECT o.customer_id FROM orders o WHERE o.product_name = 'B')
AND customer.customer_id NOT IN
( SELECT o.customer_id FROM orders o WHERE o.product_name = 'C')
ORDER BY
    customer.customer_name;
