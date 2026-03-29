-- LeetCode 176
SELECT
	(
		SELECT DISTINCT salary
		FROM Employee
		ORDER BY salary DESC
		LIMIT 1 OFFSET 1
	)
AS SecondHighestSalary;

SELECT salary,
	DENSE_RANK() OVER(ORDER BY salary DESC) AS rnk
FROM Employee
AS SalaryRank
WHERE rnk = 2;
