package day0219;

import java.util.Scanner;

public class Quiz0218_14 {

	public static void main(String[] args) {
		//숫자를 입력하시오
		//4
		//**if문**
		//4는 짝수
		//**삼항연산자**
		//4는짝수
		
		Scanner sc=new Scanner(System.in);
		int num;
		
		System.out.println("숫자를 입력하시오");
		num=sc.nextInt();
		
		if(num%2==1)
			System.out.println(+num+"는 홀수입니다");
		 else
			 System.out.println(+num+"는 짝수입니다");
		
		System.out.println(num+"는"+(num%2==1? "홀수": "짝수"));
		
		//switch 문으로
		
		System.out.println("**switch 문으로");
		
		switch(num%2)
		{
		case 0:
			System.out.println("짝수");
			break;
		case 1:
			System.out.println("홀수");
			break;
		}
		//입고된 상품명은? 아이폰16
				//수량은? 6
				//단가는? 1100000
				//============================
				//아이폰 6개는 총 6600000 입니다
				//(단 5개 이상은 10프로 DC 됩니다)
				//============================
				//dc된 최종금액: 5940000원

		
		String name;
		int amount,price,tot;
		
		
		System.out.println("입고된 상품명은?");
		name=sc.nextLine();
		
		System.out.println("수량은?");
		amount=sc.nextInt();
		System.out.println("단가?");
		price=sc.nextInt();
		System.out.println("총금액은?");
		tot=amount*price;
		
		if(amount>=5)
		  tot=tot/10;
        
		System.out.println("dc된 최종금액은?");
	}

}
