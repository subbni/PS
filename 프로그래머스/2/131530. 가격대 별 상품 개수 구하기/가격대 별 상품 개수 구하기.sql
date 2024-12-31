
SELECT 10000 * (price div 10000) as price_group, count(1) as products
FROM product
GROUP BY 1
ORDER BY 1