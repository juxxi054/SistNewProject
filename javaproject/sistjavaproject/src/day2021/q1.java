package day2021;
import java.util.Scanner;
public class q1 {

	public static void main(String[] args) {

			/* while true문 이용
			 * 나이를 반복해서 입력 받는다 0이되면 빠져나와 출력
			 * 나이가 50이상이면  a변수 증가
			 * 나이가 30이상이면  b변수 증가
			 *  나머지는 c변수 증가
			 *  ==============
			 *  나이입력:53
			 *  나이입력:47
			 *  나이입력:66
			 *  나이입력:35
			 *  나이입력:11
			 *  나이입력:12
			 *  ==============
			 *  50세 이상:2명
			 *  30세 이상:3명
			 *  그외: 2명
			 */
		 Scanner sc = new Scanner(System.in);
	        int num = 0, a = 0, b = 0, c = 0;
	        
	        while (true) {
	            System.out.print("나이입력: ");
	            num = sc.nextInt();
	            
	           
	            if (num == 0) {
	                System.out.println("종료");
	                break;  
	            }

	           
	            if (num >= 50) {
	                a++; 
	            } else if (num >= 30) {
	                b++;  
	            } else {
	                c++;  
	            }
	        }

	        
	        System.out.println("===============");
	        System.out.println("50세 이상: " + a + "명");
	        System.out.println("30세 이상: " + b + "명");
	        System.out.println("그외: " + c + "명");

	        
	}

}
