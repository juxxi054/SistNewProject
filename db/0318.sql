--테이블생성
create table sawon (num number(5) CONSTRAINT sawon_pk_num primary key,
name varchar2(20),gender varchar2(20),
buseo varchar2(20),pay number(10) default 1200000);

--alter로 제약조건 추가가능 (부서명: 개발부,교육부,디자인부)
alter table sawon add constraint ck_sawon_buseo check(buseo in ('개발부','교육부','디자인부'));

--제약조건추가: 남자,여자만 가능하다
alter table sawon add constraint ck_sawon_gender check(gender in ('남자','여자'));

--새로운 시퀀스
create sequence seq_sawon nocache;

--데이타추가
insert into sawon values(seq_sawon.nextval,'이승연','남자','교육부',2500000);
insert into sawon values(seq_sawon.nextval,'김준면','남자','개발부',3200000);
insert into sawon values(seq_sawon.nextval,'최지인','여자','디자인부',3400000);
insert into sawon values(seq_sawon.nextval,'오승아','여자','디자인부',3400000);
insert into sawon values(seq_sawon.nextval,'김승택','남자','교육부',2700000);
insert into sawon values(seq_sawon.nextval,'이주은','여자','교육부',2900000);
insert into sawon values(seq_sawon.nextval,'이승훈','남자','개발부',3500000);
insert into sawon values(seq_sawon.nextval,'남주아','여자','개발부',3400000);
insert into sawon values(seq_sawon.nextval,'안정훈','남자','교육부',2900000);

--수정
update sawon set buseo='교육부';
--다시 취소
rollback;

--여러컬럼 수정 9번 부서 개발부 pay=2800000
update sawon set buseo='개발부',pay=2800000 where num=10;

--최종저장
commit;

--그룹함수
--부서별 인원수와 최고급여,최저급여 조회 (제목도 한글로..)
select buseo 부서명,count(*) 인원수,max(pay) 최고급여,min(pay)최저급여
from sawon group by buseo;

--위의 결과에 화폐단위 붙히고 천단위 구분기호
select buseo 부서명,count(*) 인원수,to_char(max(pay),'L999,999,999')최고급여,to_char(min(pay),'L999,999,999')최저급여
from sawon group by buseo;

--위의 결과에 인원수 뒤에 명이라고 붙히기
select buseo 부서명,count(*)||'명' 인원수,to_char(max(pay),'L999,999,999')최고급여,to_char(min(pay),'L999,999,999')최저급여
from sawon group by buseo;

--성별 인원수와 평균급여,최고급여,최저급여를 구하시오
select gender 성별,count(gender) 인원수,to_char(avg(pay),'L999,999,999')평균급여,to_char(max (pay),'L999,999,999')최고급여,to_char(min(pay),'L999,999,999')최저급여
from sawon group by gender;

--부서별 인원이 4명이이상인 경우에만 출력
select buseo 부서명,count (buseo) 인원수 ,to_char(avg(pay),'L999,999,999') 평균급여 from sawon group by buseo having count(buseo)>=4; 

--제약조건 제거
--sawon테이블의 sawon_ck_buseo를 제거해보기
alter table sawon drop constraint ck_sawon_buseo;

--다른부서 추가해보기
insert into sawon values(seq_sawon.nextval,'이서아','여자','홍보부',3300000);

commit;


--sawon에 name 컬럼에 unique제약조건 추가하기(sawon_uk_name)
alter table sawon add CONSTRAINT sawon_uk_name UNIQUE(name);

--name컬럼에 중복이름 넣어보기
INSERT into sawon VALUES(seq_sawon.nextval,'안성한','남자','교육부',2900000);


--[join]
--emp와 dept를 조인해서 emp사람들의 이름과 부서를 구하시오
select ename,deptno from emp;
--2개의 테이블을 조합하여 보고싶은 컬럼을 조회할수있다
select e.ename,d.dname 
from emp e,dept d
where e.deptno=d.deptno;

--professor+depeatmaent를 조인하여 다음과 같이 조회
--교수명 학과명 급여를 조회하시오
select name,dname,pay
from professor p,department d
where  p.deptno=d.deptno;


--emp에 dept에 없는 deptno를 삽입하거나 null로 인서트 해보자
insert into emp(empno,ename,job,mgr,sal)values(7937,'KIM','MANAGER',7902,1200);

--조인
SELECT e.ename,d.dname
from emp e,dept d
where e.deptno=d.deptno;


--LEE와KIM이 조인에서 조회가 안된다 만약 NULL까지 조회하고 싶다면 outer join 이용

SELECT e.ename,d.dname
from emp e,dept d
where e.deptno=d.deptno(+);

--대상테이블에 값이 없어도 조회가 된다(null)로

--학생테이블
--학번 학생이름 학년 제1전공
--1111 서영주  2    컴퓨터공학과
select s.studno,s.name,s.grade,d.dname 제1전공,p.name 담당교수
from student s,department d,professor p
where s.deptno1=d.deptno and s.profno=p.profno;

