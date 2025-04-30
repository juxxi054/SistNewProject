package booking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import OracleDb.DbConnect;
import gaip.GaipDto;

public class BookingDao {

    DbConnect db = new DbConnect();

    public void insertBooking(BookingDto dto)
    {
  	  Connection conn=db.getConnection();
  	  PreparedStatement pstmt=null;
  	  
  	  String sql="insert into booking values (seq_hello.nextval,?,?,?,?,?,?,?,sysdate)";
  	  
  	  try {
  		pstmt=conn.prepareStatement(sql);
  		//바인딩
  		pstmt.setString(1, dto.getName());
  		pstmt.setString(2, dto.getGender());
  		pstmt.setString(3, dto.getBookday());
  		pstmt.setInt(4, dto.getInwon());
  		pstmt.setString(5, dto.getFoodphoto());
  		pstmt.setString(6, dto.getFoodprice());
  		pstmt.setString(7, dto.getMessage());
  		
  		pstmt.execute();
  	} catch (SQLException e) {
  		// TODO Auto-generated catch block
  		e.printStackTrace();
  	}finally {
  		db.dbClose(pstmt, conn);
  	}
  	  
    }
    
    //전체출력
    public List<BookingDto> getAllBookings()
    {
  	  List<BookingDto> list=new ArrayList<BookingDto>();
  	  
  	  Connection conn=db.getConnection();
  	  PreparedStatement pstmt=null;
  	  ResultSet rs=null;
  	  
  	  String sql="select * from booking order by num asc";
  	  
  	  try {
  		pstmt=conn.prepareStatement(sql);
  		rs=pstmt.executeQuery();
  		
  		while(rs.next())
  		{
  			BookingDto dto=new BookingDto();
  			
  			dto.setNum(rs.getString("num"));
  			dto.setName(rs.getString("name"));
  			dto.setBookday(rs.getString("bookday"));
  			dto.setFoodphoto(rs.getString("foodphoto"));
  			dto.setFoodprice(rs.getString("foodprice"));
  			dto.setGender(rs.getString("gender"));
  			dto.setInwon(rs.getInt("inwon"));
  			dto.setMessage(rs.getString("message"));
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
  //num에 해당하는 dto반환
  		public BookingDto getData(String num)
  	  	{
  	  		BookingDto dto=new BookingDto();
  	  		
  	  		Connection conn=db.getConnection();
  	  		PreparedStatement pstmt=null;
  	  		ResultSet rs=null;
  	  		
  	  		String sql="select * from booking where num=?";
  	  		
  	  		try {
  				pstmt=conn.prepareStatement(sql);
  				pstmt.setString(1, num);
  	  			rs=pstmt.executeQuery();
  	  			
  	  			if(rs.next())
  	  			{
  	  			dto.setNum(rs.getString("num"));
  	  			dto.setName(rs.getString("name"));
  	  			dto.setBookday(rs.getString("bookday"));
  	  			dto.setFoodphoto(rs.getString("foodphoto"));
  	  			dto.setFoodprice(rs.getString("foodprice"));
  	  			dto.setGender(rs.getString("gender"));
  	  			dto.setInwon(rs.getInt("inwon"));
  	  			dto.setMessage(rs.getString("message"));
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
  }