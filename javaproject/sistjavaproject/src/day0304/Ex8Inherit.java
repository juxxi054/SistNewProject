package day0304;


//super

class Work{
	
	public void process() {
		System.out.println("아무 작업도 하지 않는다");
	}
}

//sub1
class Food extends Work{
	@Override
	public void process() {
		// TODO Auto-generated method stub
		super.process();
		System.out.println("음식을 만드는 작업을 담당합니다");
	
}
}

//sub2
class Clean extends Work{
	@Override
	public void process() {
		// TODO Auto-generated method stub
		super.process();
		System.out.println("청소를 담당합니다");
	}
}

public class Ex8Inherit {

	public static void main(String[] args) {
		// 다형성이란 하나의 변수로 자식중 누가 생성되었느냐에 따라 그기능이 달라지는데 이를 다형성이라함 생성
		//부모선언 자식으로 생성
		
		
		Work work;
		work=new Food();
		work.process();
		
		work=new Clean();
		work.process();

	}

}

