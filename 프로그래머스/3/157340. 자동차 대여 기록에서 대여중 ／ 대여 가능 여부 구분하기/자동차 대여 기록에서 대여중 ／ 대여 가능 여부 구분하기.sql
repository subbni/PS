-- 2022-10-16일에 대여 중인 자동차를 '대여중', 아니면 '대여 가능'을 표시하는 컬럼 추가
SELECT CAR_ID, 
    case when MAX('2022-10-16' between START_DATE and END_DATE)=1 then '대여중' 
        else '대여 가능' end as AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID
ORDER BY 1 desc