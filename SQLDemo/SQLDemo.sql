/*DDL
Keyword + Table + "Name" (column-name column-type constraint, column-name column-type constraint);
*/
CREATE TABLE "PERSON" (
    P_ID NUMBER PRIMARY KEY,
    P_NAME VARCHAR2(2000),
    P_AGE INTEGER,
    P_STATE VARCHAR2(2000)
);

/*DDL: Alter
Keyword-alter keyword-table table-name keyword-modify column-name argument*/
ALTER TABLE PERSON MODIFY P_ID INTEGER;

/*DML: Insert
keyword-insert keyword-into table-name keyword-values (parameters)*/
INSERT INTO PERSON VALUES(1, 'John', 28, 'AZ');

/*keyword-insert keyword-into table-name (column-name, column-name) keyword-values (parameters)*/
INSERT INTO PERSON (P_ID, P_STATE) VALUES(2, 'NY');
INSERT INTO PERSON (P_ID, P_NAME, P_AGE) VALUES(2, 'Sam', 15); /*Will give error, ID conflict*/
INSERT INTO PERSON VALUES(3, 'Austin', 30, 'TX');
INSERT INTO PERSON VALUES(4, 'Katie', 27, 'AL');

/*DML (DQL): Select*/
SELECT * FROM PERSON;
/*keyword-select column-name keyword-from table-name*/
SELECT P_NAME, P_STATE FROM PERSON;

/*Alias keyword 'AS'
Useful for readability, pulling data from multiple tables, subquery results*/
SELECT 'FIRST NAME', P_NAME FROM PERSON;
SELECT P_NAME AS FIRSTNAME, P_STATE FROM PERSON;
SELECT P_NAME 
AS FIRSTNAME 
FROM PERSON;
SELECT P_NAME AS FIRSTNAME, P_STATE AS HOMESTATE FROM PERSON;

/*DDL: Update*/
UPDATE PERSON
SET P_NAME = 'Sam', P_AGE = 15
WHERE P_ID = 2;

UPDATE PERSON
SET P_NAME = 'Sam', P_AGE = 15, P_ID = 5
WHERE P_ID = 2;

/*DML: Delete*/
/*keyword-delete keyword-from table-name keyword-where expression*/
DELETE FROM PERSON WHERE P_ID = 5;

/*SQL allows simple operations (+, -, *, /) on numeric datatypes, 
join character data with + */
SELECT P_AGE * P_AGE AS AGESQUARED FROM PERSON;
SELECT P_AGE + P_AGE AS AGEDOUBLE FROM PERSON;

/*Group By: Reduce rows to distinct values*/
SELECT P_STATE FROM PERSON
GROUP BY P_STATE;

/*Where: Find rows by expression*/
SELECT P_NAME FROM PERSON
WHERE P_STATE = 'AZ';

/*Order by
Select query + Order by keyword + column-name + Optional asc/desc*/
SELECT P_STATE FROM PERSON
ORDER BY P_STATE DESC;

/*Orderby + Group by*/
SELECT P_STATE FROM PERSON
WHERE P_AGE > 25
GROUP BY P_STATE
ORDER BY P_STATE DESC;

SELECT * FROM PERSON ORDER BY P_AGE, P_STATE DESC;

SELECT P_AGE, P_NAME FROM PERSON GROUP BY P_AGE, P_NAME ORDER BY P_AGE;
SELECT * FROM PERSON WHERE P_NAME = 'Austin';

/*Aggregate functions (AVG, MIN, MAX, COUNT, SUM, etc)
perfom opertions on an entire column*/
SELECT AVG(P_AGE), P_STATE FROM PERSON GROUP BY P_STATE;
SELECT AVG(P_AGE) FROM PERSON;
SELECT SUM(P_AGE) FROM PERSON;

/*Scalar functions: Operate on individual entries (lower, upper, nvl)*/
SELECT LOWER(P_NAME) FROM PERSON WHERE P_NAME = 'AUSTIN';
SELECT UPPER(P_NAME) FROM PERSON WHERE P_NAME = 'Austin';
SELECT NVL(P_AGE,10) FROM PERSON;

/*Having
Having is for aggegate functions used with group by*/
SELECT * FROM PERSON WHERE P_AGE > 25;
SELECT AVG(P_AGE) FROM PERSON HAVING AVG(P_AGE) > 25;


/*Joins*/
CREATE TABLE DEPARTMENT (
    D_ID INTEGER PRIMARY KEY,
    D_NAME VARCHAR2(2000) NOT NULL
);

CREATE TABLE RETIREE (
    R_ID INTEGER PRIMARY KEY,
    R_NAME VARCHAR2(2000) NOT NULL,
    R_RETIRED DATE,
    R_DEPT INTEGER,
    R_PHONE INTEGER UNIQUE,
    FOREIGN KEY (R_DEPT) REFERENCES DEPARTMENT(D_ID),
    FOREIGN KEY (R_PHONE) REFERENCES PHONE_NUMBERS(P_ID)
);

