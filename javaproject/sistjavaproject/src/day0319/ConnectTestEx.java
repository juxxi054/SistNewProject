package day0319;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectTestEx {
	
	  static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	  
	  
	//shop+cart
		//카트에담긴일련번호 idx,상품명,색상,갯수,구입한날짜
	
	public void shopCart() {
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
String sql="select idx,sangpum,color,cnt,guipday from cart1 c,shop s where c.num=s.num";
		
		try {
			conn=DriverManager.getConnection(URL, "juxxi", "a1234");
			System.out.println("성공");
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			System.out.println("장바구니번호\t상품명\t색상\t갯수\t구입날짜");
			System.out.println("===========================================");
			
			while(rs.next())
			{
				System.out.println(rs.getInt("idx")+"\t"+rs.getString("sangpum")
				+"\t"+rs.getString("color")+"\t"+rs.getInt("cnt")+"\t"
						+rs.getDate("guipday"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("실패");
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConnectTestEx ex3=new ConnectTestEx();
			ex3.shopCart();
	}

}