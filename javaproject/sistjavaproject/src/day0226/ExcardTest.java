package day0226;

public class ExcardTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Ex9card.width=10;
		Ex9card.height=20;
		
		System.out.println(Ex9card.width);
		System.out.println(Ex9card.height);
		
		//인스턴스 변수생성
		Ex9card c1=new Ex9card();
		
		System.out.println(c1.kind);  //null
		System.out.println(c1.number); //0
		
		//c2생성해서 heart,7로 변경
        Ex9card c2=new Ex9card();
        
        c2.kind="heart";
        c2.number=7;
        
        System.out.println(c2.kind);
        System.out.println(c2.number);
        
        //c3생성
        Ex9card c3=new Ex9card();
        c2.kind="diamond";
        c2.number=9;
        
        System.out.println(c3.kind+","+c3.number+","+Ex9card.width+","+Ex9card.height);
        System.out.println(c2.kind+","+c2.number+","+Ex9card.width+","+Ex9card.height);
        
	}

}
