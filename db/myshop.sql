

-----과제 테이블 만들기-----------------------------------------------------

--1.sequence : seqshop (1부터 2씩 증가 캐쉬없음)
create sequence seqshop start with 1 increment by 2 nocache;
--2.table: Myshop
 create table Myshop (no number(5) primary key,  
    sangpum varchar2(30),su number(10),price number(10),          
    size1 varchar2(30),ipgoday date default sysdate);
--no number(5) 기본키 (시퀀스)
--sangpum varchar2(30),
--su number(10)
--proce number(10)
--size varchar2(30)
--ipgoday date(오늘날짜)

--최소5개 이상 insert해볼것
insert into Myshop (no, sangpum, su, price, size1, ipgoday)
values (seqshop.nextval, '스커트', 10, 50000,'s', sysdate);
insert into Myshop (no, sangpum, su, price, size1, ipgoday)
values (seqshop.nextval, '청바지', 25, 64000,'m', sysdate);
insert into Myshop (no, sangpum, su, price, size1, ipgoday)
values (seqshop.nextval, '가방', 16, 75000,'m', sysdate);
insert into Myshop (no, sangpum, su, price, size1, ipgoday)
values (seqshop.nextval, '티셔츠', 34, 22000,'xl', sysdate);
insert into Myshop (no, sangpum, su, price, size1, ipgoday)
values (seqshop.nextval, '패딩', 19, 160000,'m', sysdate);