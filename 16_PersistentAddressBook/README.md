### How to run the app

You need to make sure h2 is running to be able to run the app.

Something like this:

```bash
brew install h2
h2
```

The browser console of the H2 database should pop up. Log in and execute the following SQL.

```sql
CREATE TABLE ADDRESS (ID IDENTITY PRIMARY KEY,
                      LINE_1 VARCHAR(32),
                      LINE_2 VARCHAR(32),
                      CITY VARCHAR(32),
                      POST_CODE VARCHAR(9));
CREATE TABLE PERSON (ID IDENTITY PRIMARY KEY,
                     FIRST_NAME VARCHAR(32),
                     LAST_NAME VARCHAR(32),
                     ADDRESS_ID INT);
ALTER TABLE PERSON ADD FOREIGN KEY (ADDRESS_ID) REFERENCES ADDRESS(ID);

INSERT INTO ADDRESS (LINE_1, LINE_2, CITY, POST_CODE) VALUES ('2', 'Kingsway', 'London', 'SE3 5TE');
INSERT INTO ADDRESS (LINE_1, LINE_2, CITY, POST_CODE) VALUES ('25', 'The Ridge', 'Bedford', 'MK17 3XS');
INSERT INTO PERSON (FIRST_NAME, LAST_NAME, ADDRESS_ID) VALUES ('John', 'Adams', 1);
INSERT INTO PERSON (FIRST_NAME, LAST_NAME, ADDRESS_ID) VALUES ('Maria', 'Adams', 1);
INSERT INTO PERSON (FIRST_NAME, LAST_NAME, ADDRESS_ID) VALUES ('Susan', 'Smith', 2);
INSERT INTO PERSON (FIRST_NAME, LAST_NAME, ADDRESS_ID) VALUES ('Marcus', 'Smith', 2);
INSERT INTO PERSON (FIRST_NAME, LAST_NAME, ADDRESS_ID) VALUES ('Alex', 'Smith', 2);
```

Now you're ready to run the app.
