package day0226;

public class ArrayDachaScore_05 {

	public static void main(String[] args) {
		// 다차원배열로 성적표 출력
        /* 이름 자바 오라클 스프링 총점
         * 이상희 88 77     88  **
         * 김지민 77 55     99  **
         * 손주연 66 77     77  **
         */
		
		String [] name= {"이상희","김지민","손주연"};
		int [][] score= {{88,77,88,0},{77,55,99,0},{66,77,77,0}};
		
		//출력
		
		//총점구하기
		for(int i=0;i<score.length;i++)
		{
			for(int j=0;j<3;j++)
			{
				//각각의 행의 3열에만 누적
				score[i][3]+=score[i][j];
			}
		}
		
		System.out.println("이름\t자바\t오라클\t스프링\t총점");
		for(int i=0;i<name.length;i++)
		{
			System.out.println(name[i]+"\t");
			//  점수와 총점은 열갯수만큼 반복해서 출력
			
			for(int j=0;j<score[i].length;j++)
			{
				System.out.print(score[i][j]+"\t");
			}
			System.out.println();
		}
	}

}
