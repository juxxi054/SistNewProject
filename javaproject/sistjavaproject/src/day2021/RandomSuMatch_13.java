package day2021;

import java.util.Scanner;

public class RandomSuMatch_13 {

	public static void main(String[] args) {
		// 숫자를 입력해서 랜덤수 맞추기
		
		Scanner sc=new Scanner(System.in);
		int rnd=(int)(Math.random()*10)+1;
		int su; //입력할수
		
		while(true)
		{
			System.out.println("랜덤수를 맞추세요");
			su=sc.nextInt();
			
			if(su>rnd)
				System.out.println(su+"보다 작습니다");
			else if (su<rnd)
				System.out.println(su+"보다 큽니다");
			else 
			{
				System.out.println("맞았습니다 정답은"+rnd+"입니다");
			break;
		}
		System.out.println("숫자 맞추기 종료");

	}

	}
}