SELECT * from emp;


--paname+prodect
--입고날짜 상품명 상품가격 입고갯수 총가격
--20240101 새우깡 800    3      2400 

select p_date 입고날짜,p_name 상품명,p_price 상품가격,p_qty 입고갯수,p_total 총가격
from panmae pan,product pro
where pan.p_code=pro.p_code;



--[조인 연습용 테이블 생성하기]


--[조인 연습용 테이블 생성하기]
create table food(num number(3)primary key,
foodname varchar2(20),
foodprice number(7),
foodsize varchar2(20));

drop table food;

create table booking(bnum number(3) constraint pk_booking_bnum primary key,
bname varchar2(20) constraint nn_booking_bname not null,
bhp varchar2(20) constraint uq_booking_bhp unique,
num number(3),
bday date,
constraint fk_num foreign key(num) references food(num));

--food테이블에 메뉴등록
insert into food values(100,'짜장면',9000,'보통');

insert into food values(101,'짬뽕',11000,'곱배기');
insert into food values(102,'탕수육',29000,'대');
insert into food values(103,'유린기',39000,'대');
insert into food values(104,'칠리새우',19000,'소');
insert into food values(105,'해물덮밥',12000,'보통');
insert into food values(106,'울면',9000,'보통');
commit;

--시퀀스생성
create sequence seq_food start with 10 increment by 10 nocache;

--예약
--메뉴에 없는 foodnum을 넣으면 부모키가 없다는 제약조건위배가 나온다
insert into booking values(seq_food.nextval,'이영지','010-111-2222',100,sysdate);
insert into booking values(seq_food.nextval,'김연지','010-777-8888',100,sysdate);
insert into booking values(seq_food.nextval,'이영돈','010-999-2222',101,sysdate);
insert into booking values(seq_food.nextval,'김혜지','010-888-9999',105,sysdate);
insert into booking values(seq_food.nextval,'이우형','010-444-7845',103,sysdate);

--INNER JOIN으로 예약손님 주문정보 확인
--주문자이름,주문자전화번호,음식이름,음식가격,음식사이즈,주문한날짜
select bname,bhp,foodname,foodprice,foodsize,to_char(bday,'yyyy-MM-dd') bday
from food f,booking b
where f.num=b.num;

--outer_join을 이용해서 한번도 주문하지않은 메뉴들 알아보기
select f.num,bname,foodname,foodprice,foodsize
from food f,booking b
where f.num=b.num(+); --이때 아무도 주문하지 않은 메뉴는 주문자가 null로 나온다

--위의 sql을 통해서 주문자 이름빼고 null인경우만 출력하면 아무도 주문하지않은 메뉴만 골라낼수있다
SELECT f.num,foodname,foodprice,foodsize
from food f,booking b
WHERE f.num=b.num(+) and bname is null;


--bboking(자식테이블)에 추가된 메뉴를 food(부모테이블)에서 삭제할수있을까?
--자식테이블 생성시 on delete cascade 설정을 안했을 경우 못지운다
delete from food where foodnum=101; --booking테이블에서 주문했으므로 101번은 못지운다

--아무도 주문하지 않는 104번 지워보자
delete from food where num=104;

--부모테이블 삭제
drop table food; --삭제 안됨 / 자식테이블을 먼저 삭제해야 부모테이블도 삭제가 가능

--bookomg 먼저 지우고 food 삭제 순으로 가야한다
drop table booking;
drop table food;

--시퀀스도 삭제--
drop sequence seq_food;


select * from food;
select * from booking;


--비정규화 테이블
--회사테이블:companysawon
--회사명:company 문자열 (10)
--회사주소:address 문자열(10)
--회사전화:phone 문자열(15)
--직원명:sawon_name 문자열(15)
--직급:position 문자열(10)
--이메일: email 문자열(20)
--휴대폰; hp 문자열(20)

create table companysawon(company VARCHAR2(10),address VARCHAR2(20),
phone VARCHAR2(15),sawon_name VARCHAR2(15),position VARCHAR2(10),email VARCHAR2(20),
hp VARCHAR2(20));

insert into companysawon VALUES('LS','서울시 강남구','02-124-5555','김석형','사원','wed@naver.com','010-0480-7854');
insert into companysawon VALUES('LG','서울시 강북구','02-134-6855','김준형','대리','hjf@naver.com','010-0678-6544');

--거래처 회사에 대한 정보 : 거래처 직원을 추가할때마다 매번 추가
--메모리 낭비 심하다
--만약 회사 이전 승진등등 정보가 변경되면 많은 데이타를 한꺼번에 수정해주어야 한다
--정규화된 테이블정보로 수정이 필요한 것이다

--2.정규화된 데이터 정보로 수정
--회사테이블:company
--회사아이디:company_id number(5) 기본키
--회사명:
--회사주소:
--회사전화번호

