INSERT INTO MY_EMPLOYEE
SELECT   employee_id, first_name, last_name, department_id, salary
FROM   employees
WHERE  employee_id = 201;
