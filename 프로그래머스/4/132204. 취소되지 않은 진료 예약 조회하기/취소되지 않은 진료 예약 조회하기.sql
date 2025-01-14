-- 코드를 입력하세요
SELECT a.APNT_NO, p.PT_NAME, a.PT_NO, a.MCDP_CD, a.DR_NAME, a.APNT_YMD
FROM PATIENT p left join (
    SELECT a.*, d.DR_NAME
    FROM APPOINTMENT a left join DOCTOR d on a.MDDR_ID=d.DR_ID
) a on p.PT_NO = a.PT_NO
WHERE date_format(APNT_YMD,'%Y-%m-%d')='2022-04-13' AND APNT_CNCL_YN = 'N'
ORDER BY APNT_YMD