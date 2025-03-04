package day0304;


//super
class Color{
	
	public void hello() {
		System.out.println("Hello");
	}
}

//sub1
class Red extends Color{
	
	public void process()
	{
		System.out.println("나는 빨강색을 좋아해");
	}
}
//sub2

class Green extends Color{
	
	public void process()
	{
		System.out.println("나는 초록색을 좋아해");
	}
}
//sub3
class Orange extends Color{
	
	public void process()
	{
		System.out.println("나는 주황색을 좋아해");
	}
	
}
public class E7InheritDa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         System.out.println("1.Red로 선언하고 Red로 생성한경우");
         Red red=new Red();
         red.hello();
         red.process();
         
         System.out.println("2.Grean으로 선언하고  Grean으로 생성한경우");
         Green Green=new Green();
         Green.hello();
         Green.process();

         System.out.println("3.Orange로 선언하고  Orange로 생성한경우");
        Orange Orange=new Orange();
         Orange.hello();
         Orange.process();
         
         //다향성_부모로 선언하고 자식으로 생성하는 경우
         Color col1; //선언
         col1=new Red(); //생성	
         
         col1.hello(); //부모가 가진 메소드 호출도 가능
         //메서드가 오버라이드 된 경우 호출 가능
         //부모한텐 없고 자식만 갖고있는 메소드는 호출안됨 (col1.process();) 불가능
	}

}
