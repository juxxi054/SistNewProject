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

