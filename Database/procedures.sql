--------------------------------------------------------
--  File created - Monday-April-25-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Procedure UPDATE_ROOM
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "HOTELADMIN"."UPDATE_ROOM" 
(
  ROOM_NUM IN room.roomnumber%type
) AS 
BEGIN
  update room
  set available = 'NO'
  where roomnumber = ROOM_NUM;
END update_room;

/
--------------------------------------------------------
--  DDL for Procedure ADDUSERACCOUNT
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "HOTELADMIN"."ADDUSERACCOUNT" 
(
  ACCOUNTID IN VARCHAR2  
, EMP_ID IN NUMBER  
, USER_NAME IN VARCHAR2  
, EMAIL IN VARCHAR2  
, PASS IN VARCHAR2  
) AS 
BEGIN
  insert into useraccount
  (
    useraccountid,empid, userName, email, password
  )
  values
  (
    accountid, emp_id, user_name, email, pass
  );
END ADDUSERACCOUNT;

/
--------------------------------------------------------
--  DDL for Procedure ADDTRANSACTON
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "HOTELADMIN"."ADDTRANSACTON" 
(
  ROOM_NUM IN transaction.roomnumber%type,
  CHECKIN_DATE IN transaction.checkindate%type,
  CUST_ID IN transaction.customerid%type,
  EMP_ID IN transaction.employeeid%type, 
  CHECKOUT_DATE IN transaction.checkoutdate%type,
  TOTAL IN transaction.totalcharge%type, 
  CCARD IN transaction.creditcard%type, 
  EXP_MON IN transaction.expmonth%type, 
  EXP_YEAR IN transaction.expyear%type
) AS 
BEGIN
  insert into transaction
  (
    transactionid,roomnumber,checkindate,customerid,employeeid,checkoutdate,totalcharge,creditcard,expmonth,expyear
  )
  values
  (
    trans_seq.nextval, ROOM_NUM ,CHECKIN_DATE, CUST_ID, EMP_ID, CHECKOUT_DATE, TOTAL, CCARD, EXP_MON, EXP_YEAR  
  );
  
  update room
  set available = 'NO'
  where roomnumber = ROOM_NUM;
END addtransacton;

/
--------------------------------------------------------
--  DDL for Procedure ADDROOM
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "HOTELADMIN"."ADDROOM" 
(
  ROOM_NUM IN NUMBER  
, FLOOR IN NUMBER  
, room_TYPE IN VARCHAR2  
, PRICE IN NUMBER  
, AVAILABLE IN VARCHAR2  
) AS 
BEGIN
  insert into room
  (
   roomNumber, floor, roomType, price, available
  )
  values
  (
    room_num, floor, room_type, price, available
  );
END ADDROOM;

/
--------------------------------------------------------
--  DDL for Procedure ADDEMPLOYEE
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "HOTELADMIN"."ADDEMPLOYEE" 
(
  SSN IN VARCHAR2  
, FIRST_NAME IN VARCHAR2  
, LAST_NAME IN VARCHAR2  
, DOB IN DATE  
, ADDRESS IN VARCHAR2  
, PHONE IN VARCHAR2  
, EMAIL IN VARCHAR2  
, TITLE IN VARCHAR2  
) AS 
BEGIN
  insert into employee
  (
    ssnumber,firstname, lastname, dateofbirth,address,phone, email,title
  )
  values
  (
    ssn, first_name, last_name, dob, address, phone, email, title
  );
END ADDEMPLOYEE;

/
--------------------------------------------------------
--  DDL for Procedure ADDCUSTOMER
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "HOTELADMIN"."ADDCUSTOMER" 
(
  CUST_ID IN VARCHAR2,
  FIRST_NAME IN VARCHAR2,
  LAST_NAME IN VARCHAR2,
  DOB IN DATE,
  ADDR IN VARCHAR2,
  PHONE IN VARCHAR2,
  EMAIL IN VARCHAR2,
  CITY IN VARCHAR2,
  STATE IN VARCHAR2,
  ZIP IN VARCHAR2  
) AS 
BEGIN
  insert into customer
  (
    customerid,firstname,lastname,dateofbirth,address,phone,email,city,state,zipcode
  )
  values
  (
    cust_id,first_name,last_name, dob, addr,phone, email, city, state,zip
  );
END ADDCUSTOMER;

/
