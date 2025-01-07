-- 코드를 입력하세요
# SELECT i.animal_id, i.name
# FROM animal_ins i left join animal_outs o on i.animal_id=o.animal_id
# WHERE o.animal_id is null
# ORDER BY 1

SELECT o.animal_id, o.name
FROM animal_outs o left join animal_ins i on o.animal_id=i.animal_id
WHERE i.animal_id is null
ORDER BY 1