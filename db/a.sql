
create table bookLogin(
 id varchar2(32),
 pw varchar2(32),
 name varchar2(32),
 email varchar2(64)
);
  
create table bookboard(
 bid number(8),
 time DATE,
 writer varchar2(32),
 title varchar2(256),
 booktitle varchar2(256),
 text clob,
 genre varchar2(32),
 grade number(8)
);

create table announce(
 bid number(8),
 writer varchar2(32),
 title varchar2(256),
 text clob,
 time DATE
);

create table imageboard(
 bid number(8),
 Ititle varchar2(32),
 savefilename varchar2(256)
);

select * from bookboard;
insert into bookboard values(1,sysdate, 'yena','testitle','testtext','test','test',1);
insert into bookboard values(1,sysdate, '예나','테스트제목','testtext','test','test',1);