package day0227;


class YourInfo{
	
	String  myName;
	static String Message;
	
}

public class Ex7InfoTest {
	
	String city; //사는지역
	int age;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*[개인정보]
		 * 주민명:민영기
		 * 메세지:행복하게 살자
		 * 지역:대전
		 * 나이:23세
		 */
		 System.out.println("[주민정보]");
		 
		YourInfo you1=new YourInfo();
		you1.myName="민영기";
		System.out.println("주민명:"+you1.myName);
		
		YourInfo.Message="행복하게 살자";
				System.out.println(YourInfo.Message);
				
	 Ex7InfoTest	in1=new Ex7InfoTest();
	 in1.city="대전";
	 System.out.println("지역:"+in1.city);
	 
	 Ex7InfoTest	in2=new Ex7InfoTest();
	 in2.age=23;
	 System.out.println("나이:"+in2.age+"세");
	 
	 
	}

}
