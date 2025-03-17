--[복습]
--emp-comm이 null이 아닌사람중에서 sal이 1500이상인 사람 출력(사원명,급여,커미션)
select ename,sal,comm from emp where comm is not null and sal>=1500;

--emp_입사일이 1985/01/01 이후에 입사한 사람만 조회(사원명,입사일,급여)
select ename,hiredate,sal 
from emp 
where hiredate>='85/01/01';

--emp_ 이름,급여,보너스,총급여(급여+보너스)
select ename,sal,NVL(comm,0),sal+NVL(comm,0) from emp;

--[서브쿼리]_쿼리안에 또다른 쿼리문이 담김
--select 컬럼1,컬럼2 
--from emp
--where 조건연산자 (select 컬럼명 from 테이블 where 조건);
--메인쿼리(서브쿼리)

--emp_SMITH보다 급여를 많이 사람의 이름과 급여를 출력하시오
select ename,sal
from emp
where sal>(select sal from emp where ename='SMITH');
--서브쿼리가 먼저수행이 되어 결과값을 메인쿼리에 전달해 주고 그값을 받아서 메인쿼리 수행

--student_서진수의 키보다 작은사람의 학생명,학년,키를 출력하시오
select name,grade,height from student where height<(select height from student where name='서진수');

--student_1전공이 101학과의 평균 몸무게 보다 몸무게가 많은 학생명과 몸무게를 출력하시오
select name,weight from student where weight<(select avg(weight) from student where deptno1=101);

--emp_평균sal보다 많이받는사람의 모든목록 출력
select * from emp where sal>(select avg(sal) from emp);

--emp_ALLEN의 MGR과 동일한 값을 가진 사람의 모든목록
select * from emp where MGR=(select MGR from emp where ename='ALLEN');

--professor_조교수의 평균 pay보다 급여가 낮은 사람의 번호,이름,급여를 구하시오
select profno,name,pay from professor where pay<(select avg(pay) from professor where position='조교수');

--student_1학년의 평균키보다 작은학생의 이름,아이디,키를 조회하시오
select name 이름,id 아이디,height from student where height<(select avg(height) from student where grade=1);

--emp_S로 시작하는 사람과 같은 부서사람의 deptno와 이름을 출력하시오
select deptno,ename from emp where deptno IN (select deptno from emp where ename like 'S%');

--문제
--1.emp_ ename 이 ADAMS인 사람의 SAL보다 더 많이 받는사람출력(ename,job,sal)
select ename,job,sal from emp where sal>(select sal from emp where ename='ADAMS');
--2.emp_ 평균SAL 보다 작은 사람의 전체 컬럼 출력
select * from emp where sal<(select avg(sal) from emp);
--3.emp_ ENAME 이 A나 S나 M으로 시작하는 모든 사람 출력(ename,hiredate,sal)
select ename,hiredate,sal from emp where ename LIKE 'S%' or ename LIKE 'A%' or ename LIKE 'M%';
--select ename,hiredate,sal from emp where ename IN ('A%','S%','M%'); --안됨
--4.emp_ SCOTT 의 SAL 과 같은 SAL 을 받는사람을 조회하시오(ename,sal)
select ename,sal from emp where sal=(select sal from emp where ename='SCOTT');
--5.emp_ 사원명의 3번째 글자가 R이거나 A인사람 조회(ename,job)
select ename,job from emp where ename LIKE '__R%' or ename LIKE '__A%';
--6.emp_ || 연산자를 이용하여 다음과 같이 하나의 컬럼으로 출력하시오
--   (예) SCOTT 의 직업은 CLERK 이며 입사년도는 1989년 05월입니다(컬럼명은 자기소개)
select ename || '의 직업은' ||job||'이며 입사년도는 '||to_char(hiredate,'YYYY')||'년' || to_char(hiredate,'MM')||'월 입니다' from emp;
--7.emp_입사일이 81/11/17인 사람을 조회하시오(ename,job,hiredate,sal)
select ename,job,hiredate,sal from emp where hiredate='81/11/17';