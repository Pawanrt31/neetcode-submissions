-- Write your query below
SELECT 
    DISTINCT(customer.name)
FROM customers customer
WHERE customer.id
NOT IN
(SELECT o.customer_id FROM orders o);