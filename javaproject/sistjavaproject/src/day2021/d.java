package day2021;

public class d {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		loop: for(int i=2;i<=9;i++)
		{
			for(int j=1;j<=9;j++)
			{
				if(j==5)
					break loop;
				System.out.println(i+"x"+j+"="+i*j);
			}
			System.out.println();
		}
	}

}
