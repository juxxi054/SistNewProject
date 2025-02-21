package day2021;

import java.util.Scanner;

public class GuguScan_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       // 원하는 구구단을 입력하시오
	   //5
	   //5단만 출력하시오
	   //반복적으로 출력하다가 0을 누르면 종료되게 
		
		Scanner sc=new Scanner(System.in);
		int gugu;
		
		while(true)
		{
			System.out.println("원하는 구구단을 입력하세요(종료:0)");
			gugu=sc.nextInt();
			
			//종료 조건
			if(gugu==0)
			{
				System.out.println("프로그램 종료");
			}
			// 잘못입력된경우..2~9까지만 입력가능하게
			if(gugu<2 || gugu>9)
			{
				System.out.println("잘못입력했어요 \n2~9단 까지만 입력해주세요");
				continue;
			}
			// 구구단 출력
			System.out.println("["+gugu+"]\n");
				for(int j=1;j<=9;j++)
				{
					System.out.println(gugu+"X"+j+"="+gugu*j);
				}
				System.out.println();
		}
		
	}

}
