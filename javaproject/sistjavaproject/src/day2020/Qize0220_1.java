package day2020;

import java.util.Scanner;

public class Qize0220_1 {

	public static void main() {
		// TODO Auto-generated method stub
		int sum=0;
		int tot=0;
		for(int i=1;i<=100;i++)
		{
			if(i%2==1)
				sum+=i;
			else
			tot+=i;
	}
		System.out.println("짝수의 합: "+sum);
		System.out.println("홀수의 합: "+tot);
	}
	public static void main1() {
	Scanner sc=new Scanner(System.in);
	 int d=0;
	 int tot;
	 System.out.println("숫자를 입력하세요");
	 tot=sc.nextInt();
	 
	 for(int i=1;i<=tot;i++)
		 d+=i; 
		 
	 System.out.println("1부터"+tot+"까지의 합은"+d+"입니다");
}
}