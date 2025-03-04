package day0304;

//interface ==>interface : extends
//class==>interface: implements
//class==>class : extends

interface InterA{
	
	public void play();
	public void write();
}

interface InterB{
	
	public void draw();
	
}

//2개의 인터페이스를 구현하는 클래스..다중구현이 가능

class InterImp implements InterA,InterB{

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("그림 그리기");
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
	 System.out.println("만화 보기");
	}

	@Override
	public void write() {
		// TODO Auto-generated method stub
	System.out.println("기타 연주");
	
	
}

}

public class Ex12InterfaceMain {

	public static void main(String[] args) {
		// 일반객체생성으로 출력
		InterImp imp1=new InterImp();
		imp1.draw();
		imp1.play();
		imp1.write();
		
		System.out.println("----------------");
		//다형성으로 메서드 출력
		InterA inA=new InterImp();
		inA.play();
		inA.write();
		
		System.out.println("----------------");
		
		InterB inB=new InterImp();
	    inB.draw();
	}

}
