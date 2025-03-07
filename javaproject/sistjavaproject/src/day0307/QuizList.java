package day0307;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MyShop{
	
	
	private String sangName;
	private int su;
	private int price;

  
    public String getSangName() {
		return sangName;
	}


	public void setSangName(String sangName) {
		this.sangName = sangName;
	}

	public int getSu() {
		return su;
	}


	public void setSu(int su) {
		this.su = su;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}
    
	
	public int getTotal() {
		return this.su*this.price;
	}
}
	//ArrayList로 생성해서 할것!!
			//MyShop은 디폴트 생성자로 생성할것
			//메인에서 추가를 누르면 입력메서드 호출
			//출력 모양은 번호 입고상품 수량 가격 총금액 


/////////////////////////////

public class QuizList {
	
	List<MyShop> list= new ArrayList<MyShop>();
	
	public void  ipgo() {
		
		 Scanner sc=new Scanner(System.in);	
		 
		 System.out.println("상품명은");
		 String sang=sc.nextLine();
		 System.out.println("가격은");
		 int price=Integer.parseInt(sc.nextLine());
		 System.out.println("입고수량은");
		 int su=Integer.parseInt(sc.nextLine());
		 
		 MyShop my=new MyShop();
		 my.setSangName(sang);
		 my.setSu(su);
		 my.setPrice(price);
		 
		 list.add(my);
		 
		 System.out.println("현재상품입고:"+list.size()+"개");
	}
	
	 public void jego() {
		 
		 System.out.println("상품 재고 현황");
		 System.out.println("------------------");
		 System.out.println("번호\t상품명\t상품가격\t수량\t총액");
		 System.out.println("=============================");
		 
		 for(int i=0;i<list.size();i++)
		 {
			 MyShop s=list.get(i);
			 
			 System.out.println(i+1+"\t"+s.getSangName()+"\t"+s.getPrice()+"\t"+s.getSu()+"\t"+s.getTotal());
				System.out.println("-------------------------------------------------------------");
		 }
		
	}
	
	
		
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	
		QuizList quiz=new QuizList();
		Scanner sc=new Scanner(System.in);
		int n;
		 
		 
		 while(true) {
			 System.out.println("1.상품입고   2.재고현황  3.종료");
			 n=Integer.parseInt(sc.nextLine());
			 
			 if(n==1)
			  quiz.ipgo();
			  else if(n==2)
				  quiz.jego();
			  else if(n==3)
			  {
				  System.out.println("종료");
				  break;
			  }
			 }
}
}
