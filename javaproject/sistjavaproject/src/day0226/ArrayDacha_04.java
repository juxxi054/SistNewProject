package day0226;

public class ArrayDacha_04 {

	public static void main(String[] args) {
		// 다차원 배열 선언과 동시에 초기화
		
		int [][] arr= {
				       {22,33},
				       {44,55,66},
				       {77,88,99,100}
				       
				       
		    };
		
		//출력
		System.out.println("총행갯수"+arr.length);
		System.out.println("총행갯수"+arr[0].length);
		System.out.println("총행갯수"+arr[1].length);
		System.out.println("총행갯수"+arr[2].length);
		
		//출력
		//[0][0]=22....행열 맞춰 해보세요
		
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
			{
				System.out.printf("[%d][%d]=%d\t",i,j,arr[i][j]);
			}
			System.out.println();
		}
		 //for~each 출력
		
		for(int [] a:arr)
		{
			for(int n: a)
			{
				System.out.print(n+"\t");
			}
			System.out.println();
		}
		
	}

}
