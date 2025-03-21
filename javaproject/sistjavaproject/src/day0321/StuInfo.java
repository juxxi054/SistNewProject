package day0321;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import day0319.DbConnect;

public class StuInfo {

	DbConnect db=new DbConnect();
	Scanner sc=new Scanner(System.in);

	public void insertStuInfo()
	{
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;


		System.out.println("학생명?");
		String name=sc.nextLine();
		System.out.println("학생 주소?");
		String addr=sc.nextLine();
		System.out.println("학생 혈액형?");
		String blood=sc.nextLine();
		System.out.println("학생 휴대폰번호?");
		String hp=sc.nextLine();
		System.out.println("몇학년?");
		int grade=Integer.parseInt(sc.nextLine());
		System.out.println("학생 나이?");
		int age=Integer.parseInt(sc.nextLine());
		System.out.println("학생 생년월일?");
		String birth=sc.nextLine();

		//PreparedStatement 객체는 미완의 sql문을 작성할수있다
		//변수를 ?로 표시후 나중에 바인딩시켜준다
		String sql="insert into stuinfo values(seq_clubs.nextval,?,?,?,?,?,?,?,sysdate)";

		try {
			pstmt=conn.prepareStatement(sql);

			//?순서대로 바인딩후 업데이트
			pstmt.setString(1, name);
			pstmt.setString(2, addr);
			pstmt.setString(3, blood);
			pstmt.setString(4, hp);
			pstmt.setInt(5, grade);
			pstmt.setInt(6, age);
			pstmt.setString(7, birth);

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
	public void selectStuInfo()
	{
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		String sql="select * from stuinfo order by num";

		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();

			System.out.println("학번\t학생명\t학생주소\t\t혈액형\t핸드폰\t\t학년\t나이\t생년월일\t작성일");
			System.out.println("==========================================================================================");

			while(rs.next())
			{
				System.out.println(rs.getInt("num")+"\t"
						+rs.getString("stu_name")+"\t"
						+rs.getString("stu_addr")+"\t"
						+rs.getString("stu_blood")+"\t"
						+rs.getString("stu_hp")+"\t"
						+rs.getInt("stu_grade")+"\t"
						+rs.getInt("stu_age")+"\t"
						+rs.getString("birth")+"\t"
						+rs.getDate("writeday"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
	}
	public void deleteStuInfo()
	{
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		
		System.out.println("삭제할 학번은?");
		int num=Integer.parseInt(sc.nextLine());
		
		String sql="delete from stuinfo where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//바인딩
			pstmt.setInt(1, num);
			
			int n=pstmt.executeUpdate();
			
			if(n==1)
				System.out.println("삭제성공!!!");
			else
				System.out.println("삭제실패!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	public int isOneStuInfo(int num)
	{
		int a=0;

		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from stuinfo where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			
			//if_1개만 조회할경우는 if
			if(rs.next()) //데이타가 있는경우
				a=1;
			else //데이타가 없는경우
				a=0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		
		return a;
	}
	public void updateStuInfo()
	{
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		
		System.out.println("수정할 시퀀스 번호는?");
		int num=Integer.parseInt(sc.nextLine());
		
		//여기에서 isOneData를 호출해서 그번호가 존재하는지 확인
		if(this.isOneStuInfo(num)==0)
		{
			System.out.println("해당번호는 존재하지않습니다");
			return;  //메서드 종료
		}
		
		System.out.println("수정할 학생명?");
		String name=sc.nextLine();
		System.out.println("수정할 학생 주소?");
		String addr=sc.nextLine();
		System.out.println("수정할 학생 혈액형?");
		String blood=sc.nextLine();
		System.out.println("수정할 학생 휴대폰번호?");
		String hp=sc.nextLine();
		System.out.println("수정할 몇학년?");
		int grade=Integer.parseInt(sc.nextLine());
		System.out.println("수정할 학생 나이?");
		int age=Integer.parseInt(sc.nextLine());
		System.out.println("수정할 학생 생년월일?");
		String birth=sc.nextLine();
		
		String sql="update stuinfo set stu_name=?,stu_addr=?,stu_blood=?,stu_hp=?,stu_grade=?,stu_age=?,birth=? where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//?8개 순서대로 바인딩
			pstmt.setString(1, name);
			pstmt.setString(2, addr);
			pstmt.setString(3, blood);
			pstmt.setString(4, hp);
			pstmt.setInt(5, grade);
			pstmt.setInt(6, age);
			pstmt.setString(7, birth);
			pstmt.setInt(8, num);
			
			//업데이트
			int n=pstmt.executeUpdate();
			
			if(n==1)
				System.out.println("상품수정 성공!!");
			else
				System.out.println("상품수정 실패!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	public void searchStuInfo()
	{
		System.out.println("학생이름 검색(성을 검색시 조회)");
		String firstname=sc.nextLine();
		
		String sql="select * from stuinfo where stu_name like ?";
		
		System.out.println("학번\t학생명\t학생주소\t\t혈액형\t핸드폰\t\t학년\t나이\t생년월일\t작성일");
		System.out.println("==========================================================================================");
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//바인딩
			pstmt.setString(1, firstname+"%");
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				System.out.println(rs.getInt("num")+"\t"
						+rs.getString("stu_name")+"\t"
						+rs.getString("stu_addr")+"\t"
						+rs.getString("stu_blood")+"\t"
						+rs.getString("stu_hp")+"\t"
						+rs.getInt("stu_grade")+"\t"
						+rs.getInt("stu_age")+"\t"
						+rs.getString("birth")+"\t"
						+rs.getDate("writeday"));
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

		StuInfo stu=new StuInfo();
		Scanner sc=new Scanner(System.in);
		int n;

		while(true)
		{
			System.out.println("**학생정보 조회**");
			System.out.println("1.학생정보입력  2.학생정보출력   3.학생정보삭제   4.학생정보수정 5.학생검색(성)  9.종료");
			n=Integer.parseInt(sc.nextLine());

			if(n==1)
				stu.insertStuInfo();
			else if(n==9)
			{
				System.out.println("프로그램종료");
				break;
			}else if(n==4)
				stu.updateStuInfo();
			else if(n==2)
				stu.selectStuInfo();
			else if(n==3)
				stu.deleteStuInfo();
			else if(n==5)
				stu.searchStuInfo();


		}

	}

}