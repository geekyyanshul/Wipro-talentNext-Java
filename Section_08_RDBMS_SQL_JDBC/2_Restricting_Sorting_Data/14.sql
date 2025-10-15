SELECT last_name, Job_id, salary
FROM employees
WHERE (job_id=’SA_REP’ OR job_id =’ST_CLERK’) AND salary NOT IN(2500,3500,7000);

