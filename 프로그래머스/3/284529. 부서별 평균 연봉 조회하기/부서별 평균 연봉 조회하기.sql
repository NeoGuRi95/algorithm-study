-- 코드를 작성해주세요
SELECT DEPT.DEPT_ID,
DEPT.DEPT_NAME_EN,
ROUND(AVG(EMP.SAL), 0) AVG_SAL
FROM HR_DEPARTMENT DEPT
JOIN HR_EMPLOYEES EMP
ON DEPT.DEPT_ID = EMP.DEPT_ID
GROUP BY DEPT.DEPT_ID
ORDER BY AVG_SAL DESC