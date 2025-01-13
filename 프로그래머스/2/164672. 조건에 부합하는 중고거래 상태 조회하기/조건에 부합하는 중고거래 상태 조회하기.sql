-- 코드를 입력하세요
SELECT board_id, writer_id, title, price, 
        case status when 'DONE' then '거래완료'
                    when 'SALE' then '판매중'
                    when 'RESERVED' then '예약중'
                end as status
FROM used_goods_board
WHERE date_format(created_date,'%Y-%m-%d') = '2022-10-05'
ORDER BY 1 desc
