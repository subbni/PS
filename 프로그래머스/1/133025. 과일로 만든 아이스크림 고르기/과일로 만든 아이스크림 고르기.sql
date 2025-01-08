-- 상반기 아이스크림 총주문량이 3000보다 높으면서 주 성분이 과일인 아이스크림 맛
-- 총주문량이 큰 순서대로 조회

SELECT f.flavor
FROM first_half f left join icecream_info i on f.flavor=i.flavor
WHERE f.total_order > 3000 and i.ingredient_type='fruit_based'
ORDER BY f.total_order desc
