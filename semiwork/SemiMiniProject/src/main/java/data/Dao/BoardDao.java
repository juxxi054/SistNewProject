package data.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import data.Dto.BoardDto;
import mysql.db.DBConnect;

public class BoardDao {

	
	DBConnect db=new DBConnect();
	
	//num의 max값 구해서 리턴(null일경우 0으로 리턴)
		public int getMaxNum()
		{
			int max=0;
			
			String sql="select ifnull(max(num),0) max from reboard";
			
			Connection conn=db.getConnection();
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			
			try {
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				
				if(rs.next())
					max=rs.getInt(1);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				db.dbClose(rs, pstmt, conn);
			}
			
			
			return max;
		}
		
		
		//데이터 추가시 같은그룹중에서 전달받은 step보다 큰값을 가진 데이타들은 
		//무조건 restep+1 해준다
		public void updateRestep(int regroup,int restep)
		{
			Connection conn=db.getConnection();
			PreparedStatement pstmt=null;
			
			String sql="update reboard set restep=restep+1 where regroup=? and restep>?";
			
			try {
				pstmt=conn.prepareStatement(sql);
				
				pstmt.setInt(1, regroup);
				pstmt.setInt(2, restep);
				
				pstmt.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				db.dbClose(pstmt, conn);
			}
			
		}
		
		//insert: 새글로 추가할지 답글로 추가할지 
		//판단: dto의 num이 null이면 새글로 아니면 답글로 insert할것
		public void insertReboard(BoardDto dto)
		{
			String num=dto.getNum();
			int regroup=dto.getRegroup();
			int restep=dto.getRestep();
			int relevel=dto.getRelevel();
			
			String sql="insert into reboard(writer,subject,content,pass,regroup,restep,relevel,writeday)"
					+ " values (?,?,?,?,?,?,?,now())";
			
			if(num==null) {
				//새글을 의미
				regroup=this.getMaxNum()+1;
				restep=0;
				relevel=0;
			}else {
				//답글을 의미
				//같은 그룹중에서 restep이 전달받은 값보다 큰경우 무조건 1씩 증가
				this.updateRestep(regroup, restep);
				//그리고 전달받은 level,step 1씩증가
				relevel+=1;
				restep++;
			}
			
			Connection conn=db.getConnection();
			PreparedStatement pstmt=null;
			
			try {
				pstmt=conn.prepareStatement(sql);
				
				//바인딩 
				pstmt.setString(1, dto.getWriter());
				pstmt.setString(2, dto.getSubject());
				pstmt.setString(3, dto.getContent());
				pstmt.setString(4, dto.getPass());
				
				pstmt.setInt(5, regroup);
				pstmt.setInt(6, restep);
				pstmt.setInt(7, relevel);
				
				pstmt.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				db.dbClose(pstmt, conn);
			}
			
		}
		
	}