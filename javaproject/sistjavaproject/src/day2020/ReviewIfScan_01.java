package day2020;

import java.util.Scanner;

public class ReviewIfScan_01 {

public static void main(String[] args) {
		/*
		 *이름을 입력하세요
		 *홍길동
		 *정보처리기사 3과목의 점수를 입력하세요
		 *88 77 39
		 *=============
		 *3과목의 평균:**.**점
		 *=============
		 ***합격조건:평균60점이상이고 각과목이 모두 40점이상이면 합격**
		 *=====================
		 *홍길동님은 불합격입니다
		 */ 
	
		 Scanner sc=new Scanner(System.in);
		 String name;
		 int a,b,c;
		
		 System.out.println("이름을 입력하시오");
		 name=sc.nextLine();
		 System.out.println("정보처리기사 3과목의 점수를 입력하세요");
		 a=sc.nextInt();
		 b=sc.nextInt();
		 c=sc.nextInt();
		 
		 double avg=(a+b+c)/3.0;
	     
	     System.out.printf("평균:%.2f\n점",avg);
	     
	     if(a>=40&&b>=40&&c>=40&&avg>=60)
	       System.out.println(name+"님은 합격입니다");
	       else
	    	 System.out.println(name+"님은 불합격입니다");
	    	 
	}
	}

