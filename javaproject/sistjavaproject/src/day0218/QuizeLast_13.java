package day0218;

import java.util.Calendar;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class QuizeLast_13 {

	public static void main(String[] args) {
		
		/*
		 * 키보드를 입력하고 출력을 다음과 같이 해보세요
		 * 변수는 마음대로 어울리게 줄것!!!
		 * 
		 * 당신의 이름은?
		 * 김사랑
		 * 당신의 출생년도는?
		 * 1997
		 * 당신의 직업은?
		 * 연예인
		 * 
		 * ============
		 * 김사랑님은 1997년생이며 28세입니다. 직업은 연예인입니다*/
		
		//import 
		Scanner sc=new Scanner(System.in);
		Calendar  cal=Calendar.getInstance();
		
		
		//변수선언
		 String name,job;
		 int culYear=cal.get(cal.YEAR);
		 int BirthYear,myAge;
		 
		 
		 // 입력할멘트
		 
		 System.out.println("당신의 이름은?");
		 name=sc.nextLine();
		System.out.println("당신의 출생년도는?");
		  BirthYear=Integer.parseInt(sc.nextLine());
		  System.out.println("당신의 직업은?===>");
		  job=sc.nextLine();
		  
		  
		  //나이계산
		  myAge=culYear-BirthYear;
		  
		  //출력
		  System.out.println(name+"은");
		  System.out.println(BirthYear+"년생이며");
		  System.out.println((culYear-BirthYear)+"세 입니다");
		  System.out.println("직업은"+job+"입니다");
		  
		  
	}

}
