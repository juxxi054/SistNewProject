package day0219;

import java.util.Scanner;

public class a {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		String name;
		int amount,price,tot;
		int dc=0;
		
		
		System.out.println("입고된 상품명은?");
		name=sc.nextLine();
		System.out.println("수량은?");
		amount=sc.nextInt();
		System.out.println("단가?");
		price=sc.nextInt();
		
		tot=amount*price;
		System.out.println("총금액은"+tot);
		
		if(amount>=5)
		{	
		  dc=tot*9/10;
		System.out.println("dc된 최종금액"+dc+"원");
		
	}

}
}