package day2021;

import java.util.Scanner;

public class While10_1 {

	/*
	 * 점수(1~100)입력 받다가 0입력시 빠져나온후 총갯수와 총점 평균 구하기
	 * 
	 * ex)
	 * 77
	 * 88
	 * -10
	 *   다시 입력 바람
	 *   99
	 *   110
	 *   다시 입력 바람
	 *   ================
	 *   총갯수:3
	 *   총점:**
	 *   평균:**,**
	 */  
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		 int su=0;
		 String score;
		 int sum=0;
		 double avg=0;
		 
		 while(true)
		 {
			 System.out.println("점수를 입력하세요");
	    	   score=sc.nextLine();
			
	    	   // 입력한 문자의 첫글자가 q나Q면 반복문 빠져나가기 
	    	  if(score.charAt(0)=='q' || score.charAt(0)=='Q')
	    	  break;
	    	  
	    	  su++;
	    	  sum+=Integer.parseInt(score); //정수로 변환후 합계수 더하기
		}
		avg=(double)sum/su;
		System.out.println("============");
		System.out.println("총갯수:"+su);
		System.out.println("총점:"+sum);
		System.out.printf("평균: %.2f점",avg);
	}
	 
	
}


