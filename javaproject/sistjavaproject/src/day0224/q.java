package day0224;

public class q {

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
				for(int i=0;i<name.length;i++)
				{
				 tot[i]=java[i]+oracle[i]+spring[i];
				 avg[i]=tot[i]/3.0;
				}
				for(int i=0;i<name.length;i++)                         
				{
					rank[i]=1;   //순위배열을 1등으로 초기화
					for(int j=0;j<name.length;j++)
					{
						if(tot[i]<tot[j])
						{
							rank[i]++;
					}
				}
			}
		     for(int i=0;i<name.length;i++)
		     {
		    	System.out.println( i + 1+"\t"+ name[i]+"\t"+ java[i]+"\t"+oracle[i]+"\t"+ spring[i]+"\t"+ tot[i]+"\t"+avg[i]+"\t"+rank[i]);
		              
		     }
	}

}
