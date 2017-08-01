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

SELECT * FROM PERSON;








