SELECT last_name, salary, commission
FROM employees
WHERE commission IS NOT NULL
ORDER BY salary, commission;
