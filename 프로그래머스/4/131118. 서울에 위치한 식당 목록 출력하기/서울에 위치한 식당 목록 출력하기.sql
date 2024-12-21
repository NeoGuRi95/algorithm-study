-- 코드를 입력하세요
SELECT RI.REST_ID, RI.REST_NAME, RI.FOOD_TYPE, RI.FAVORITES, RI.ADDRESS, RR.REVIEW_SCORE AS SCORE
FROM REST_INFO AS RI
JOIN 
    (SELECT REST_ID, ROUND(AVG(REVIEW_SCORE), 2) AS REVIEW_SCORE
     FROM REST_REVIEW
     GROUP BY REST_ID
    ) AS RR
ON RI.REST_ID = RR.REST_ID
WHERE RI.ADDRESS LIKE '서울%'
ORDER BY RR.REVIEW_SCORE DESC, RI.FAVORITES DESC;

# SELECT REST_ID, ROUND(AVG(REVIEW_SCORE), 3) AS REVIEW_SCORE
# FROM REST_REVIEW
# GROUP BY REST_ID

# SELECT *
# FROM REST_INFO
# WHERE ADDRESS LIKE '서울%';