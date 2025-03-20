package day0320;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import day0319.DbConnect;

public class MyCludCrud {

	
	DbConnect db=new DbConnect();
	Scanner sc=new Scanner(System.in);
	
	public void insert() 
	{
		System.out.println("회원가입하기");
		System.out.println("회원명은?");
		String cname=sc.nextLine();
		System.out.println("주소");
		String caddress=sc.nextLine();
		System.out.println("직급은?");
		String cposition=sc.nextLine();
		System.out.println("전화번호는?");
		String chp=sc.nextLine();
		System.out.println();
		
		
		
		
		String sql="insert into clubmembers (cno,cname,caddress,cposition,chp,gaipday) values (seq_clubs.nextval,'"+cname+"','"+caddress+"','"+cposition+"','"+chp+"',sysdate)";
		System.out.println(sql);
		
		
		Connection conn=db.getConnection();
		Statement stmt=null;
		
		try {
			stmt=conn.createStatement();
			stmt.execute(sql); 
			
			System.out.println("회원등록 됨");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(stmt, conn);
		}
			
	}
		
	
	public void select()
	{
		String sql="select * from clubmembers order by cno";
		 System.out.println("\t\t[전체회원명단]");
			System.out.println();
	        System.out.println("회원번호\t회원명\t주소\t직급\t전화번호\t회비\t가입일");
	        System.out.println("-------------------------------------------------------");
	        
	        Connection conn=db.getConnection();
			Statement stmt=null;
			ResultSet rs=null;
			
			try {
				stmt=conn.createStatement();
				rs=stmt.executeQuery(sql);
				
				while(rs.next())
				{
					System.out.println(rs.getInt("cno")+"\t"
							+rs.getString("cname")+"\t"
							+rs.getString("caddress")+"\t"
							+rs.getString("cposition")+"\t"
							+rs.getString("chp")+"\t"
							+rs.getString("cfee")+"\t"
							+rs.getDate("gaipday"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				db.dbClose(rs, stmt, conn);
			}
			
		}
	
	public void update()
	{
		System.out.println("수정할 회원번호는?");
		int cno=Integer.parseInt(sc.nextLine());
		System.out.println("수정할 회원명은?");
		String cname=sc.nextLine();
		System.out.println("수정할 주소는?");
		String caddress=sc.nextLine();
		System.out.println("수정할 직급은?");
		String  cposition=sc.nextLine();
		System.out.println("수정할 전화번호는?");
		String chp=sc.nextLine();
		System.out.println("수정할 회비는?");
		int cfee=Integer.parseInt(sc.nextLine());
		
		String sql="update clubmembers set cname='"+cname+"',caddress='"+caddress+"',cposition='"+cposition+"',chp='"+chp+"',cfee="+cfee+" where cno="+cno;
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
		
	
	public void delete()
	{
		System.out.println("삭제할 회원번호를 입력해 주세요");
		int cno=Integer.parseInt(sc.nextLine());
		
		String sql="delete from clubmembers where cno="+cno;
		
		Connection conn=db.getConnection();
		Statement stmt=null;
		
		try {
			stmt=conn.createStatement();
			
			int a=stmt.executeUpdate(sql); 
			
			if(a==0)
				System.out.println(cno+"번 시퀀스는 사원명단에 없는 번호입니다");
			else
				System.out.println(cno+"번 시퀀스가 삭제되었습니다");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(stmt, conn);
		}
		
		
		
	}
	
	public void process()
	{
		MyCludCrud club=new MyCludCrud();
		
		while(true)
		{
			System.out.println("*** MyClub DB 연습 ***");
			System.out.println("**1.회원가입  2.전체회원 출력   3.회원정보 수정  4.회원 삭제  9.종료");
			
			int n=Integer.parseInt(sc.nextLine());
			
			if(n==1)
				club.insert();
			else if(n==9)
			{
				System.out.println("종료합니다");
				break;
			}
			else if(n==2)
				club.select();
			else if(n==3)
				club.update();
			else if(n==4)
				club.delete();
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		MyCludCrud club=new MyCludCrud();
		club.process();
		}
	}
	



