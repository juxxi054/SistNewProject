package day2021;

public class GuguBreak_06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		for(int i=2;i<=9;i++)
		{
			for(int j=1;j<=9;j++)
			{
				if(j==5)
					break;
				System.out.println(i+"x"+j+"="+i*j);
			}
			System.out.println();
		}
		//반복문앞에 이름을 붙혀 break 사용함으로서 둘이상의 반복문을 빠져나가는것이 가능
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
