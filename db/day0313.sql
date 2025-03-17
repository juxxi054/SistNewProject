--[복습]
--emp_사원명이 A로 시작하는 사람의 이름과 직업 급여를 조회
select ename,job,sal from emp where ename LIKE 'A%';
--emp_급여가 평균보다 더높은 사람만 사원명 급여조회
select ename,sal from emp where sal>(select avg(sal) from emp);
--emp_입사일이 12월인 사람만 사원명,입사일 조회
select ename,hiredate from emp where to_char(hiredate,'mm')='12';
--student_1전공이 101번인 학과의 평균 몸무게 보다 몸무게가 많은 학생의 이름과 몸무게 조회
select name,weight from student where weight>(select avg(weight) from student where deptno1=101);
--professor_심슨교수와 같은입사일에 입사한 교수중에서 조인형교수보다 월급을 적게받는 교수의 이름,급여,입사일 조회
select name,pay,hiredate
from professor
where hiredate=(select hiredate from professor where name='심슨')
And pay<(select pay from professor where name='조인형');

--[그룹함수] Group By절_특정조건으로 세부적인 그룹
--professor_ 학과별로 교수들의 평균급여를 조회
select deptno,avg(NVL(pay,0)) "평균 급여" from professor group by deptno;
--professor_ 직급별로 교수들의 총급여를 조회
select position,sum(NVL(pay,0)) "총급여" from professor group by position;
--professor_학과별,직급별 교수들의 평균급여
select deptno,position,avg(NVL(pay,0)) "평균급여"
from professor
group by deptno,position;

--직급별 평균보너스
select position,avg(NVL(bonus,0)) "평균 보너스"
from professor
group by position;

--student,학년별 평균키와 최고몸무게 조회
select grade,avg(height),max(weight) from student group by grade;

--professor_직급별 평균 급여와 최고 보너스를 구하시오
select position,round(avg(pay),2),max(bonus) from professor group by position;

--emp_ job별로 sal의 최대값과 최소값 조회
select job,max(sal),min(sal) from emp group by job;

--emp_ job별로 인원수 조회
select job,count(*) from emp group by job;

--Having절_그룹내에서 조건을 주고 검색시 ...반드시 group by 뒤에..
--평균급여가 2000이상인 부서의 부서번호와 평균급여를 구하시오
select deptno,round(avg(NVL(sal,0)),2) from emp group by deptno having avg(sal)>2000;
--where 절은 그룹함수 비교조건으로 쓸수없다

--professor_평균급여가 450이상인 학과의 학과번호와 평균급여를 구하시오
select deptno,avg(pay) from professor group by deptno having avg(pay)>450;

--emp_job별로 직원수가 2명이상인경우의 부서를 조회하시오
select job,count(*)
from emp
where deptno IN (10,20,30)
group by job
having count(*)>2
order by job desc;

--emp_총급여가 5000이상인 job별로  급여의 합계를 조회하되 MANAGER는 제외하고 조회하되 
--단 급여가 많은 순서대로 조회할것

select job,sum(sal) "급여합계" from emp
where job not in ('MANAGER') --MANAGER는 제외
group by job --업무별로 그룹
having sum(sal)>=5000 --급여합계가 5000이상
order by sum(sal) desc; --급여합계 내림차순


--[DDL] & [DML]
--테이블 생성
create table test(num number(5) primary key,name varchar2(20),score number(6,2),birth date);

--구조확인
desc test;

--test에 insert
--전체데이타
insert into test values(1,'이상민',88.88,'1997-10-25');

--일부데이타
insert into test (num,name) values (2,'강민주');

--전체데이타 조회
select * from test;

--일부컬럼
select name from test;

--데이타 더 추가 (sysdate)
insert into test values(3,'손흥민',89.8,sysdate);

--무결성 제약조건 오류가 난다(num이 기본키이므로 같은값 넣을수 없으므로)
insert into test values (2,'손흥민',77,sysdate);

