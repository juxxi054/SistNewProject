package day0226;

public class Ex8Object {
	
	String name; //인스턴스 멤버변수..인스턴트 변수로 호출가능.. 객체생성후 각각 다른값을 가질수있다
	static final String MESSAGE="Happy Day"; 
	//static은 주로 상수선언할때 인스턴트변수없이 클래스명으로 접근가능

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    
		System.out.println("static 멤버변수는 new로 생성없이 호출가능하다");
		System.out.println(Ex8Object.MESSAGE); //클래스명,변수명으로 호출가능
		System.out.println(MESSAGE); //같은클래스 내에서는 클래스명 생략 가능
		
		//MESSAGE 초기값 재지정
		//MESSAGE="오늘 따뜻하다"; //FINAL이라서 값변경 안됨
		
	    Ex8Object ab=new Ex8Object(); //클래스명 참조변수명=NEW 클래스명()"
	    Ex8Object cd=new Ex8Object();
	    Ex8Object ef=new Ex8Object();
	    
	    ab.name="주히";
	    cd.name="우식";
	    ef.name="주혁";
	    
	    System.out.println(ab.name); 
	    System.out.println(cd.name);
	    System.out.println(ef.name);
	    
	    System.out.println("다같이 사용하는 메세지:"+MESSAGE);
	}

}
