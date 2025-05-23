package day0226;

public class ArrayDacha_03 {

	public static void main(String[] args) {
		// 다차원배열 생성 초기화
		
		int[][] arr;
		arr=new int[2][3]; //2행3열 메모리에 할당
		
		arr[0][0]=10;
		arr[0][1]=20;
		arr[0][2]=30;
		
		arr[1][0]=40;
		arr[1][1]=50;
		arr[1][2]=60;
		
		System.out.println("행의 갯수:"+arr.length); //2
		System.out.println("0행의 갯수:"+arr[0].length); //3
		System.out.println("1행의 갯수:"+arr[1].length); //4
		
		System.out.println("**다차원 배열 데이터 출력**");
		for(int i=0;i<arr.length;i++) //행
		{
	     for(int j=0;j<arr[i].length;j++)
	     {
	    	// System.out.print(arr[i][j]+"\t");
	    	 System.out.printf("%d,%d=%2d\t",i,j,arr[i][j]);
	     }
	     System.out.println();
		}
		
		System.out.println("2차원 배열에 값변경후 다시 출력");
		arr[0][1]=100;
		arr[1][0]=200;
		arr[1][2]=300;
		
		for(int i=0;i<arr.length;i++) //행
		{
	     for(int j=0;j<arr[i].length;j++)
	     {
	    	// System.out.print(arr[i][j]+"\t");
	    	 System.out.printf("%d,%d=%2d\t",i,j,arr[i][j]);
	     }
	     System.out.println();
		}
	}

}
