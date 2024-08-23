SELECT s.name AS NAME, pd.description AS Description
FROM SUPPLIER s, Product_Desc pd
                     INNER JOIN
ON s.id = pd.supplier
WHERE s.country = 'JPN'
ORDER BY s.id DESC;