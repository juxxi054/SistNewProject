package day0227;


class MyDate{
	
	
	private int year;
	private int month;
	private int day;
	
	//명시적 생성자 (인자3개)
	 public MyDate(int y,int m,int d) {
	  
		 this.year=y;
		 month=m;
		 day=d;
	
}
	//getter 메서드
 
	 public int getYear()
	 {
		 return year;
	 }
	 public int getMonth()
	 {
		 return month;
	 }
	 public int getDay()
	 {
		 return day;
	 }
}

public class Ex6ObjectTest {

	public static void main(String[] args) {
		// 인자3개를 가진 명시적생성자를 이용해서 객체생성
		// 파라메터에 출생년일을 넣어서 출력해보세요
     
	  MyDate my1=new MyDate(1988, 10, 20);
	  
	  //츨력
	  
	  System.out.println(my1.getYear()+"년"+my1.getMonth()+"월"+my1.getDay()+"일");
	}

}
