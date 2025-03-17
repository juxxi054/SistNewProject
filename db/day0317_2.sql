--Rollup 함수
--자동으로 소계/합계를 구해주는 함수
--Groupby절에 주어진 조건으로 소계구해준다

select deptno,position,sum(pay) from professor group by position,rollup(deptno);

select position,count(*),sum(pay) from professor group by rollup(position);

--cube  전체총합계까지 출력하려면 _rollup처럼 각소계에 총계까지 구해준다
select deptno,count(*),sum(pay) from professor group by cube(deptno);

--emp에서 직업별 인원수 최대급여 최소급여 구하세요 직업의 오름차순
select job,count(job) "인원수" ,max(sal) "최대급여" ,min(sal)"최소급여" from emp group by job order by job;

--emp에서 부서별 부서번호,인원수,급여평균,급여의 합 조회
select deptno,count(*) 인원수,round(avg(sal),2) 급여평균,sum(sal) 급여합계
from emp group by deptno;

--입사년도별 인원수,sal의 평균(소수점없이) 출력하되 입사년도의 오름차순
select to_char(hiredate,'yyyy') 입사년도,count(*) 인원수,round(avg(sal),0) 평균급여
from emp group by to_char(hiredate,'yyyy') order by to_char(hiredate,'yyyy');

--[DML]
--department에 정보넣기
--102 - 유아교육과    200(null가능)
--103 - 미술교육과    400
--201 - 영문학과       500
--202 - 국문학과       600

insert into department (deptno,dname) values(102,'유아교육과');
insert into department (deptno,dname) values(103,'미술교육과');
insert into department (deptno,dname) values(201,'영문학과');
insert into department (deptno,dname) values(202,'국문학과');

--공과대학,인문대학 삭제
delete from department where deptno=10;
delete from department where deptno=20;

select * from department;

--professor에 데이타 입력
5001,손흥민,loveme,정교수,500,입사일:오늘,301

insert into professor (profno,name,id,position,pay,hiredate,deptno)
values(5001,'손흥민','loveme','정교수',500,sysdate,301);

--조교수들의 보너스를 일괄 100만원으로 인상해주세요
update professor set bonus=100 where position='조교수';

--손흥민교수와 동일한 직급을 가진 교수들중 500이 안되는 교수들의 급여를 15%인상하세요
update professor set pay=pay*1.15 where position=(select position from professor where name='손흥민')
and pay<500;

--dept2에서 부서번호 1001~1009 사이의 매장들을 모두 삭제해주세요
delete from dept2 where dcode between 1001 and 1009;

--alter 테이블의 구조변경
--dept2를 복제하여 dept3를 만들어 주세요
create table dept3 as select* from dept2;

--dept3에 loc를 추가하고 기본값으로 대한민국이라고 넣을것
alter table dept3 add loc varchar2(20) default '대한민국';

--포항본사의 loc를 포항시청앞 으로 수정해 주세요
update dept3 set loc='포항시청앞' where dcode=0001;

--emp테이블에 TotSal 열을 하나 더 추가해주세요  number(20);
alter table emp add Totsal number(20);
--sal+comm을 더해서 데이터를 추가해주세요
update emp set totsal=sal+NVL(comm,0);


-------------------------------------------------------------------------
--과제테이블 만들기---------------------------------------------------------

--1.sequence : seqshop (1부터 2씩증가 캐쉬없음)

--2.테이블 :Myshop
 -- no  number(5) 기본키 (시퀀스)
 --sangpum  varchar2(30),
 --su  number(10)
 --price  number(10)
 --size  varchar2(30)
 --ipgoday  date  (오늘날짜)
 
 --최소5개 이상 insert 해볼것!!!









desc dept3;
select * from dept3;



commit;