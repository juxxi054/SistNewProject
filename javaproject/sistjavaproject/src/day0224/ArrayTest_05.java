package day0224;

public class ArrayTest_05 {

	public static void main(String[] args) {
		// 문자배열 선언 및 초기화
        String [] str;
        str=new String[5];  //5개의 주소값 할당 초기값 지정안해도 null로 초기화

	     //초기값 지정안하고 출력
        for(int i=0;i<str.length;i++)
        { 
        	System.out.println(i+":"+str[i]);
        }
        //초기값 지정
        str[0]="이정민";
        str[1]="윤수정";
        str[2]="김수민";
        str[3]="이준혁";
        str[4]="한서아";
        
        //초기값 지정출력
        for(int i=0;i<str.length;i++)
        {
        	System.out.println((i+1)+":"+str[i]);
        }
        //for~each로 출력 (자료형 변수명:배열명
        for(String s:str)
        {
        	System.out.println(s);
        }
	}

}
