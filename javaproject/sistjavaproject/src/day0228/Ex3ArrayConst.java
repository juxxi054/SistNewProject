package day0228;

class Myshop{
	
	private String sangName;
	private int su;
	private int dan;
	
	//생성자 인자 3개
	
	public Myshop(String name,int su,int dan) {
	    this. sangName=name;
	    this.su=su;
	    this.dan=dan;
	} 
	    public void writeSangpum() {
	        System.out.println("상품명: " + sangName);
	        System.out.println("수량: " + su);
	        System.out.println("단가: " + dan);
	        System.out.println("총액: " + (su * dan));
	  
	    }
	}
	public class Ex3ArrayConst {	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Myshop[] ms= {
			new Myshop("사과", 100, 4000),
			new Myshop("오렌지", 200, 1500),
			new Myshop("바나나", 150, 3000)
		};
		System.out.println("for문 출력");
		for(int i=0;i<ms.length;i++)
		{
			//Myshop s=ms[i];
			//s.waiteSangpum();
	            ms[i].writeSangpum();
	            System.out.println("------------");
			
		}
		
		System.out.println("for~each문 출력");
		
		for(Myshop m:ms)
		{
			m.writeSangpum();
			System.out.println("------------");
		}
		
	}

}



