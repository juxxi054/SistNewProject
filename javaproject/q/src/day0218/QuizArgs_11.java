package day0218;

public class QuizArgs_11 {

	public static void main(String[] args) {
		// 매개변수를 이용하여 (args) 다음과 같이 출력하시오 (snagName,price,amount,totPrice)
		
		/**
		 * 상품명:아이스크림
		 * 수량:42개
		 * 가격:4000원
		 * 총금액;168000원
		 */

		//변수선언
		String sangName=args[0];
		int amount=Integer.parseInt(args[1]);
		int price=Integer.parseInt(args[2]);
		
		//계산
		int totPrice=amount*price;
		//출력
		System.out.println("상품명: "+sangName);
		System.out.println("수량: "+amount+"개");
		System.out.println("가격: "+price+"원");
		System.out.println("총금액: "+totPrice+"원");
	}

}
