-- 코드를 작성해주세요
SELECT COUNT(*) FISH_COUNT
FROM FISH_INFO T1
JOIN FISH_NAME_INFO T2
ON T1.FISH_TYPE = T2.FISH_TYPE
WHERE T2.FISH_NAME = 'BASS'
OR T2.FISH_NAME = 'SNAPPER'