package day0224;

public class Quiz0224 {

	public static void main(String[] args) {
		// 번호 이름 자바 오라클 스프링 총점 평균 등수
		//=================================
		// 1  이승훈 90  89   100  **   **.* 1
		
		String [] name= {"이승훈","한정민","김우형","박소라"};
		int[] java= {90,77,88,45};
		int[] oracle= {89,56,79,98};
		int[] spring= {100,89,99,79};
		int[] tot=new int[4];
		double[] avg=new double[4];
		int[] rank=new int[4];
        
		//총점
		for(int i=0;i<4;i++)
		{
		 tot[i]=java[i]+oracle[i]+spring[i];
		 avg[i]=tot[i]/3.0;
		}
		for(int i=0;i<4;i++)                         
		{
			rank[i]=1;
			for(int j=0;j<4;j++)
			{
				if(tot[i]<tot[j])
				{
					rank[i]++;
			}
		}
	}
     for(int i=0;i<4;i++)
     {
    	 System.out.printf("%d  %s  %d  %d  %d  %d  %.1f  %d\n",
                 i + 1, name[i], java[i], oracle[i], spring[i], tot[i], avg[i], rank[i]);
     }
}
}