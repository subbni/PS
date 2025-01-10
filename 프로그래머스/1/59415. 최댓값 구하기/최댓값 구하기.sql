-- 가장 최근에 들어온 동물은 언제 들어왔는지
SELECT MAX(DATETIME) as 시간
FROM animal_ins