--부모테이블
CREATE table company (company_id number(5) primary key,
company VARCHAR2(20),address VARCHAR2(20),phone VARCHAR2(20));


--부모데이터 추가
insert into company VALUES(10,'KT','경기도 이천시','02-7458-7954');
insert into company VALUES(20,'SK','경기도 부천시','02-5648-5654');
insert into company VALUES(30,'삼성','경기도 안산시','02-4453-7856');

--자식테이블
--사원테이블:sawon
--직원명:
--직급:
--이메일:
--휴대폰:
--회사아이디: 외부키

create table sawon2(company_id number(5),
sawon_name VARCHAR2(20),position VARCHAR2(20),
email VARCHAR2(20),hp VARCHAR2(20),
constraint sawon_fk_id foreign key(company_id) references company(company_id));

--cascade
create table sawon3(company_id number(5),
sawon_name varchar2(20),position2 varchar2(20),
email varchar2(20),hp varchar2(20),
constraint sawon_fk_id foreign key(company_id) references company(company_id)
on delete cascade);

--on delete cascade: 외부키로 테이블이 연결되었다 하더라도 부모테이블의 데이타를 삭제하면
--자식테이블의 데이타까지 자동으로 삭제시켜 주는 기능

--시퀀스 생성
create sequence seq_shop;

--shop테이블(부모테이블)
create table shop(num number(5) primary key,
sangpum VARCHAR2(30),color VARCHAR2(20));

--shop에 5개이상 상품 추가
insert into shop values(seq_shop.nextval,'안경','블랙');
insert into shop values(seq_shop.nextval,'운동화','화이트');
insert into shop values(seq_shop.nextval,'자켓','브라운');
insert into shop values(seq_shop.nextval,'스커트','핑크');
insert into shop values(seq_shop.nextval,'반팔','그린');

commit;


--cart1: 자식테이블  shop테이블의 num값을 외부키로 지정한다
create table cart1(idx number(5) primary key,
num number(5) constraint cart_fk_num references shop(num),
cnt number(5),guipday date);

--create table cart1(idx number(5) primary key,
--num number(5),
--cnt number(5),guipday date,
--constraint cart_fk_num foreign key(num) references shop(num));

--cart2:부모테이블의 상품을 지우면 그상품과 연결된 카트를 자동으로 지워준다
create table cart2(idx number(5) primary key,
num number(5) constraint cart2_fk_num references shop(num) on delete cascade,
cnt number(5),guipday date);


--cart1에 상품추가
insert into cart1 values (seq_shop.nextval,1,2,sysdate);
insert into cart1 values (seq_shop.nextval,5,1,sysdate);

--shop없는 상품 담았을경우
--insert into cart1 values(seq_shop.naxtval,6,1,sysdate);--무결성제약조건(ANGEL.CART_FK_NUM)이 위배되었습니다 -부모키가 없습니다

--  cart2 상품추가
insert into cart2 values(seq_shop.nextval,3,3,sysdate); --3
insert into cart2 values(seq_shop.nextval,2,4,sysdate); --2

--cart1에는 1번,5번을 추가되었다 이때 shop의 1번상품을 삭제해보자
delete from shop where num=1;
--무결성 제약조건(ANGEL.CART_FK_NUM)이 위배되었습니다- 자식 레코드가 발견

--cart1에 담기지않은 shop 4번 삭제해보자
delete from shop where num=4; --삭제됨

--확인후 아까우니까 살린다
rollback;

--cart2..3번2번 상품이 담겼다 3번 삭제 될까?
delete from shop where num=3;

--cart1,cart2 각각 5개씩 담아보기
insert into cart1 values(seq_shop.nextval,2,1,sysdate);
insert into cart1 values(seq_shop.nextval,1,2,sysdate);
insert into cart1 values(seq_shop.nextval,5,3,sysdate);

insert into cart2 values(seq_shop.nextval,2,1,sysdate);
insert into cart2 values(seq_shop.nextval,1,2,sysdate);
insert into cart2 values(seq_shop.nextval,5,3,sysdate);
insert into cart2 values(seq_shop.nextval,2,1,sysdate);
insert into cart2 values(seq_shop.nextval,2,6,sysdate);
insert into cart2 values(seq_shop.nextval,1,5,sysdate);


select * from shop;
select * from cart1;
select * from cart2;



--cart1에 담긴 상품을 shop테이블과 join해서 자세히 출력해보기
--방법1
select cart1.idx,shop.num,shop.sangpum,shop.color,cart1.cnt,cart1.guipday
from shop,cart1
where shop.num=cart1.num;

--방법2
select c.idx,s.num,s.sangpum,s.color,c.cnt,c.guipday
from shop s,cart1 c
where s.num=c.num;

--방법3
select idx,s.num,sangpum,color,cnt,guipday
from shop s,cart1 c
where s.num=c.num;
