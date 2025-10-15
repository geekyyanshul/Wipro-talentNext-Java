INSERT INTO DEPT VALUES ( 10, 'Accounts');
INSERT INTO DEPT VALUES (20,'TT' );
INSERT INTO DEPT VALUES ( 1,'Accounts');
UPDATE DEPT
SET
    dept_id = 30
WHERE
    dept_id = 1;

INSERT INTO DEPT
    SELECT
        department_id,
        department_name
    FROM
        departments;
