package day0319;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.annotation.processing.SupportedSourceVersion;
import javax.print.DocFlavor.STRING;

public class connectTest {
	
	  static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	
	public void connectINFO()
	{
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String sql="select * from INFO order by num"; //오름차순 정렬
		
		try {
			conn=DriverManager.getConnection(URL,"juxxi","a1234");
			System.out.println("오라클 서버 연결성공");
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				//db로부터 데이터 가져오기
				int num=rs.getInt("num"); //1열로 가능
				String name=rs.getString("name");
				String job=rs.getString("job");
				String gender=rs.getString("gender");
				int age=rs.getInt("age");
				
				
				
				System.out.println(num+"\t"+name+"\t"+job+"\t"+gender+"\t"+age);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("오라클 연결실패");
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//음식명의 오름차순 정렬
	public void connectFOODMENU() {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String sql="select * from FOODMENU order by fno";
		
		try {
			conn=DriverManager.getConnection(URL,"juxxi","a1234");
			
System.out.println("오라클 연결성공");

 stmt=conn.createStatement();
 rs=stmt.executeQuery(sql);
 
 System.out.println("**배달메뉴**");
 System.out.println("번호\t음식이름\t가격\t가게명\t위치");
 System.out.println("---------------------------");
 while(rs.next())
 {
	 int fno=rs.getInt(1); //1열로
	 String food_name=rs.getNString("food_name");
	 int price=rs.getInt("price");
	 String shop_name=rs.getString("shop_name");
	 String loc=rs.getString("loc");
	 
	 System.out.println(fno+"\t"+food_name+"\t"+price+"\t"+shop_name+"\t"+loc);
	 
 }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("오라클 연결실패");
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
		
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         // connectTest ct=new connectTest();
                //ct.connectINFO();  
                
                connectTest ct=new connectTest();
                ct.connectFOODMENU();
	}
	
	

}
