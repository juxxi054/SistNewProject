package day2020;

import java.util.Scanner;

public class Quiz0220 {
	
	public static void quiz1() {
		//1부터 100까지의 숫자중 짝수합과 홀수합을 나누어 출력하시오
		//짝수의 합:***
		//홀수의 합:***
		int sum=0;
		int tot=0;
		for(int i=1;i<=100;i++)
		{
			if(i%2==1)
				continue;
			sum+=i;
		}
			for(int a=1;a<=100;a++)
			{
				if(a%2==0)
					continue;
				tot+=a;	
		}
		System.out.println("짝수의 합: "+sum);
		System.out.println("홀수의 합: "+tot);
		
	}

	
public static void quiz2() {
		//합계를 더할 숫자를 입력하시오
		//숫자를 입력하면 1부터 입력한 숫자까지의 합계를 구해서 출력하시오
		
		//1부터** 까지의 합은 ***입니다
	
	
		Scanner sc=new Scanner(System.in);
		 int d=0;
		 int tot;
		 System.out.println("숫자를 입력하세요");
		 tot=sc.nextInt();
		 
		 for(int i=1;i<=tot;i++)
			 d+=i; 
			 
		 System.out.println("1부터"+tot+"까지의 합은"+d+"입니다");
}

	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//quiz1();
		quiz2();
		
	}

}