CREATE TABLE PHONE_NUMBERS (
    P_ID INTEGER PRIMARY KEY,
    P_NUMBER VARCHAR2(20)
);

INSERT INTO DEPARTMENT VALUES (1, 'SALES');
INSERT INTO DEPARTMENT VALUES (2, 'HR');
INSERT INTO DEPARTMENT VALUES (3, 'TRAINING');

INSERT INTO RETIREE VALUES (1, 'JOHN', CURRENT_TIMESTAMP, 1, 100);
INSERT INTO RETIREE VALUES (2, 'JAKE', CURRENT_TIMESTAMP, 2, 101);
INSERT INTO RETIREE VALUES (3, 'JOE', CURRENT_TIMESTAMP, 3, 102);
INSERT INTO RETIREE VALUES (4, 'JIM', CURRENT_TIMESTAMP, 1, 103);
INSERT INTO RETIREE VALUES (5, 'JAMES', CURRENT_TIMESTAMP, 2, 104);

INSERT INTO PHONE_NUMBERS VALUES (100, '2424735243');
INSERT INTO PHONE_NUMBERS VALUES (101, '43252354243');
INSERT INTO PHONE_NUMBERS VALUES (102, '2343241241');
INSERT INTO PHONE_NUMBERS VALUES (103, '53253525236');
INSERT INTO PHONE_NUMBERS VALUES (104, '23645363');

SELECT * FROM DEPARTMENT;
SELECT * FROM PHONE_NUMBERS;
SELECT * FROM RETIREE;

/*JOIN statement: TableA INNER JOIN TableB + ON FOREIGNKEY = PRIMARYKEY*/
SELECT R_NAME, D_NAME FROM DEPARTMENT INNER JOIN RETIREE ON R_DEPT = D_ID;
SELECT * FROM DEPARTMENT INNER JOIN RETIREE ON R_DEPT = D_ID;

/*Alias with Joins*/
SELECT DEPT.D_NAME, RET.R_NAME
FROM DEPARTMENT DEPT
INNER JOIN RETIREE RET
ON RET.R_DEPT = DEPT.D_ID;

SELECT R_NAME, D_NAME FROM DEPARTMENT LEFT JOIN RETIREE ON R_DEPT = D_ID;

/*Join all tables, everyone in SALES with a phone number*/
SELECT R_NAME RETIREENAME, P_NUMBER PHONENUM
FROM DEPARTMENT INNER JOIN RETIREE ON R_DEPT = D_ID
INNER JOIN PHONE_NUMBERS ON R_PHONE = P_ID
WHERE D_NAME = 'SALES';

SELECT * FROM RETIREE
INNER JOIN DEPARTMENT ON R_DEPT = D_ID
INNER JOIN PHONE_NUMBERS ON R_PHONE = P_ID
WHERE R_NAME = 'JOHN';

/*AND, OR keywords: expression KEYWORD expression*/
SELECT * FROM RETIREE WHERE R_NAME = 'JOHN' OR R_NAME = 'JIM';
SELECT * FROM DEPARTMENT WHERE D_NAME = 'SALES' OR D_ID = 2;

/*UNIONS: select statement + select statement*/
SELECT * FROM RETIREE WHERE R_NAME = 'JOHN'
UNION
SELECT * FROM RETIREE WHERE R_PHONE = 101;

/*Cross Joins: Cartesian join*/
SELECT * FROM RETIREE CROSS JOIN DEPARTMENT;
SELECT * FROM PHONE_NUMBERS CROSS JOIN DEPARTMENT;
SELECT * FROM RETIREE CROSS JOIN PHONE_NUMBERS;

/*DELETES ALL ROWS, BUT KEEPS COLUMN STRUCTURE*/
TRUNCATE TABLE PERSON;
SELECT * FROM PERSON;

/*DROP: ERASES TABLE FROM EXISTENCE*/
DROP TABLE PERSON;

/*Constraints
Primary Key, Foreign Key, Not Null, Unique, Default, Check*/
CREATE TABLE PERSON (
    P_ID INTEGER PRIMARY KEY,
    P_NAME VARCHAR2(100) NOT NULL,
    P_AGE INTEGER CHECK(P_AGE > 18),
    P_COUNTRY VARCHAR2(100) DEFAULT 'USA',
    P_SSN NUMBER UNIQUE
);
SELECT * FROM PERSON;
INSERT INTO PERSON VALUES (1, 'Sam', 19, '', 1);
INSERT INTO PERSON (P_ID, P_NAME, P_AGE, P_SSN) VALUES (2, 'John', 20, 2);
INSERT INTO PERSON VALUES (3, 'Jack', 25, 'USA', 1);

/*Alter syntax
ALTER TABLE [TableName]
    ADD(column) [Column-Definition] |
    ADD [Constraint-Clause] |
    DROP [column][Cascade] |
    DROP [Constraint] |
    ALTER COLUMN [Column-Definition]
*/

