package day2021;

import java.util.Scanner;

public class WhileScaSum_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
		 Scanner sc=new Scanner(System.in);
		 int su=0;
		 int score=0;
		 int sum=0;
		 double avg=0;
		 
		 while(true)
		 {
			 System.out.println("점수를 입력하세요");
	    	   score=sc.nextInt();
			
	    	   // 종료
	    	    if(score==00)
				break;
	    	    
	    	  if(score<0 || score>100)
	    	  {
	    		
			}
	    	  su++;
	    	  sum+=score;
		}
		avg=(double)sum/su;
		System.out.println("============");
		System.out.println("총갯수:"+su);
		System.out.println("총점:"+sum);
		System.out.printf("평균: %.2f점",avg);
		
	}

}



