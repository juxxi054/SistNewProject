package day2021;

public class GuguGaro_12 {

	public static void main(String[] args) {
		/* 구구단 컨설창의 가로로 츨력
		 * [2단]    [3단]   -단일for문
		 * 
		 * 2x1=2   3x1=3   -다중for문
		 * 2x2=4   3x2=6
		 */
		
		System.out.println("\t가로방향 구구단 출력");
		
		for(int dan=2;dan<=9;dan++)
		{
			System.out.print("["+dan+"단]\t");
				
		}	
		System.out.println();
			for(int j=1;j<=9;j++)
			{
				for(int dan=2;dan<=9;dan++)
				{
					System.out.print(dan+"X"+j+"="+dan*j+"\t");
				}
				System.out.println();
			}
					
			
		}
	}


