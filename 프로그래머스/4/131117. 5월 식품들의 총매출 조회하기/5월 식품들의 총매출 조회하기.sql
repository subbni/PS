SELECT p.product_id as product_id, p.product_name, p.price*sum(a.amount) as total_sales
FROM food_product p join food_order a on p.product_id = a.product_id
WHERE date_format(a.produce_date,'%Y-%m')='2022-05'
GROUP BY 1
ORDER BY total_sales desc, p.product_id