package day2021;

import java.util.Scanner;

public class StringTest_03 {

	public static void main(String[] args) {
		// equals,startWith,endWith 사용
		//김씨가 몇명인지
		
		Scanner sc=new Scanner(System.in);
		
		String name;
		int cnt=0;
		
		while(true)
		{
			System.out.println("이름입력(종료=끝)");
			name=sc.nextLine();
			
			//break
			if(name.equals("끝"))
				break;
			
			//조건
			if(name.startsWith("김"))
				cnt++;
			
		}
         System.out.println("김씨성을 가진 사람은 총"+cnt+"명 입니다");
	}

}
