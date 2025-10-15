SELECT last_name “Employee”, salary “Monthly Salary” 
FROM employees
WHERE (salary Between 5000 AND 12000 ) AND department_id in (20,50);
