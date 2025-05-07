package mymall;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import mysql.db.DBConnect;

public class MymallDao {

	DBConnect db = new DBConnect();
	   
	   //전체데이터 조회
	   
	   public List<MymallDto> getAllSangPums(){
	      List<MymallDto> list = new Vector<MymallDto>();
	      
	      Connection cn = db.getConnection();
	      PreparedStatement pst = null;
	      ResultSet rs = null;
	      
	      String sql = "select * from mymall order by num asc";

	      
	      try {
	         pst = cn.prepareStatement(sql);
	         rs = pst.executeQuery();
	         
	         while(rs.next()) {
	            MymallDto dto = new MymallDto();
	            
	            dto.setNum(rs.getString("num"));
	            dto.setSanmgpum(rs.getString("sangpum"));
	            dto.setPhoto(rs.getString("photo"));
	            dto.setColor(rs.getString("color"));
	            dto.setPrice(rs.getInt("price"));
	            dto.setIpgoday(rs.getString("ipgoday"));
	            dto.setWriteday(rs.getTimestamp("writeday"));
	            
	            list.add(dto);
	            
	         }
	      } catch (SQLException e) {

	         e.printStackTrace();
	      }finally {
	         db.dbClose(rs, pst, cn);
	      }
	      return list;
	   }
	   
		public MymallDto getData(String num)
	  	{
	  		MymallDto dto=new MymallDto();
	  		
	  		String sql="select * from mymall where num=?";
	  		Connection conn=null;
	  		PreparedStatement pstmt=null;
	  		ResultSet rs=null;
	  		
	  		conn=db.getConnection();
	  	
	  		try {
	  			pstmt=conn.prepareStatement(sql);
	  			//바인딩
	  			pstmt.setString(1, num);
	  			
	  			rs=pstmt.executeQuery();
	  			if(rs.next()) {
	  				dto.setNum(rs.getString("num"));
		            dto.setSanmgpum(rs.getString("sangpum"));
		            dto.setPhoto(rs.getString("photo"));
		            dto.setColor(rs.getString("color"));
		            dto.setPrice(rs.getInt("price"));
		            dto.setIpgoday(rs.getString("ipgoday"));
		            dto.setWriteday(rs.getTimestamp("writeday"));	
	  			}
	  		} catch (SQLException e) {
	  			// TODO Auto-generated catch block
	  			e.printStackTrace();
	  		}finally {
	  			db.dbClose(rs, pstmt, conn);
	  		}
	  		return dto;
	  	}
	  			
	  //수정
		
	 //삭제	
	  			
	  			
	  			
	 //insert
		public void insertMall(MymallDto dto)
		{
			Connection conn=db.getConnection();
			PreparedStatement pstmt=null;
			
			String sql="insert into mymall values(null,?,?,?,?,?,now())";
			
			try {
				pstmt=conn.prepareStatement(sql);
				
				pstmt.setString(1, dto.getSangpum());
				pstmt.setString(2, dto.getPhoto());
				pstmt.setString(3, dto.getColor());
				pstmt.setInt(4, dto.getPrice());
				pstmt.setString(5, dto.getIpgoday());
				
				pstmt.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				db.dbClose(pstmt, conn);
			}
			
		}
		
	}