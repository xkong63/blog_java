	CREATE TABLE ARTICLE (

   id int(11) NOT NULL,

   title varchar(45) NOT NULL,

   content varchar(50000) NOT NULL,

   author varchar(45),
   updatedate DATETIME,
   PRIMARY KEY (id)

);


alter table ARTICLE modify id int(11) NOT NULL AUTO_INCREMENT;

alter table ARTICLE modify content TEXT NOT NULL;

alter table ARTICLE modify updatedate DATETIME;