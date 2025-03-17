

--Rollup 함수
--자동으로 소계/합계를 구해주는 함수
--Groupby절에 주어진 조건으로 소계구해준다

select deptno,position,sum(pay) from professor group by position ,rollup(deptno);

select position,count(*),sum(pay) from professor group by rollup(position);

--cube 전체 총합계까지 출력하려면_rolluup 처럼 각소계에 총계까지 구해준다
select deptno,count(*),sum(pay) from professor group by cube (deptno);

--emp에서 직업별 인원수 최대급여 최소급여 구하세요
select job,count(job)"인원수",max(sal)"최대급여",min(sal)"최소급여" from emp group by job order by job;
--emp에서 부서번호,인원수,급여평균,급여의 합 조회
select deptno,count(*) 인원수,round(avg(sal),2) 급여평균,round(sum(sal),2) 급여합계
from emp group by deptno;

--입사년도별 인원수,sal의평균(소수점없이) 출력하되 입사년도의 오름차순
select to_char(hiredate,'yyyy') 입사년도,count(*),round(avg(sal),0) 평균급여
from emp group by to_char(hiredate,'yyyy') order by to_char(hiredate,'yyyy');

--[DML]
--department에 정보 넣기

insert into department (deptno,dname) values(102,'유아교육과');
insert into department (deptno,dname) values(103,'미술교육과');
insert into department (deptno,dname) values(201,'영문학과');
insert into department (deptno,dname) values(202,'국문학과');

--professor에 데이터 입력
5001,이준영,loveme,정교수,500,입사일:오늘,보너스없음,301

insert into professor (profno,name,id,position,pay,hiredate,deptno) 
values(5001,'이준영','loveme','정교수',500,'sysdate',301);

--손흥민 교수와 동일한 직급을 가진 교수들중 500이 안되는 교수들의 급여를 15%인상 하시오
update professor set pay=pay*1.15 where position=(select position from professor where name='손흥민')
and pay<500;

-- dept2에서 부서번호 1001~1009 사이의 매장들을 모두 삭제해주세요
delete from dept2 where dcode between 1001 and 1009;

--alter 테이블의 구조변경
--dept2를 복제하여 dept3를 만들어주세요
creat table dept3 as select* from dept2;

--dept3에 loc를 추가하고 기본값으로 대한민국이라고 넣을것
alter table dept3 add loc varchar2(20) default '대한민국';

--포항본사의 loc를 포항시청앞으로 수정해주세요
update date3 set loc='포항시청앞' where dcode=1001;

--emp테이블에 TotSal 열을 추가해주세요 (number(20);
alter table emp add TotSal number(30);

--sal+comm을 더해서 데이터를 추가해주세요
update emp set totsal=sal+NVL(comm,0);








