package day0219;

public class OperTest_06 {

	public static void main(String[] args) {
		// 대입연산자 +=,-=,*=,/=
		
		int a,b,c,d,e;
		a=b=c=d=e=10;
		
		a+=2; // a=a+2
		b-=3;
		c*=2;
		d/=3;
		e%=3;
		
		System.out.println("a="+a); //12
		System.out.println("b="+b); //7
		System.out.println("c="+c); //20
		System.out.println("d="+d); //3
		System.out.println("e="+e); //1
		

	}

}
