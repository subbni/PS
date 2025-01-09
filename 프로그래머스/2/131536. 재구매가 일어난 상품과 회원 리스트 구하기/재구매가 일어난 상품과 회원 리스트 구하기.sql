-- 동일한 회원이 동일한 상품을 재구매한 데이터를 구하ㄱ
-- 재구매한 회원 ID와 재구매한 상품 ID를 출력
-- 회원 ID 오름차순, 상품 ID 내림차순
-- 회원 ID 오름차순, 상품 ID 내림차순

SELECT user_id, product_id
FROM online_sale
group by 1,2
having count(online_sale_id)>1
order by 1,2 desc