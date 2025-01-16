-- 년 월, 성별 별로 상품을 구매한 회원수를 집계

SELECT YEAR(sales_date) as YEAR , MONTH(sales_date) as MONTH, u.gender as GENDER, COUNT(distinct(s.user_id)) AS USERS
FROM ONLINE_SALE s LEFT JOIN USER_INFO u ON s.USER_ID = u.USER_ID
WHERE u.gender is not NULL
GROUP BY 1, 2, 3
ORDER BY 1, 2, 3
