package day0219;

import java.util.Scanner;

public class IfTest_11 {

	public static void main(String[] args) {
		/*
		 * 3개의 수를 입력하시오 (A && B A B 모두 true여야 true)
		 * 5
		 * 15
		 * 8
		 * ***if문***
		 * max=15
		 * ***삼항연산자***
		 * max=15
		 */
		
		Scanner sc=new Scanner(System.in);
		int A,B,C,max;
		
		System.out.println("세수를 입력하세요");
		
		A=sc.nextInt();
		B=sc.nextInt();
		C=sc.nextInt();
		
		
		
		System.out.println("***if문***");
		if(A>B && B>C)
			max=A;
		else if (B>A && B>C)
			max=B;
		else max=C;
		System.out.println("max="+max);
			
		System.out.println("***삼항연산자***");
		max=A>B&&B>C?B:A>C&&B>C?B:C;
		System.out.println("max="+max);
		

	}

}
