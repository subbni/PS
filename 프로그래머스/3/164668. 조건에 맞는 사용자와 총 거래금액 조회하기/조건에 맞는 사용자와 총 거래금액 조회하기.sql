-- 코드를 입력하세요
-- 완료된 : status=true, 총 금액이 70만원 이상인 : used_goods_board를 group by writer_id로 했을 때 sum(price)>=70
SELECT *
FROM (
SELECT u.user_id, u.nickname, sum(price) as total_sales
FROM used_goods_board b left join used_goods_user u ON b.writer_id=u.user_id
WHERE status='DONE'
GROUP BY user_id
) a
WHERE total_sales>=700000
ORDER BY total_sales

