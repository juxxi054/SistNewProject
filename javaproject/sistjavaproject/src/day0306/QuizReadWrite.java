package day0306;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
	
public class QuizReadWrite {
	
	static final String sangpumAdd="C:\\sist0217\\work\\sangpum.txt";
	FileWriter fw;
	FileReader fr;
	BufferedReader br;
	Scanner sc=new Scanner(System.in);

	
	public int getMenu()
	{
		int num;
		System.out.println("1.상품추가 2.전체상품출력 9.종료");
		num=Integer.parseInt(sc.nextLine());
		return num;
	}
	
	//입력후 파일에 저장  sangpumAdd() 
	//fw.write(상품명+","+수량+","+"단가"+"\n");
	public void  sangpumAdd()
	{
		 System.out.println("상품명");
		 String name=sc.nextLine();
		 System.out.println("수량");
		 int su=Integer.parseInt(sc.nextLine());
		 System.out.println("단가");
		 int dan=Integer.parseInt(sc.nextLine());
		 
		 try {
			fw=new FileWriter(sangpumAdd,true);
			
			fw.write(name+"\n");
			fw.write(su+"\n");
			fw.write(dan+"\n");
			
			System.out.println("상품정보가 추가됨");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	//전체출력   sangumAllDatas()
		//수량이 10개이상이면 금액의 10프로 할인
		//번호  상품명    수량    단가    금액   할인   총금액
	
	
	public void sangpumAllData()
	{
		System.out.println("번호\t상품명\t수량\t단가\t금액\t할인\t총금액");
		System.out.println("-----------------------------------");
		
		int num=0;
		int total=0;
		
		try {
			fr=new FileReader(sangpumAdd);
			br=new BufferedReader(fr);
			
			while(true)
			{
				
					String s=br.readLine();
				   if(s==null)
					   break;
				   String [] d=s.split(",");
				   String sang=d[0];
				   int su=Integer.parseInt(d[1]);
				   int dan=Integer.parseInt(d[2]);
				
				   int sum=su*dan;
				   int dcprice=getDiscount(su,sum);
				   int netPrice=sum-dcprice;
				   //전체총금액
				   total+=netPrice;
				   System.out.println(++num+"\t"+sang+"\t"+su+"\t"+dan+"\t"+dcprice+"\t"+netPrice);
			}
			System.out.println();
			System.out.println("\t\t\t전체총금액="+total+"원");
			
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
		}finally {
			 try {
				 br.close();
				 fr.close();
			 } catch (IOException e) {
		// TODO Auto-generated catch block
			e.printStackTrace(); 
			 }
		}
	}
	//수량에따른 가격할인 메서드
		public int getDiscount(int su,int sum)
		{
			int dc=0;
			if(su>=10)
				dc=sum*1/10;
				
			
			return dc;
		}
		
		
		//파일삭제
		public void deleteSangpum()
		{
			//파일삭제 
			//File객체를 생성..만일 파일이 존재한다면 삭제
			File file=new File(sangpumAdd);
			
			if(file.exists())
				file.delete();
			
			System.out.println("**모든 데이터가 삭제되었습니다**");
			
			
		}
	
	
	//1번이면 입력메서드 호출..2번이면 출력메서드호출  9번이면 종료
     public void process() {
    	 while (true)
    	 {
    		 int num=getMenu();
    		 switch(num)
    		 {
    		 case 1:
    			 System.out.println("상품 정보를 출력합니다");
    			 sangpumAdd();
    			 break;
    		 case 2:
 				System.out.println("상품정보를 출력합니다");
 				sangpumAllData();
 				break;
 			case 3:
 				System.out.println("파일을 삭제합니다");
 				deleteSangpum();
 				break;
    		 case 9:
    			 System.out.println("프로그램을 종료 합니다");
    			 System.exit(0); //강제종료
    		 }
    	 }
     }
	
	private void sangumAllDatas() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuizReadWrite quiz=new QuizReadWrite();
		quiz.process();
	}

}
