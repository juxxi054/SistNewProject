package day0321;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.annotation.processing.SupportedSourceVersion;

import day0319.DbConnect;

public class ShopTest {
	DbConnect db=new DbConnect();
	Scanner sc=new Scanner(System.in);
	
	
	public void insertSangpum()
	{
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		
		
		System.out.println("타입(음료 or 과자)?");
		String type=sc.nextLine();
		System.out.println("상품명?");
		String sname=sc.nextLine();
		System.out.println("상품 수?");
		int su=Integer.parseInt(sc.nextLine());
		System.out.println("단가?");
		int dan=Integer.parseInt(sc.nextLine());
		
		
		//preparedstatement 객체는 미완의 sql 작성할수있다
		
		
		String sql="insert into sales values(seq_clubs.nextval,?,?,?,?,sysdate)";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//?순서대로 바인딩후 업데이트
			pstmt.setString(1,type);
			pstmt.setString(2,sname);
			pstmt.setInt(3, su);
			pstmt.setInt(4, dan);
			
			int n=pstmt.executeUpdate();

			if(n==1)
				System.out.println("인서트 성공");
			else
				System.out.println("인서트 실패");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	
	public void selectSangpum()
	{
		
		
	       
	        Connection conn=db.getConnection();
	        PreparedStatement pstmt=null;
	        ResultSet rs=null;
	        
	        String sql="select * from sales order by num asc";
	        
	        try {
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				System.out.println("시퀀스\t상품명\t상품수\t단가\t입고날짜");	
				 System.out.println("-------------------------------------------------------");
				 
				while(rs.next())
				{
				 System.out.println(rs.getInt("num")+"\t"
				 +rs.getString("type")+"\t"
				 +rs.getString("sangpum")+"\t"
				 +rs.getInt("su")+"\t"
				 +rs.getInt("dan")+"\t"
				 +rs.getDate("ipgoday"));
				}
			        
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	//시퀀스 선택해서 삭제하도록
	public void deleteSangpum()
	
	{
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		
		System.out.println("삭제할 시퀀스는?");
	    int num=Integer.parseInt(sc.nextLine());
	    
	    String sql="delete from sales where num=?";
	    
	    
	    try {
			pstmt=conn.prepareStatement(sql);
			
			//바인딩
			pstmt.setInt(1, num);
			
			int n=pstmt.executeUpdate();
			
			if(n==1)
				System.out.println("삭제성공");
			else 
				System.out.println("삭제 실패");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally { db.dbClose(pstmt, conn);
	}
	}

	//수정..메서드 2개 1.num을 인자로 받아서 있는지 없는지 반환 2.수정
	public boolean isOneData(int num)
	{
		boolean b=false;
		
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from sales where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			
			//if_1개만 조회할경우는 if
			if(rs.next())  //데이터가 있는경우
				b=true;
			else //데이터가 없는경우
				b=false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs,pstmt, conn);
		}
		return b;
	}
		
	
	//수정
	public void updateSangpum()
	{
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		
		System.out.println("수정할 시퀀스 번호는?");
		int num=Integer.parseInt(sc.nextLine());
		
		//여기에서 isOneData를 호출해서 그번호가 존재하는지 확인
		if(!this.isOneData(num))
		{
			System.out.println("해당번호는 존재하지 않습니다");
			return;
		}
		System.out.println("수정할 타입은?");
		int type=Integer.parseInt(sc.nextLine());
		System.out.println("수정할 상품명은?");
		String name=sc.nextLine();
		System.out.println("수량?");
		int su=Integer.parseInt(sc.nextLine());
		System.out.println("단가는?");
		int dan=Integer.parseInt(sc.nextLine());
		
		String sql="update sales set type=?,sangpum=?,su=?,dan=? where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//5개 순서대로 바인딩
			pstmt.setString(1,type==1?"음료":"과자");
			pstmt.setString(2,name);
			pstmt.setInt(3, su);
			pstmt.setInt(4,su);
			
			//업데이트
			int n=pstmt.executeUpdate();
			
			if(n==1)
				System.out.println("상품수정 성공!!");
			else
				System.out.println("상품수정 실패!!!");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	//상품명의 일부를 검색해서 찾기(상품명이 어디든 포함되면...)
		public void searchSangpum()
		{
			System.out.println("상품명 검색(일부)");
			String sang=sc.nextLine();
			
			String sql="select num,sangpum,su,dan from sales where sangpum like ?";
			
			System.out.println("시퀀스\t상품명\t수량\t단가");
			
			Connection conn=db.getConnection();
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			
			try {
				pstmt=conn.prepareStatement(sql);
				
				//바인딩
				pstmt.setString(1, "%"+sang+"%");
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					System.out.println(rs.getInt("num")+"\t"
							+rs.getString("sangpum")+"\t"
							+rs.getInt("su")+"\t"
							+rs.getInt("dan"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				db.dbClose(rs, pstmt, conn);
			}
		}
		
	
	
		
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ShopTest sh=new ShopTest();
		Scanner sc=new Scanner(System.in);
		int n;
		
		
			
			
			while(true)
			{
				System.out.println("**상품입고**");
				System.out.println("1.상품추가  2.상품삭제   3.상품수정   4.재고출력 5.상품검색  9.종료");
				n=Integer.parseInt(sc.nextLine());
				
			
			if(n==1)
				sh.insertSangpum();
			else if(n==9)
			{
				System.out.println("프로그램종료");
				break;
			}else if (n==4)
				sh.selectSangpum();
			
			else if (n==2)
				sh.deleteSangpum();
			
			else if (n==3)
				sh.updateSangpum();
			
			else if (n==5)
				sh.searchSangpum();
		}
		 
	}
	}

