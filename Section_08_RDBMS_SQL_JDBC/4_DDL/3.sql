CREATE TABLE emp (
    id         NUMBER(7),
    last_name    VARCHAR2(25) NOT NULL,
    first_name   VARCHAR2(25),
    dept_id      NUMBER(7),
    CONSTRAINT emp_pk PRIMARY KEY ( id ),
    CONSTRAINT emp_fk FOREIGN KEY ( dept_id )
    REFERENCES dept ( dept_id )
);
INSERT INTO emp VALUES (101, ‘Sam’, 'Sundar', 10);

//Below query produces error
INSERT INTO emp VALUES ( 101, 'Ram', 'Krishna', 20);

//Below query produces error
INSERT INTO emp VALUES ( 102, 'Gopi', NULL, 40);

INSERT INTO emp VALUES ( 103, NULL, ‘ram’, 20);
