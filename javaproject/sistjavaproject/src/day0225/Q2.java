package day0225;

import java.util.Scanner;

public class Q2 {

	public static void main(String[] args) {
		/* 
		 * 성을 입력시 그성씨를 가진 사람과 총인원수를 출력할것!!!
		 * 종료라고 입력시 프로그램 종료
		 * 
		 * 검색할 성을 입력해주세요
		 * 손
		 * 3:손흥민
		 * 7:손미나
		 * 총 2명 검색
		 * 검색할 성을 입력해주세요
		 * 전
		 * 전 씨 성을 가진 연예인은 없습니다
		 * 검색할 성을 입력해주세요
		 * 종료
		 * 검색을 종료 합니다
		 * 
           */
       
		String [] celeb= {"공유","신민아","이정재","손흥민","이강인","이효리","이진","손미나"};
		Scanner sc=new Scanner(System.in);
		String seng;
		boolean find;
		
		while(true)
		 {
        	System.out.println("검색할 성을 입력하세요");
        	seng=sc.nextLine();
        	
        	//종료
        	if(seng.equals("종료") )
        	{
        		System.out.println("검색을 종료합니다");
        		break;
        	}
        		find=false;
        		
        		int cnt=0; //검색할때 마다 0으로 초기화가 필요함
        		
        		for (int i=0;i<celeb.length;i++)
        		{
        			if (celeb[i].startsWith(seng))
        			{
        				cnt++;
        				System.out.println(i  + ":" + celeb[i]);
                             find = true;
        			}
        		}
        		
        		//if (find) //find==true
                   // System.out.println("총 " + cnt + "명 검색");
                //else {
                   // System.out.println(seng + " 씨 성을 가진 연예인은 없습니다");
        		//}
                    if (cnt== 0) 
                        System.out.println(seng + " 씨 성을 가진 연예인은 없습니다");
             
                     else 
                        System.out.println("총 " + cnt + "명 검색");
            		
    			}
			}
	}


