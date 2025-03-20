package day0320;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import day0319.DbConnect;

public class AboutSawon {

	DbConnect db=new DbConnect();
	Scanner sc=new Scanner(System.in);
	
	public void insertSawon()
	{
		System.out.println("**사원추가하기**");
		System.out.println("사원명?");
		String name=sc.nextLine();
		System.out.println("성별(남자/여자)?");
		String gender=sc.nextLine();
		System.out.println("부서?");
		String buseo=sc.nextLine();
		System.out.println("월급여는?");
		int pay=Integer.parseInt(sc.nextLine());
		
		String sql="insert into sawon values (seq_sawon.nextval,'"+name+"','"+gender+"','"+buseo+"',"+pay+")";
		System.out.println(sql);
		
		Connection conn=db.getConnection();
		Statement stmt=null;
		
		try {
			stmt=conn.createStatement();
			stmt.execute(sql); //sql문 실행
			
			System.out.println("DB에 사원이 추가됨!!!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(stmt, conn);
		}
		
	}
	
	public void selectSawon()
	{
		String sql="select num,name,gender,buseo,to_char(pay,'L999,999,999') pay from sawon order by num";
		
		System.out.println("\t\t[전체사원명단]");
		System.out.println();
		System.out.println("시퀀스\t사원명\t성별\t부서\t급여");
		System.out.println("-------------------------------------------------------");
		
		Connection conn=db.getConnection();
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			while(rs.next())
			{
				System.out.println(rs.getInt("num")+"\t"
						+rs.getString("name")+"\t"
						+rs.getString("gender")+"\t"
						+rs.getString("buseo")+"\t"
						+rs.getString("pay"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, stmt, conn);
		}
		
	}
	
	//삭제..시퀀스 입력하면 삭제
	public void deleteSawon()
	{
		System.out.println("삭제할 시퀀스를 입력해 주세요");
		int num=Integer.parseInt(sc.nextLine());
		
		String sql="delete from sawon where num="+num;
		
		Connection conn=db.getConnection();
		Statement stmt=null;
		
		try {
			stmt=conn.createStatement();
			//stmt.execute(sql);
			int a=stmt.executeUpdate(sql); //시퀀스가 없으면 0을 반환
			
			if(a==0)
				System.out.println(num+"번 시퀀스는 사원명단에 없는 번호입니다");
			else
				System.out.println(num+"번 시퀀스가 삭제되었습니다");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(stmt, conn);
		}
		
		
		
	}
	
	//수정..시퀀스입력후 이름,부서,급여 변경하도록
	public void updateSawon()
	{
		System.out.println("수정할 사원번호는?");
		int num=Integer.parseInt(sc.nextLine());
		System.out.println("수정할 사원명은?");
		String name=sc.nextLine();
		System.out.println("수정할 부서는?");
		String buseo=sc.nextLine();
		System.out.println("수정할 급여는?");
		int pay=Integer.parseInt(sc.nextLine());
		
		String sql="update sawon set name='"+name+"',buseo='"+buseo+"',pay="+pay+" where num="+num;
		System.out.println(sql);
		
		Connection conn=db.getConnection();
		Statement stmt=null;
		
		try {
			stmt=conn.createStatement();
			int a=stmt.executeUpdate(sql);
			
			if(a==0)
				System.out.println("수정할 데이타가 존재하지 않음");
			else
				System.out.println("수정되었습니다");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(stmt, conn);
		}
		
		
	}
	
	public void searchSawon()
	{
		//성을 검색하면 그성을 가진사람들이 조회되도록 한다
		System.out.println("사원의 성을 검색해 주세요(일부검색)");
		String firstName=sc.nextLine();
		
String sql="select num,name,gender,buseo,to_char(pay,'L999,999,999') pay from sawon "
		+ "where name like '"+firstName+"%'";
		
		System.out.println("\t\t[전체사원명단]");
		System.out.println();
		System.out.println("시퀀스\t사원명\t성별\t부서\t급여");
		System.out.println("-------------------------------------------------------");
		
		Connection conn=db.getConnection();
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			while(rs.next())
			{
				System.out.println(rs.getInt("num")+"\t"
						+rs.getString("name")+"\t"
						+rs.getString("gender")+"\t"
						+rs.getString("buseo")+"\t"
						+rs.getString("pay"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, stmt, conn);
		}
		
	}
		 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AboutSawon as=new AboutSawon();
		Scanner sc=new Scanner(System.in);
		int n;
		
		while(true)
		{
			System.out.println("***Oracle Sawon 연습***");
			System.out.println("**1.데이타입력  2.데이타 출력   3.데이타수정  4.데이타 삭제 5.검색 9.종료");
			
			n=Integer.parseInt(sc.nextLine());
			
			if(n==1)
				as.insertSawon();
			else if(n==9)
			{
				System.out.println("종료합니다");
				break;
			}else if(n==2)
				as.selectSawon();
			else if(n==4)
				as.deleteSawon();
			else if(n==3)
				as.updateSawon();
			else if(n==5)
				as.searchSawon();
		}
		
	}

}