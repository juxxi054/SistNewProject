package Car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {

	static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	
	//오라클 계정 연결 메서드
	public Connection getConnection() {
		
		Connection cn = null;
		
		try {
			cn = DriverManager.getConnection(URL, "dydgml428", "a1234");
			
		} catch (SQLException e) {
			System.out.println("오라클 연결 실패");
		}
		
		return cn;
	}
	
	//오라클 계정 닫는 메서드 총4개
	public void dbClose(ResultSet rs , Statement st, Connection cn) { //select , insert,create,update
		try {
			if(rs!=null)rs.close();
			if(st!=null)st.close();
			if(cn!=null)cn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public void dbClose(Statement st, Connection cn) { //insert,create, update
		try {
			if(st!=null)st.close();
			if(cn!=null)cn.close();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	public void dbClose(ResultSet rs , PreparedStatement pst, Connection cn) { // insert,update, select, create
		try {
			if(rs!=null)rs.close();
			if(pst!=null)pst.close();
			if(cn!=null)cn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public void dbClose(PreparedStatement pst, Connection cn) { // insert, create , update
		try {
			if(pst!=null)pst.close();
			if(cn!=null)cn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
}
