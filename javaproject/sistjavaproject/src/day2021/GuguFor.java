package day2021;

public class GuguFor {

	public static void main(String[] args) {
		// 2~9단까지의 구구단
		
		for(int dan=2;dan<=9;dan++) //단
		{
			for(int j=1;j<=9;j++)
			{
				System.out.println(dan+"X"+j+"="+dan*j);
			}
			System.out.println();
		}

	}

}
