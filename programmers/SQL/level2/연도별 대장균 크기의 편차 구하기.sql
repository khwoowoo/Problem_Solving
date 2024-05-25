--이정도면 레벨3 아닌가??
WITH YearlyMaxSize AS (
    SELECT
        EXTRACT(YEAR FROM DIFFERENTIATION_DATE) AS YEAR,
        MAX(SIZE_OF_COLONY) AS MAX_SIZE
    FROM
        ECOLI_DATA
    GROUP BY
        EXTRACT(YEAR FROM DIFFERENTIATION_DATE)
)
SELECT
    EXTRACT(YEAR FROM E.DIFFERENTIATION_DATE) AS YEAR,
    Y.MAX_SIZE - E.SIZE_OF_COLONY AS YEAR_DEV,
    E.ID
FROM
    ECOLI_DATA E
JOIN
    YearlyMaxSize Y ON Y.YEAR = EXTRACT(YEAR FROM E.DIFFERENTIATION_DATE)
ORDER BY
    YEAR,
    YEAR_DEV,
    ID;
