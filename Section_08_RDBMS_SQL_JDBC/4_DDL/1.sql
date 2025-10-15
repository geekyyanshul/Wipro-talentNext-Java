//lab_10_01.sql
CREATE TABLE DEPT(dept_id NUMBER(7) PRIMARY KEY,dept_name VARCHAR2(20));

(OR)
CREATE TABLE dept(dept_id NUMBER(7),dept_name VARCHAR2(20),CONSTRAINT pk_dept PRIMARY KEY ( dept_id ));
