package day0219;

import java.util.Scanner;

public class QuizeOper_04 {

	public static void main(String[] args) {
		/* 현재 지갑에 있는 돈을 입력하여 만원,천원,백원,일원 갯수를 출력하시오
         *  금액을 입력하시오
         * 752543
         * 만원: 75
         * 천원: 2
         * 백원:5
         * 십원:4
         * 일원:3 
		*/
		
		 Scanner sc=new Scanner(System.in);
		 int money;
		 System.out.println("금액을 입력하시오");
		 money=sc.nextInt();
		 
		 System.out.println("만원:"+(money/10000));
		 System.out.println("천원:"+(money%10000/1000));
		 System.out.println("백원:"+(money%1000/100));
		 System.out.println("십원:"+(money%100/10));
		 System.out.println("일원:"+(money%10));
			

	}

}
