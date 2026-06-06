-- Write your query below
SELECT 
    DISTINCT(customer.customer_id)
FROM 
    customers customer
WHERE 
    customer.revenue > 0 and customer.year = 2020;