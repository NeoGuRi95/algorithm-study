-- 코드를 작성해주세요
SELECT
ID,
CASE
    WHEN (RANKING <= TOTAL_COUNT/4) THEN 'CRITICAL'
    WHEN (RANKING <= 2*TOTAL_COUNT/4) THEN 'HIGH'
    WHEN (RANKING <= 3*TOTAL_COUNT/4) THEN 'MEDIUM'
    ELSE 'LOW'
END AS COLONY_NAME
FROM
(
    SELECT
    ID,
    RANK() OVER(ORDER BY SIZE_OF_COLONY DESC) AS RANKING,
    COUNT(*) OVER () AS TOTAL_COUNT
    FROM ECOLI_DATA
) T1
ORDER BY 1;