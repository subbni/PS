SELECT c.car_id
FROM car_rental_company_rental_history h left join car_rental_company_car c on h.car_id=c.car_id
WHERE c.car_type='세단' and month(h.start_date)=10
GROUP BY 1
ORDER BY 1 desc