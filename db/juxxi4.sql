

--join & foreign 복습


--시퀀스
create SEQUENCE seq_board;


--부모테이블

create table board (bno number(3) CONSTRAINT board_pk_bno PRIMARY key,
writer VARCHAR2(30),subject VARCHAR(50),writeday date);


--게시글 borad에 5개의 데이터 insert 

insert into board VALUES (seq_board.nextval,'오늘도 열심히','안녕하세요',sysdate);
insert into board VALUES (seq_board.nextval,'1댕','오늘가입했어요',sysdate);
insert into board VALUES (seq_board.nextval,'점메추','배고파요',sysdate);
insert into board VALUES (seq_board.nextval,'야미','빵투어',sysdate);
insert into board VALUES (seq_board.nextval,'아담','팝업후기',sysdate);

commit;

--자식테이블 
--부모글 지우면 그글에 달린 댓글은 자동으로 삭제되도록 설정
CREATE TABLE answer (num number(5) CONSTRAINT anser_pk_num PRIMARY key,
bno number(3) CONSTRAINT ansewr_fk_bno REFERENCES board(bno) on DELETE CASCADE,
nickname VARCHAR2(30),content VARCHAR2(100));

--원하는 글번호에 댓글 추가
insert into answer VALUES(seq_board.nextval,2,'대장','반가워요');
insert into answer VALUES(seq_board.nextval,1,'성지니','안녕하세요');
insert into answer VALUES(seq_board.nextval,4,'빵쥐','와우');
insert into answer VALUES(seq_board.nextval,3,'먹투어','샌드위치!');
insert into answer VALUES(seq_board.nextval,5,'루아','사람 ㅎㄷㄷ');
 
commit;

--join으로 출력
--bno(글번호) writer(작성자) subject(제목) nickname(댓글단사람) content(댓글내용) writeday(월글올린날짜)



select b.bno 글번호,b.writer 작성자,b.subject 제목,a.nickname 댓글단사람,a.content 댓글내용,b.writeday 월글올린날짜
from board b, answer a
WHERE b.bno=a.bno;

 select * from board;
 select * from answer;
 
 
 
 
 