--나이를 저장할 컬럼 추가 ..기존의 추가못한 값은 모두 null로 추가
alter table test add age number(5);

--주소를 저장할 컬럼 추가..초기값을 강남구 라고 지정
alter table test add addr varchar2(30)default '강남구';

--주소 문자타입이 30==>50으로 변경
alter table test modify addr varchar2(50);

--나이 문자10으로 변경하고 기본값을 20
alter table test modify age varchar2(10) default '10';

--추가
insert into test values (4,'지니',77.5,sysdate,'21세','서울시 강서구');
insert into test(num,name,addr) values (5,'미숙','부산시 사하구');

--num 오름차순
select * from test order by num desc;

--age 컬럼 삭제
alter table test drop column age;

--addr삭제
alter table test drop column addr;

--score를 jumsoo로 컬럼변경
alter table test rename column score to jumsoo;

--birth-->birthday로 컬럼변경
alter table test rename column birth to birthday;

--test 테이블 삭제
drop table test;

--[시퀀스]
--유일한(UNIQUE) 값을 생성해주는 객체
--시퀀스를 생성하면 기본키처럼 순차적으로 증가하는 컬럼을 자동으로 생성가능
--primary key를 생성하기 위해 사용

--기본시퀀스 생성 1부터 1씩 증가
create sequence seq1;

--전체시퀀스 확인
select * from seq;

--다음시퀀스 값을 발생시켜 콘솔에 출력
select seq1.nextval from dual;

--현재 마지막값 발생 시퀀스 확인
select seq1.currval from dual;

--seq1삭제
drop sequence seq1;

--10부터 5씩 증가하는 시퀀스 생성 캐쉬없애기
create sequence seq1 start with 10 increment by 5 nocache;

--시퀀스 발생
select seq1.nextval from dual;

--시퀀스 수정
alter sequence seq1 increment by 10 maxvalue 100 cycle;

--삭제
drop sequence seq1;

--seq1 시작값: 5 증가값 :2 끝값:30 캐시:no  cycle:y 
create sequence seq1 start with 5 increment by 2 maxvalue 30 nocache cycle;
--seq2 시작값:1  증가값:2 캐시:no
create sequence seq2 start with 1 increment by 2 nocache;

--출력
select seq1.nextval,seq2.nextval from dual;

--시퀀스 삭제
drop sequence seq1;
drop sequence seq2;
------------------------------------------------------------------------
--시퀀스 생성
create sequence  seq1 nocache;
--테이블 생성
create table info(num number(5) primary key,name varchar2(20),
job varchar2(30),gender varchar2(10),age number(5),hp varchar2(20),birth date);

--birth-->ipsaday로 변경
alter table info rename column birth to ipsaday;

--조회연습 위해서 10개이상 insert job(프로그래머,교사,엔지니어)
insert into info values(seq1.nextval,'현승윤','프로그래머','남자',26,'010-111-2222','2022-01-26');

insert into info values(seq1.nextval,'현승윤','프로그래머','남자',26,'010-111-2222','2022-01-26');
insert into info values(seq1.nextval,'이우형','교사','남자',36,'010-444-2222','2020-11-26');
insert into info values(seq1.nextval,'최태림','엔지니어','여자',33,'010-777-8888','1998-07-26');
insert into info values(seq1.nextval,'원주희','교사','여자',28,'010-444-1111','2018-06-01');
insert into info values(seq1.nextval,'유혜지','프로그래머','여자',32,'010-145-2227','2018-03-26');
insert into info values(seq1.nextval,'현승윤','교사','남자',33,'010-777-2222','2011-01-26');
insert into info values(seq1.nextval,'유혜나','엔지니어','여자',29,'010-111-8888','2022-04-11');
insert into info values(seq1.nextval,'유혜승','프로그래머','남자',33,'010-478-2222','2017-01-18');
insert into info values(seq1.nextval,'현승애','교사','여자',26,'010-777-2222','2017-01-18');
insert into info values(seq1.nextval,'김승현','개그맨','남자',26,'010-444-8888','2014-08-26');