/*
Subqueries - a query nested in the WHERE clause of a SELECT statement
    further restrict the data returned
    
    correlated: depends on the outer query to run - cannot execute independently
    non-correlated - executes immediately before other query
    
    1) Correlated:
        SELECT P.Product_Name FROM PRODUCT P WHERE P.Product_ID = 
            (SELECT O.Product_ID FROM ORDER_ITEMS O WHERE O.Product_ID = 'P.Product_ID');
            
    2) Non-correlated:
        SELECT Id.FirstName FROM STUDENT_DETAILS WHERE FirstName IN 
            (SELECT FirstName FROM STUDENT_DETAILS WHERE Subject = 'Science');
*/

/*IN operator: allows you to specify values in a WHERE clause, same as multiple
OR conditions*/
SELECT * FROM ALBUM WHERE TITLE IN ('Achtung Baby', 'War2');
SELECT * FROM ALBUM WHERE TITLE IN (SELECT TITLE FROM ALBUM WHERE TITLE = 'Out Of Exile');

/*EXISTS operator: test for existence, return true if one or more returned*/
SELECT * FROM ALBUM WHERE EXISTS (SELECT TITLE FROM ALBUM WHERE TITLE = 'Out of Exile');

/*Functions*/
CREATE OR REPLACE FUNCTION FIND_MAX_NUMBER (X IN NUMBER, Y IN NUMBER) RETURN NUMBER
IS Z NUMBER;
BEGIN
    IF X > Y THEN Z:=X;
    ELSE Z:=Y;
    END IF;
    RETURN Z;
END;

DECLARE FIRST_NUM NUMBER; SECOND_NUM NUMBER; MAX_NUM NUMBER;
BEGIN
    FIRST_NUM:=22;
    SECOND_NUM:=42;
    MAX_NUM:= FIND_MAX_NUMBER(FIRST_NUM, SECOND_NUM);
    DBMS_OUTPUT.PUT_LINE('MAX: '||MAX_NUM);
END;

/*Function with characters*/
CREATE OR REPLACE FUNCTION FIND_MAX_CHARACTER (X IN VARCHAR2, Y IN VARCHAR2)
RETURN VARCHAR2 AS Z VARCHAR2(4);
BEGIN
    IF X>Y THEN Z:=X;
    ELSE Z:=Y;
    END IF;
    RETURN Z;
END;
DECLARE
    FIRST_CHAR VARCHAR2(4);
    SECOND_CHAR VARCHAR2(4);
    MAX_CHAR VARCHAR2(4);
BEGIN
    FIRST_CHAR:='A';
    SECOND_CHAR:='Z';
    MAX_CHAR:=FIND_MAX_CHARACTER(FIRST_CHAR, SECOND_CHAR);
    DBMS_OUTPUT.PUT_LINE('MAX: '||MAX_CHAR);
END;

/*Stored Procedure*/
CREATE OR REPLACE PROCEDURE HELLO_WORLD_PROCEDURE AS
BEGIN
    DBMS_OUTPUT.PUT_LINE('HELLO WORLD');
END;

BEGIN HELLO_WORLD_PROCEDURE(); END;

/*Stored Procedures w/ Cursors*/
CREATE OR REPLACE PROCEDURE GET_ALL_ALBUMS (S OUT SYS_REFCURSOR) AS
BEGIN
    OPEN S FOR
        SELECT ALBUMID, TITLE FROM ALBUM;
END;

DECLARE
    S SYS_REFCURSOR;
    SOME_ID ALBUM.ALBUMID%TYPE;
    SOME_TITLE ALBUM.TITLE%TYPE;
BEGIN
    GET_ALL_ALBUMS(S);
    
    LOOP
        FETCH S INTO SOME_ID, SOME_TITLE;
        EXIT WHEN S%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(SOME_ID||' IS CURRENT ID, '||SOME_TITLE||' IS CURRENT NAME');
    END LOOP;
    CLOSE S;
END;

/*Stored Procedure input variables + table*/
CREATE OR REPLACE PROCEDURE SP_BIRTHDAY(PERSON_ID IN INTEGER, YEARSPAST IN INTEGER) AS
BEGIN /*SET TRANSACTION READ LEVELS*/
    /*IF TRUE THEN DBMS_OUTPUT.PUT_LINE('VALID');
    ELSE DBMS_OUTPUT.PUT_LINE('INVALID'); END IF;*/
    UPDATE PERSON SET P_AGE=P_AGE+YEARSPAST WHERE P_ID = PERSON_ID;
    DBMS_OUTPUT.PUT_LINE('AGED BY '||YEARSPAST||' YEARS.');
    COMMIT;
    
    EXCEPTION WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('FAILED');
    ROLLBACK;
END;

BEGIN SP_BIRTHDAY(2, 5); END;

SELECT * FROM PERSON;






