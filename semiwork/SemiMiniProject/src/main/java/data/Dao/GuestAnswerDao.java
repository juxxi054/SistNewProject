package data.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import data.Dto.GuestAnswerDto;
import mysql.db.DBConnect;

public class GuestAnswerDao {

DBConnect db=new DBConnect();
	
public void insertGuestAnswer(GuestAnswerDto dto)
{
	Connection conn=db.getConnection();
	PreparedStatement pstmt=null;
	
	String sql="insert into guestanswer values(null,?,?,?,now())";
	
	try {
		pstmt=conn.prepareStatement(sql);
		
		pstmt.setString(1, dto.getNum());
		pstmt.setString(2, dto.getMyid());
		pstmt.setString(3, dto.getContent());
		pstmt.execute();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		db.dbClose(pstmt, conn);
	}
	
}

//댓글목록
public List<GuestAnswerDto> getAllGuestAnswers(String num)
{
	List<GuestAnswerDto> list=new Vector<GuestAnswerDto>();
	
	Connection conn=db.getConnection();
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	String sql="select * from guestanswer where num=? order by idx";
	
	try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, num);
		rs=pstmt.executeQuery();
		
		while(rs.next())
		{
			GuestAnswerDto dto=new GuestAnswerDto();
			
			dto.setIdx(rs.getString("idx"));
			dto.setNum(rs.getString("num"));
			dto.setMyid(rs.getString("myid"));
			dto.setContent(rs.getString("content"));
			dto.setWriteday(rs.getTimestamp("writeday"));
			
			list.add(dto);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		db.dbClose(rs, pstmt, conn);
	}
	
	return list;
}

//삭제
public void deleteGuestAnswer(String idx)
{
	Connection conn=db.getConnection();
	PreparedStatement pstmt=null;
	
	String sql="delete from guestanswer where idx="+idx;
	
	try {
		pstmt=conn.prepareStatement(sql);
		pstmt.execute();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		db.dbClose(pstmt, conn);
	}
	
}
}