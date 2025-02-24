package day0224;

public class ArryIntTest_06 {

	public static void main(String[] args) {
		// 배열선언하면서 초기값들을 저장 할수 있다
		
		int [] arr= {8,6,11,32,100,99,55}; //8이 0번지로 고정
        
		System.out.println("arr의 갯수:"+arr.length);
		
		
		System.out.println("**출력방법1_for***"); //0:8
		
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(i+":"+arr[i]);
		}
		
		System.out.println("**출력방법2_for~each**"); //8
		
		for(int a:arr)
		{
			System.out.println(a);
		}
		
	}

}
