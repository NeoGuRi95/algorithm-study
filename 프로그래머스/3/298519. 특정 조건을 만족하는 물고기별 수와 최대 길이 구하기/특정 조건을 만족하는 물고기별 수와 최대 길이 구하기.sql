-- 코드를 작성해주세요
SELECT
COUNT(*) FISH_COUNT,
MAX(LENGTH) MAX_LENGTH,
FISH_TYPE
FROM FISH_INFO
GROUP BY FISH_TYPE
HAVING AVG(LENGTH) > 32
ORDER BY 3;