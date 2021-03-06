/*Drop database if it exists*/
DROP USER bear CASCADE;

/*Create the database user*/
CREATE USER bear
IDENTIFIED BY bear
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to bear;
GRANT resource to bear;
GRANT create session to bear;
GRANT CREATE TABLE TO bear;
GRANT CREATE view To bear;

/*Connect as new user, otherwise will use current user*/
CONNECT bear/bear;

/*Create tables*/
CREATE TABLE CAVE (
    CAVE_ID INTEGER PRIMARY KEY,
    CAVE_NAME VARCHAR2(100),
    MAX_BEARS INTEGER DEFAULT 4
);

CREATE TABLE BEAR (
    BEAR_ID INTEGER PRIMARY KEY,
    BEAR_NAME VARCHAR2(100),
    BEAR_SPECIES VARCHAR2(100),
    BEAR_AGE INTEGER,
    BEAR_WEIGHT INTEGER DEFAULT 200,
    CAVE_ID INTEGER
);

/*Create foreign keys*/
ALTER TABLE BEAR ADD CONSTRAINT FK_CAVE_ID FOREIGN KEY (CAVE_ID)
    REFERENCES CAVE (CAVE_ID) ON DELETE CASCADE;

/*Create sequences*/
CREATE SEQUENCE SQ_PK_CAVE
START WITH 1
INCREMENT BY 1;
/

CREATE SEQUENCE SQ_PK_BEAR
START WITH 1
INCREMENT BY 1;
/

/*Create triggers*/
CREATE OR REPLACE TRIGGER TR_INSERT_CAVE
BEFORE INSERT ON CAVE
FOR EACH ROW
BEGIN
    SELECT SQ_PK_CAVE.NEXTVAL INTO :NEW.CAVE_ID FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER TR_INSERT_BEAR
BEFORE INSERT ON BEAR
FOR EACH ROW
BEGIN
    SELECT SQ_PK_BEAR.NEXTVAL INTO :NEW.BEAR_ID FROM DUAL;
END;
/

/*Stored Procedure*/
CREATE OR REPLACE PROCEDURE SP_FEED_BEAR 
    (B_ID IN NUMBER, AMT IN NUMBER) AS
BEGIN
    UPDATE BEAR SET BEAR_WEIGHT = BEAR_WEIGHT + AMT
        WHERE BEAR_ID = B_ID;
    COMMIT;
END;
/

/*Populating tables*/
INSERT INTO CAVE (CAVE_NAME, MAX_BEARS) VALUES ('Cave 1', 5);
INSERT INTO CAVE (CAVE_NAME, MAX_BEARS) VALUES ('Cave 2', 2);
INSERT INTO CAVE (CAVE_NAME, MAX_BEARS) VALUES ('Cave 3', 3);

INSERT INTO BEAR (BEAR_NAME, BEAR_SPECIES, BEAR_AGE, BEAR_WEIGHT, CAVE_ID)
    VALUES ('Yogi', 'Grizzly', 4, 300, 1);
INSERT INTO BEAR (BEAR_NAME, BEAR_SPECIES, BEAR_AGE, BEAR_WEIGHT, CAVE_ID)
    VALUES ('Boo Boo', 'Grizzly', 2, 100, 1);
INSERT INTO BEAR (BEAR_NAME, BEAR_SPECIES, BEAR_AGE, BEAR_WEIGHT, CAVE_ID)
    VALUES ('Baloo', 'Brown', 6, 400, 2);
INSERT INTO BEAR (BEAR_NAME, BEAR_SPECIES, BEAR_AGE, BEAR_WEIGHT, CAVE_ID)
    VALUES ('Cindy', 'Grizzly', 3, 200, 1);
INSERT INTO BEAR (BEAR_NAME, BEAR_SPECIES, BEAR_AGE, BEAR_WEIGHT, CAVE_ID)
    VALUES ('Hei Bai', 'Panda', 300, 800, 3);
INSERT INTO BEAR (BEAR_NAME, BEAR_SPECIES, BEAR_AGE, BEAR_WEIGHT, CAVE_ID)
    VALUES ('Koda', 'Grizzly', 20, 500, 3);
INSERT INTO BEAR (BEAR_NAME, BEAR_SPECIES, BEAR_AGE, BEAR_WEIGHT, CAVE_ID)
    VALUES ('Molly', 'Brown', 5, 200, 2);

