--------------------------------------------------------
--  DDL for Table SWISS_BANK
--------------------------------------------------------

  CREATE TABLE "SYSTEM"."SWISS_BANK" 
   (	"NAME" VARCHAR2(4000 BYTE), 
	"ACCNO" NUMBER, 
	"BALANCE" NUMBER, 
	"CUSTID" VARCHAR2(4000 BYTE), 
	"PWD" VARCHAR2(4000 BYTE), 
	"EMAIL" VARCHAR2(4000 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SYSTEM" ;