--최종저장
commit;

--최종인원 확인
select count(*) from info;

--나이의 역순으로 출력
select * from info order by age desc;

--컬럼명대신 컬럼번호를 써도된다(첫번째 열번호1)
select * from info order by 5 asc;

--성별오름차순,같을경우 이름의 내림차순
select * from info order by gender asc,name desc;

--어떤직업이 있는지 직업만 출력
select distinct job from info;

--성이 현씨만 조회
select * from info where name like '현%';

--핸드폰이 010인 사람만 조회
select * from info where hp like '010%';

--3월에 입사한 사람 조회
select * from info where to_char(ipsaday,'mm')='03';

--입사년도가 2022년도인 사람 조회
select * from info where to_char(ipsaday,'yyyy')='2022';

--나이가 30~40사이출력(2가지방법_between,and)
select * from info where age>=30 and age<=40;
select * from info where age between 30 and 40;

--직업이 교사이거나 엔지니어인사람 조회(2가지)
select * from info where job='교사'or job='엔지니어';
select * from info where job in ('교사','엔지니어');

--교사,엔지니어만 제외한직업 조회
select * from info where job not in('교사','엔지니어');

--문제
--성이 이씨이거나 최씨인 사람 조회
select * from info where name like '이%' or name like '최%';

--여자이면서 나이가 30세 이상 조회
select * from info where gender='여자' and age>=30;

--남자들 평균 나이구하기(소수점 한자리구함)
select round(avg(age),1) from info where gender='남자';

--성별 평균나이
select gender,round(avg(age),1) from info group by gender;

--평균나이보다 많은 사람의 이름과 직업 나이를 출력(서브쿼리)
select name,age,job from info where age>(select avg(age) from info);

--3월이나 6월에 입사한 사람 조회
select * from info where to_char(ipsaday,'mm')='03' or to_char(ipsaday,'mm')='06';

--테이블 복사본생성하기
create table info2 as select * from info;

--info 직업과 나이 수정..조건을 안쓰면 전체데이타 수정
update info set job='간호사',age='29';

--잘못수정한 데이타 원래대로 되돌리기
ROLLBACK;

--info 3번 직업과 나이 수정..조건을 안쓰면 전체데이타 수정
update info set job='연극배우',age='22' where num=3;

--최씨이면서 엔지니어인 사람의 성별을 남자로 변경
update info set gender='남자' where name like '최%' and job='엔지니어';

--num이 8번인 사람의 직업을 '유투버', 입사일을 24-12-25일로 수정하세요
update info set job='유투버',ipsaday='2024-12-25' where num=8;

--최종저장
commit;


--info2
--num이 5번인사람 삭제
delete from info2 where num=5;

--여자이면서 나이30이상 모두삭제
delete from info2 where gender='여자' and age>=30;

--7번이면서 핸드폰 끝자리가 2222인사람을 삭제하시오
delete from info2 where num=7 and hp like '%2222';

--직업이 교사이거나 프로그래머인사람 모두삭제
delete from info2 where job='교사' or job='프로그래머';

--컬럼추가하는데 주소addr 30바이트로 추가
alter table info2 add addr varchar2(30);

--컬럼명변경 hp-->handphone
alter table info2 rename column hp to handphone;

--데이타 추가하는데 num,name,gender,job,addr만 넣기
insert into info2(num,name,gender,job,addr) values (seq1.nextval,'이현아','여자','알바','서울시');

--핸드폰이 null 이 아닌 사람만 조회
select * from info2 where handphone is not null;

--null일경우 age는 20, 핸드폰은 ***   이름,직업,나이,핸드폰을 출력하시오
select name,NVL(age,10),NVL(handphone,'***-***-****') from info2;



desc info;
select * from info2;