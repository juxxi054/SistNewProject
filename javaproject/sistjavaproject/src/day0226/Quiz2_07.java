package day0226;

import java.util.Scanner;

public class Quiz2_07 {
	public static void quiz1()
	{
		//문제1.숫자n을 입력하면 1부터 n까지의 합계를 입력하세요
		//1부터 n까지의 합계: ***
		
		Scanner scanner=new Scanner(System.in);
		int n;
		int sum=0;
		
		System.out.println("숫자를 입력하세요");
		int n=scanner.nextInt();
						
		for(int i=1;i<=n;i++)
		{
			sum+=i;
		}
		System.out.println("숫자를 입력하세요");
	}
	public static void quiz2()
	
	{
		//문제2. 5명의 나이를 입력후 40세 이상과 40세 미만이 각각 몇명인지 출력하고 
		//평균도 구하시오 (for)
		//40세 이상 인원수:3
		//40세 미만 인원수:2
		//평균 나이: **세
		
		Scanner scanner=new Scanner(System.in);
		int tage=0;
		int a=0;
		int b=0;
		
		for(int i=1;i<=5;i++)
		{
			System.out.println(i+"번째 나이를 입력하세요");
			int age=scanner.nextInt();
			
			if (age>=40) 
			{
				a++;
			}
			else
			{
				b++;
			
			}
			
			tage +=age;
			
		}
			
			double avg=tage/5.0;
			
			System.out.println("40세 이상 인원수"+a);
			System.out.println("40세 이상 인원수"+b);
			System.out.println("평균나이"+avg+"세");
			
	}
	
	
	public static void quiz3()
	{
		/*배열에 1~50 사이의 난수 20개를 구하여 넣고
		 * 오름 차순으로 정렬하여 출력하시오 */
		int [] nums=new int [20];
	}
	// 난수 생성기를 위한 Random 객체 생성
    Random random = new Random();
    
    // 크기가 20인 배열 생성
    int[] nums = new int[20];
    
    // 배열에 1~50 사이의 난수 20개 입력
    for (int i = 0; i < nums.length; i++) {
        nums[i] = random.nextInt(50) + 1; // 1~50 사이의 난수
    }

    // 배열을 오름차순으로 정렬
    Arrays.sort(nums);

    // 정렬된 배열 출력
    System.out.println("오름차순으로 정렬된 난수: ");
    for (int num : nums) {
        System.out.print(num + " ");
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
