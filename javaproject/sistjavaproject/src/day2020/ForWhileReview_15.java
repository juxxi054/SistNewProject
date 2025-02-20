package day2020;

public class ForWhileReview_15 {
	
	public static void sumTest1() {
		//for문으로 1~5까지 구하기
		int sum=0;
	    for(int i=1;i<=5;i++)
	    {
	    	sum+=i; // sum=sum+1
	    }
		System.out.println("총합계는"+sum+"입니다");
	}

	
	public static void sumTest2() 
	{
		// 1~10까지중 홀수의 합 1,3,5,7,9
		int sum=0;
		for(int i=1;i<=10;i+=2)
		{
			sum+=i;
		}
		System.out.println("홀수의 합"+sum+"입니다");
	}
	
	public static void sumTest3() {
		
		int sum=0;
		int i;
		for(i=1;i<=10;i++)
		{
			sum+=i;
		}
		System.out.println("1부터"+(i-1)+"까지의 합은"+sum);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//sumTest1();
		//sumTest2();
		//sumTest3();
	}

}
