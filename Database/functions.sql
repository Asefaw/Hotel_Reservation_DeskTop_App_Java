--------------------------------------------------------
--  File created - Wednesday-February-22-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Function CHECKOUT
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE FUNCTION "HOTELADMIN"."CHECKOUT" 
(
  room_numb IN room.roomnumber%type 
, last_name IN customer.lastname%type 
) RETURN types_cursor.ref_cursor
  AS 
    guest types_cursor.ref_cursor;
BEGIN
  OPEN guest for
    SELECT tr.roomNumber, firstName, lastName, checkinDate,checkoutDate, totalCharge
    FROM transaction tr
      INNER JOIN customer cust ON
        tr.customerid = cust.customerid
      INNER JOIN ROOM rm ON tr.roomnumber = rm.roomnumber
    WHERE tr.roomnumber = room_numb AND cust.lastname = last_name
          AND rm.available = 'NO';
    
    RETURN guest;
  CLOSE guest;
END CHECKOUT;

/
--------------------------------------------------------
--  DDL for Function EMP_VERIFY
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE FUNCTION "HOTELADMIN"."EMP_VERIFY" 
  (
    uname IN employee.userName%type,
    pass  IN employee.password%type
  )  
  RETURN types_cursor.ref_cursor
  AS
    room_cursor types_cursor.ref_cursor;
BEGIN
    open room_cursor for
      select * 
      from employee
      where userName = uname AND password = pass;
    return room_cursor;
END emp_verify;

/
--------------------------------------------------------
--  DDL for Function GET_ROOM_BY_FLOOR
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE FUNCTION "HOTELADMIN"."GET_ROOM_BY_FLOOR" 
(
  FLOOR_NUM IN  room.floor%type 
) 
  RETURN types_cursor.ref_cursor
  AS
    room_cursor types_cursor.ref_cursor;
BEGIN
    open room_cursor for
      select * from room
      where floor = floor_num;
    return room_cursor;
END GET_ROOM_BY_FLOOR;

/
--------------------------------------------------------
--  DDL for Function GET_ROOM_BY_TYPE
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE FUNCTION "HOTELADMIN"."GET_ROOM_BY_TYPE" 
(
  room_type IN  room.roomType%type
) 
  RETURN types_cursor.ref_cursor
  AS
    room_cursor Types_cursor.ref_cursor;
BEGIN
    open room_cursor for
      select * from room
      where RoomType = room_type;
    return room_cursor;
END GET_ROOM_BY_TYPE;

/
--------------------------------------------------------
--  DDL for Function GET_ROOMS
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE FUNCTION "HOTELADMIN"."GET_ROOMS" 
  (
    avail IN room.available%type 
  )
  RETURN types_cursor.ref_cursor
  AS
    room_cursor types_cursor.ref_cursor;
BEGIN
    open room_cursor for
      select * 
      from room
      where available = avail;
    return room_cursor;
END GET_ROOMS;

/
--------------------------------------------------------
--  DDL for Function GET_TAX
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE FUNCTION "HOTELADMIN"."GET_TAX" 
RETURN TYPES_CURSOR.ref_cursor
AS 
  tax_cursor TYPES_CURSOR.ref_cursor;
BEGIN
   open tax_cursor for
    select tax
    from fee;
  return tax_cursor;
END GET_TAX;

/
--------------------------------------------------------
--  DDL for Function GETEMPLOYEE
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE FUNCTION "HOTELADMIN"."GETEMPLOYEE" 
 RETURN TYPES_CURSOR.REF_CURSOR 
 AS 
  emp_cursor TYPES_CURSOR.REF_CURSOR; 
BEGIN
  open emp_cursor for
    select *
    from employee;
  return emp_cursor;
END GETEMPLOYEE;

/
