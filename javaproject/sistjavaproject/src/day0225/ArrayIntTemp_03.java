package day0225;

public class ArrayIntTemp_03 {

	public static void main(String[] args) {
		// 정렬을 알기전에 순서바꾸기 먼저 연습
		
		int a=10,b=20;
		System.out.println("a="+a+", b="+b);
		
		int temp; //임시저장소
		
		temp=a;
		a=b;
		b=temp;
		
		System.out.println("a="+a+", b="+b);
		
		//3개이상은 배열로 테스트
		
		int[] nums= {3,6,9};
		for(int n:nums)
			System.out.println(n+" ");
		
		System.out.println("0번과 2번을 교환후 출력");
		
		int temp2=nums[0];
		nums[0]=nums[2];
		nums[2]=temp2;
		
		for(int n:nums)
			System.out.println(n+" ");
	}

}
