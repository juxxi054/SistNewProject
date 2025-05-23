package day0219;

public class OverTest_02 {

	public static void main(String[] args) {
		// 증감연산자 ++,--
		
		int a,b;
		a=b=5;
		
		//단항일경우에는 앞에 붙히나 뒤에 붙이나 같다
		++a; //원래 a에서 1증가
		b++; //b=b+1
		
		System.out.println("a="+a+", b="+b);
		
		// 수식일경우에는 전치,후치가 결과값이 다르다
		
		int m,n;
		m=n=0;
		a=b=5;
		
		m=a++; // 후치일경우에는 먼저 증가후 대입
		
		System.out.println("m="+m+" , a="+a); //m:5 a:6
		
		n=++b; //전치일 경우에는 먼저 증가후 대입
		System.out.println("n="+n+" ,b="+b);
		
		
	}

}
